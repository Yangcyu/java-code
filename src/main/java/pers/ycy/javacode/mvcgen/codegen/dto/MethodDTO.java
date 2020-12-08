package pers.ycy.javacode.mvcgen.codegen.dto;

import lombok.Data;

/***
 * @title: MethodDTO
 * @projectName java-code
 * @description: 方法dto
 * @author yangchenyu
 * @date 2020-10-28
 */
@Data
public class MethodDTO {

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 方法描述
     */
    private String description;

    /**
     * 参数DTO的id;
     */
    private String paramDtoId;

    /**
     * 参数DTO的id;
     */
    private String returnDtoId;
}
