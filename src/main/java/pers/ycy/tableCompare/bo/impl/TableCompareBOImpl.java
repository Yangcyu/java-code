package pers.ycy.tableCompare.bo.impl;

import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.mybatis.generator.internal.util.JavaBeansUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.ColumnInfoDTO;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.TableInfoDTO;
import pers.ycy.tableCompare.bo.TableCompareBO;
import pers.ycy.tableCompare.config.JDBCConnection;
import pers.ycy.tableCompare.dto.ColumnCompareDTO;
import pers.ycy.tableCompare.dto.ScheamCompareDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @title: TableCompareBOImpl
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
@Service
public class TableCompareBOImpl extends JavaTypeResolverDefaultImpl implements TableCompareBO {


    public static final Integer BOTH_HAVE = 3;

    public static final Integer DB1_HAVE = 1;

    public static final Integer DB2_HAVE = 2;


    @Autowired
    private JDBCConnection jdbcConnection;

    @Override
    public ScheamCompareDTO getTableCompareResult() throws Exception {
        ScheamCompareDTO scheamCompareDTO = new ScheamCompareDTO();
        //比较表
        List<ColumnCompareDTO> compareList = new ArrayList<>();
        Map<TableInfoDTO, Integer> map = getTableResult();
        for (Map.Entry<TableInfoDTO, Integer> entry : map.entrySet()) {
            if (BOTH_HAVE.equals(entry.getValue())) {
                //比较共有表的列
                List<ColumnCompareDTO> list = getColumnResult(entry.getKey().getTableName(), false, false);
                compareList.addAll(list);
            }
        }
        scheamCompareDTO.setMap(map);
        scheamCompareDTO.setCompareDTOS(compareList);
        System.out.println(scheamCompareDTO);
        return scheamCompareDTO;
    }

    /**
     * @Description: 获取库表对比结果，以英文表名称做对比，值为1为数据库1独有，值为2为数据库2独有，值为3为两个库共有；
     * @Param: []
     * @Return: java.util.Map
     * @Author: yangchenyu
     * @Date: 2021/9/13 5:13 下午
     */
    Map getTableResult() throws Exception {
        Map<TableInfoDTO, Integer> map = new HashMap();
        List<TableInfoDTO> tableInfoList1 = getTableInfo(jdbcConnection.getConnection());
        List<TableInfoDTO> tableInfoList2 = getTableInfo(jdbcConnection.getConnection2());
        for (TableInfoDTO dto1 : tableInfoList1) {
            map.put(dto1, DB1_HAVE);
        }
        for (TableInfoDTO dto2 : tableInfoList2) {
            map.put(dto2, map.get(dto2) + DB2_HAVE);
        }
        return map;
    }

    public List<ColumnCompareDTO> getColumnResult(String tableName, Boolean isType, Boolean isCommnet) throws Exception {
        List<ColumnCompareDTO> compareDTOList = new ArrayList<>();
        Map<ColumnInfoDTO, ColumnInfoDTO> map = new HashMap();
        List<ColumnInfoDTO> columnInfoDTOList1 = getColumnsByTable(jdbcConnection.getConnection(), tableName);
        List<ColumnInfoDTO> columnInfoDTOList2 = getColumnsByTable(jdbcConnection.getConnection2(), tableName);
        List<ColumnInfoDTO> bothHave = new ArrayList<>(columnInfoDTOList1);
        bothHave.retainAll(columnInfoDTOList2);
        for (ColumnInfoDTO dto : columnInfoDTOList1) {
            map.put(dto, dto);
            if (!bothHave.contains(dto)) {
                ColumnCompareDTO compareDTO = new ColumnCompareDTO();
                compareDTO.setColumnName1(dto.getColumnName());
                compareDTO.setDataType1(dto.getDataType());
                compareDTO.setColumnComment1(dto.getColumnComment());
                compareDTOList.add(compareDTO);
            }
        }
        for (ColumnInfoDTO dto2 : columnInfoDTOList2) {
            map.put(dto2, map.get(dto2));
            if (!bothHave.contains(dto2)) {
                ColumnCompareDTO compareDTO = new ColumnCompareDTO();
                compareDTO.setColumnName2(dto2.getColumnName());
                compareDTO.setDataType2(dto2.getDataType());
                compareDTO.setColumnComment2(dto2.getColumnComment());
                compareDTOList.add(compareDTO);
            }
        }
        for (Map.Entry<ColumnInfoDTO, ColumnInfoDTO> entry : map.entrySet()) {
            //字段名称一致
            ColumnCompareDTO compareDTO = new ColumnCompareDTO();
            if (entry.getKey().equals(entry.getValue())) {
                compareDTO.setColumnName1(entry.getValue().getColumnName());
                compareDTO.setDataType1(entry.getValue().getDataType());
                compareDTO.setColumnComment1(entry.getValue().getColumnComment());
                compareDTO.setColumnName2(entry.getKey().getColumnName());
                compareDTO.setDataType2(entry.getKey().getDataType());
                compareDTO.setColumnComment2(entry.getKey().getColumnComment());
                if (compareDTO.getDataType1().equals(compareDTO.getDataType2())) {
                    compareDTO.setTypeSame(true);
                } else {
                    compareDTO.setTypeSame(false);
                }
                if (compareDTO.getColumnComment1().equals(compareDTO.getColumnComment2())) {
                    compareDTO.setCommentSame(true);
                } else {
                    compareDTO.setCommentSame(false);
                }
                compareDTOList.add(compareDTO);
            }
        }

        return compareDTOList;
    }

    public List<ColumnInfoDTO> getColumnsByTable(Connection connection, String tableName) throws Exception {
        List<ColumnInfoDTO> columnInfoDTOList = new ArrayList<>();
        ResultSet rs = connection.getMetaData().getColumns(connection.getCatalog(), "%", tableName, (String) null);
        while (rs.next()) {
            ColumnInfoDTO dto = new ColumnInfoDTO();
            dto.setColumnName(rs.getString("COLUMN_NAME"));
            dto.setColumnComment(rs.getString("REMARKS"));
            dto.setDataType(rs.getString("DATA_TYPE"));
            dto.setTypeName(rs.getString("TYPE_NAME"));
            dto.setDataLength(rs.getInt("COLUMN_SIZE"));
            dto.setIsNullable(rs.getInt("NULLABLE"));
            dto.setDefaultValue(rs.getString("COLUMN_DEF"));
            dto.setJavaProperty(JavaBeansUtil.getCamelCaseString(dto.getColumnName(), false));
            JavaTypeResolverDefaultImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverDefaultImpl.JdbcTypeInformation) this.typeMap.get(Integer.parseInt(dto.getDataType()));
            dto.setBaseShortName(jdbcTypeInformation.getFullyQualifiedJavaType().getShortName());
            dto.setBaseQualifiedName(jdbcTypeInformation.getFullyQualifiedJavaType().getFullyQualifiedName());
            columnInfoDTOList.add(dto);
        }
        return columnInfoDTOList;
    }

    public List<TableInfoDTO> getTableInfo(Connection connection) throws Exception {
        List<TableInfoDTO> list = new ArrayList<>();
        ResultSet rs = connection.getMetaData().getTables(connection.getCatalog(), "%", null, new String[]{"TABLE"});
        while (rs.next()) {
            TableInfoDTO dto = new TableInfoDTO();
            dto.setTableName(rs.getString("TABLE_NAME"));
            dto.setRemarks(rs.getString("REMARKS"));
            list.add(dto);
        }
        return list;
    }
}
