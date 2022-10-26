package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.concreteBuilder;

import com.squareup.javapoet.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.MethodConfigDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.enums.RequestTypeEnum;
import pers.ycy.javacode.mvcgen.common.util.CommentUtils;
import pers.ycy.javacode.mvcgen.common.util.MethodUtils;
import pers.ycy.javacode.mvcgen.common.util.TypeNameUtils;
import pers.ycy.javacode.system.MyException;

import javax.lang.model.element.Modifier;
import java.util.List;

/***
 * @title: BusinessCodeConcreteBuilder
 * @projectName java-code
 * @description: 代码生成具体实现类
 * @author yangchenyu
 * @date 2021-06-27
 */
public class ControllerCodeConcreteBuilder extends BusinessCodeBuilder {

    TypeSpec.Builder typeSpec;

    private CodeStructureDTO structureDTO;

    public ControllerCodeConcreteBuilder(CodeStructureDTO codeStructureDTO) {
        this.structureDTO = codeStructureDTO;
    }


    @Override
    public void buildInit() {
        typeSpec = TypeSpec.classBuilder(structureDTO.getBusinessName() + "Controller").addModifiers(Modifier.PUBLIC);
    }

    /**
     * @Description: 实现类
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildInterface() {

    }

    /**
     * @Description: 注释
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildCodeBlock() {
        typeSpec.addJavadoc(CommentUtils.getCommentInfo(structureDTO.getDescription()));
    }

    /**
     * @Description: 继承类
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildSuperClass() {

    }

    /**
     * @Description: 类注解
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildAnnotationSpecs() {
        AnnotationSpec restController = AnnotationSpec.builder(RestController.class).build();
        AnnotationSpec api = AnnotationSpec.builder(Api.class)
                .addMember("tags", "$S",structureDTO.getDescription())
                .build();
        AnnotationSpec requestMapping = AnnotationSpec.builder(RequestMapping.class)
                .addMember("value", "$S",structureDTO.getPackagePath().replace(".", "/"))
                .build();
        typeSpec.addAnnotation(restController).addAnnotation(api).addAnnotation(requestMapping);
    }

    /**
     * @Description: 属性
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildFieldSpecs() {
        ClassName className = ClassName.get(structureDTO.getPackagePath() + ".service", structureDTO.getBusinessName() + "Service");
        FieldSpec fieldSpec = FieldSpec.builder(className, StringUtils.uncapitalize(structureDTO.getBusinessName() + "Service"), Modifier.PRIVATE)
                .addAnnotation(Autowired.class)
                .build();
        typeSpec.addField(fieldSpec);
    }

    /**
     * @Description: 方法
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildMethods() throws MyException {
        List<MethodConfigDTO> methodDTOList = structureDTO.getMethodConfigDTOS();
        for (MethodConfigDTO dto : methodDTOList) {
            //注解构造
            AnnotationSpec requestType = AnnotationSpec.builder(RequestTypeEnum.getaClass(dto.getRequestType())).addMember("value", "$S","/" + dto.getMethodName()).build();
            AnnotationSpec apiOperation = AnnotationSpec.builder(ApiOperation.class).addMember("value","$S", dto.getMethodDesc()).build();
            //方法构造
            MethodSpec.Builder builder = MethodSpec.methodBuilder(dto.getMethodName());
            builder.addModifiers(Modifier.PUBLIC);
            builder.addAnnotation(apiOperation);
            builder.addAnnotation(requestType);
            builder.addJavadoc(dto.getMethodDesc());
            ClassName wrapperResponse = ClassName.get("cn.hsa.hsaf.core.framework.web","WrapperResponse");
            builder.returns(ParameterizedTypeName.get(wrapperResponse, TypeNameUtils.getTypeName(dto.getReturnStr(),structureDTO.getPackagePath()+".bo")));
            builder.addParameters(TypeNameUtils.getParameters(dto.getParameterStr(),structureDTO.getPackagePath()+".bo"));
            builder.addStatement("return " + StringUtils.uncapitalize(structureDTO.getBusinessName()) + "Service." + dto.getMethodName() + MethodUtils.getParameterName(TypeNameUtils.getParameters(dto.getParameterStr(),structureDTO.getPackagePath()+".bo")));
            builder.addException(Exception.class);
            MethodSpec methodSpec = builder.build();
            typeSpec.addMethod(methodSpec);
        }
    }

    @Override
    public JavaFile getJavaFile() {
        return JavaFile.builder(structureDTO.getPackagePath()+".controller", typeSpec.build()).build();
    }


}
