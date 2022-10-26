package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.director;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;

/***
 * @title: BusinessCodeDirector
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
public class BusinessCodeDirector {

    private BusinessCodeBuilder businessCodeBuilder;

    public BusinessCodeDirector(BusinessCodeBuilder businessCodeBuilder) {
        this.businessCodeBuilder = businessCodeBuilder;
    }

    /**
     * @Description: 产品构建与组装方法
     * @Param: []
     * @Return: pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO
     * @Author: yangchenyu
     * @Date: 2021/6/29 4:15 下午
     */
    public JavaFile construct() throws Exception{
        businessCodeBuilder.buildInit();
        businessCodeBuilder.buildAnnotationSpecs();
        businessCodeBuilder.buildInterface();
        businessCodeBuilder.buildCodeBlock();
        businessCodeBuilder.buildFieldSpecs();
        businessCodeBuilder.buildMethods();
        businessCodeBuilder.buildSuperClass();
        return businessCodeBuilder.getJavaFile();
    }
}
