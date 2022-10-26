package pers.ycy.javacode.mvcgen.dtoGenerate.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.ColumnInfoDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;

/***
 * @title: DTOFileDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
@Data
public class DTOFileDTO {

    @NotBlank(message = "类路径不能为空")
    @ApiModelProperty(value = "类路径")
    private String packageName;

    @NotBlank(message = "类名称不能为空")
    @ApiModelProperty(value = "类名称")
    private String dtoName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "属性值")
    private List<ColumnInfoDTO> columnInfoDTOS;

}
