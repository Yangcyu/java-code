package pers.ycy.javacode.mbg.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@ApiModel(value = "mbg配置")
@Data
public class MbgUiConfigDTO {

    @NotEmpty(message = "项目路径不能为空！")
    @ApiModelProperty(value = "项目路径", example = "/Users/yangchenyu/Desktop/test",required = true)
    private String projectPath;

    @NotEmpty(message = "entity路径不能为空！")
    @ApiModelProperty(value = "entity路径", example = "src/main/java",required = true)
    private String entityTargetProject;

    @NotEmpty(message = "entity包路径不能为空！")
    @ApiModelProperty(value = "entity包路径", example = "pers.ycy.javacode.business.demo.entity",required = true)
    private String entityTargetPackage;

    @NotEmpty(message = "dao路径不能为空！")
    @ApiModelProperty(value = "dao路径", example = "src/main/java",required = true)
    private String daoTargetProject;

    @NotEmpty(message = "dao包路径不能为空！")
    @ApiModelProperty(value = "dao包路径", example = "pers.ycy.javacode.business.demo.dao",required = true)
    private String daoTargetPackage;

    @NotEmpty(message = "mapper路径不能为空！")
    @ApiModelProperty(value = "mapper路径", example = "src/main/resources",required = true)
    private String mapperTargetProject;

    @NotEmpty(message = "mapper包路径不能为空！")
    @ApiModelProperty(value = "mapper包路径", example = "mapper",required = true)
    private String mapperTargetPackage;

    @NotEmpty(message = "表名不能为空！")
    @ApiModelProperty(value = "表名", example = "column_info",required = true)
    private String tableName;

    @ApiModelProperty(value = "文件名前缀", example = "columnInfo",required = true)
    private String domainObjectName;
}
