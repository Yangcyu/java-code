package pers.ycy.javacode.mvcgen.dtoGenerate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/******************************************
 * @Table: column_info
 * @Description: 列信息
 * @author ycy
 * @date 2020-12-08
 ******************************************/
@ApiModel(value = "列信息")
@Data
public class ColumnInfoDTO implements Serializable {

    /**
     * 字段名称
     */
    @ApiModelProperty(value = "字段名称-pri key")
    private String columnName;

    /**
     * 字段说明
     */
    @ApiModelProperty(value = "字段说明")
    private String columnComment;

    /**
     * 字段类型
     */
    @ApiModelProperty(value = "字段类型")
    private String dataType;

    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private String typeName;

    /**
     * 字段长度
     */
    @ApiModelProperty(value = "字段长度")
    private Integer dataLength;

    /**
     * 校验语法
     */
    @ApiModelProperty(value = "校验语法")
    private String checkSyntax;

    /**
     * 是否主键
     */
    @ApiModelProperty(value = "是否主键")
    private Integer isPriKey;

    /**
     * 是否为空
     */
    @ApiModelProperty(value = "是否为空")
    private Integer isNullable;

    /**
     * 字典
     */
    @ApiModelProperty(value = "字典")
    private Integer code;

    /**
     * 默认值
     */
    @ApiModelProperty(value = "默认值")
    private String defaultValue;

    /**
     * 使用次数
     */
    @ApiModelProperty(value = "使用次数")
    private Integer usedNum;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updtTime;


    /**
     * java名
     */
    @ApiModelProperty(value = "Java属性名")
    private String javaProperty;

    /**
     * java类型
     */
    @ApiModelProperty(value = "Java类型")
    private String baseShortName;

    /**
     * java包路径
     */
    @ApiModelProperty(value = "Java包路径")
    private String baseQualifiedName;


    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColumnInfoDTO dto = (ColumnInfoDTO) o;
        return Objects.equals(columnName, dto.columnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnName);
    }
}
