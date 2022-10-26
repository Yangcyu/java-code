package pers.ycy.javacode.mvcgen.businessCodeGenerate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import lombok.Data;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.enums.RequestTypeEnum;
import pers.ycy.javacode.mvcgen.common.util.TypeNameUtils;
import pers.ycy.javacode.system.MyException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * @title: MethodConfigDTO
 * @projectName java-code
 * @description: 方法配置
 * @author yangchenyu
 * @date 2021-06-29
 */
@Data
public class MethodConfigDTO {

    /**
     * 名字
     */
    private String methodName;

    /**
     * 描述
     */
    private String methodDesc;

    /**
     * 请求方法
     */
    private RequestTypeEnum RequestType;


    /***
     * 出参名字
     */
    private String returnName;


    /***
     * 出参
     */
    private String returnStr;

    /***
     * 入参数
     */
    private String parameterStr;


}
