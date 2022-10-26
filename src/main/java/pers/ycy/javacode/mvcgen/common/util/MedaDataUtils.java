package pers.ycy.javacode.mvcgen.common.util;

import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.mybatis.generator.internal.util.JavaBeansUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.ColumnInfoDTO;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.TableInfoDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/***
 * @title: DTOUtils
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
@Service
public class MedaDataUtils extends JavaTypeResolverDefaultImpl {

    @Autowired
    private DataSource dataSource;


    public List<ColumnInfoDTO> getColumnsByTable(String tableName) throws Exception {
        Connection connection = dataSource.getConnection();
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

    public List<TableInfoDTO> getTableInfo() throws Exception {
        List<TableInfoDTO> list = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        ResultSet rs = connection.getMetaData().getTables(connection.getCatalog(), "%", null, new String[]{"TABLE"});
        while (rs.next()) {
            TableInfoDTO dto = new TableInfoDTO();
            dto.setTableName(rs.getString("TABLE_NAME"));
            dto.setRemarks(rs.getString("REMARKS"));

        }
        return list;
    }

}
