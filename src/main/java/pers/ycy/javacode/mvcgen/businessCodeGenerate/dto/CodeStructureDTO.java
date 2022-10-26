package pers.ycy.javacode.mvcgen.businessCodeGenerate.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @title: CodeStructureDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
@Data
public class CodeStructureDTO {

    @NotEmpty(message = "项目路径不能为空！")
    @ApiModelProperty(value = "项目路径", example = "", required = true)
    private String projectPath;

    @NotEmpty(message = "包路径不能为空！")
    @ApiModelProperty(value = "包路径", example = "", required = true)
    private String packagePath;

    @NotBlank(message = "业务关键词不能为空")
    @ApiModelProperty(value = "关键类名词")
    private String businessName;

    @ApiModelProperty(value = "描述")
    private String description;

    List<MethodConfigDTO> methodConfigDTOS = new LinkedList<>();

}
