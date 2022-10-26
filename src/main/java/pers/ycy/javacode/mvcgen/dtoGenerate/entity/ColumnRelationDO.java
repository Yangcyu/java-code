package pers.ycy.javacode.mvcgen.dtoGenerate.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/******************************************
 * @Table: column_relation
 * @Description: 列关系
 * @author ycy
 * @date   2020-12-08
 ******************************************/
@ApiModel(value="列关系")
@Data
public class ColumnRelationDO implements Serializable {
    /**
     * 列关系id
     */
    @ApiModelProperty(value="列关系id")
    private Integer columnRelationId;

    /**
     * 列信息id
     */
    @ApiModelProperty(value="列信息id")
    private Integer columnInfoId;

    /**
     * 大类
     */
    @ApiModelProperty(value="大类")
    private String classifyBig;

    /**
     * 二类
     */
    @ApiModelProperty(value="二类")
    private String classifySmall;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String classifyName;

    private static final long serialVersionUID = 1L;
}
