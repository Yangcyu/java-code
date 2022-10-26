package pers.ycy.javacode.mvcgen.dtoGenerate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/******************************************
 * @Table: column_info
 * @Description: 列信息
 * @author ycy
 * @date   2020-12-08
 ******************************************/
@ApiModel(value="列信息")
@Data
@TableName(value = "column_info")
public class ColumnInfoDO implements Serializable {

    /**
     * 字段名称
     */
    @ApiModelProperty(value="字段名称-pri key")
    private String columnName;

    /**
     * 字段说明
     */
    @ApiModelProperty(value="字段说明")
    private String columnComment;

    /**
     * 字段类型
     */
    @ApiModelProperty(value="字段类型")
    private String dataType;

    /**
     * 字段长度
     */
    @ApiModelProperty(value="字段长度")
    private Integer dataLenth;

    /**
     * 校验语法
     */
    @ApiModelProperty(value="校验语法")
    private String checkSyntax;

    /**
     * 是否主键
     */
    @ApiModelProperty(value="是否主键")
    private Integer isPriKey;

    /**
     * 是否为空
     */
    @ApiModelProperty(value="是否为空")
    private Integer isNullable;

    /**
     * 字典
     */
    @ApiModelProperty(value="字典")
    private Integer code;

    /**
     * 默认值
     */
    @ApiModelProperty(value="默认值")
    private String defaultValue;

    /**
     * 使用次数
     */
    @ApiModelProperty(value="使用次数")
    private Integer usedNum;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updtTime;

    private static final long serialVersionUID = 1L;
}
