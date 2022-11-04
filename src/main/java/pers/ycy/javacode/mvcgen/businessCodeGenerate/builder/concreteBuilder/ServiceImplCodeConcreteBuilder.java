package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.concreteBuilder;

import com.squareup.javapoet.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.MethodConfigDTO;
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
public class ServiceImplCodeConcreteBuilder extends BusinessCodeBuilder {

    TypeSpec.Builder typeSpec;

    private CodeStructureDTO structureDTO;

    public ServiceImplCodeConcreteBuilder(CodeStructureDTO codeStructureDTO){
        this.structureDTO = codeStructureDTO;
    }

    @Override
    public void buildInit() {
        typeSpec = TypeSpec.classBuilder(structureDTO.getBusinessName()+"ServiceImpl").addModifiers(Modifier.PUBLIC);
    }

    /**
     * @Description: 实现接口
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildInterface() {
        ClassName className = ClassName.get(structureDTO.getPackagePath()+".service",structureDTO.getBusinessName()+"Service");
        typeSpec.addSuperinterface(className);    }
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
        typeSpec.addAnnotation(Service.class);
    }
    /**
     * @Description: 属性
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildFieldSpecs() {
        ClassName className = ClassName.get(structureDTO.getPackagePath() + ".bo", structureDTO.getBusinessName() + "BO");
        FieldSpec fieldSpec = FieldSpec.builder(className, StringUtils.uncapitalize(structureDTO.getBusinessName() + "BO"), Modifier.PRIVATE)
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
            //方法构造
            MethodSpec.Builder builder = MethodSpec.methodBuilder(dto.getMethodName());
            builder.addModifiers(Modifier.PUBLIC);
            builder.addJavadoc(dto.getMethodDesc());
            ClassName wrapperResponse = ClassName.get("cn.hsa.hsaf.core.framework.web","WrapperResponse");
            builder.returns(ParameterizedTypeName.get(wrapperResponse, TypeNameUtils.getTypeName(dto.getReturnStr(),structureDTO.getPackagePath()+".dto")));
            builder.addParameters(TypeNameUtils.getParameters(dto.getParameterStr(),structureDTO.getPackagePath()+".dto"));
            builder.addAnnotation(Override.class);
            builder.addStatement("return WrapperResponse.success(" + StringUtils.uncapitalize(structureDTO.getBusinessName()) + "BO." + dto.getMethodName() + MethodUtils.getParameterName(TypeNameUtils.getParameters(dto.getParameterStr(),structureDTO.getPackagePath()+".dto"))+")");
            builder.addException(Exception.class);
            MethodSpec methodSpec = builder.build();
            typeSpec.addMethod(methodSpec);
        }
    }

    @Override
    public JavaFile getJavaFile() {
        return JavaFile.builder(structureDTO.getPackagePath()+".service.impl", typeSpec.build()).build();
    }

}
