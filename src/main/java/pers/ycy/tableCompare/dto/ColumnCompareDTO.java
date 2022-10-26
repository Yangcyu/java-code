package pers.ycy.tableCompare.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @title: ColumnCompareDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
@Data
public class ColumnCompareDTO {

    /**
     * 字段名称
     */
    @ApiModelProperty(value = "字段名称-pri key")
    private String columnName1;

    /**
     * 字段说明
     */
    @ApiModelProperty(value = "字段说明")
    private String columnComment1;

    /**
     * 字段类型
     */
    @ApiModelProperty(value = "字段类型")
    private String dataType1;

    /**
     * 字段名称
     */
    @ApiModelProperty(value = "字段名称-pri key")
    private String columnName2;

    /**
     * 字段说明
     */
    @ApiModelProperty(value = "字段说明")
    private String columnComment2;

    /**
     * 字段类型
     */
    @ApiModelProperty(value = "字段类型")
    private String dataType2;

    @ApiModelProperty(value = "类型相同")
    private Boolean TypeSame;

    @ApiModelProperty(value = "注释相同")
    private Boolean CommentSame;
}
