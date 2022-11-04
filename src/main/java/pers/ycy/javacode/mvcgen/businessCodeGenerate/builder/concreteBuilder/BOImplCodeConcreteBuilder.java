package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.concreteBuilder;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.MethodConfigDTO;
import pers.ycy.javacode.mvcgen.common.util.CommentUtils;
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
public class BOImplCodeConcreteBuilder extends BusinessCodeBuilder {

    TypeSpec.Builder typeSpec;

    private CodeStructureDTO structureDTO;

    public BOImplCodeConcreteBuilder(CodeStructureDTO codeStructureDTO) {
        this.structureDTO = codeStructureDTO;
    }

    @Override
    public void buildInit() {
        typeSpec = TypeSpec.classBuilder(structureDTO.getBusinessName()+"BOImpl").addModifiers(Modifier.PUBLIC);
    }

    /**
     * @Description: 实现接口
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildInterface() {
        ClassName className = ClassName.get(structureDTO.getPackagePath()+".bo",structureDTO.getBusinessName()+"BO");
        typeSpec.addSuperinterface(className);
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
        typeSpec.addAnnotation(Service.class);
    }

    /**
     * @Description: 属性
     * @Param: []
     * @Return: void
     */
    @Override
    public void buildFieldSpecs() {
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
            builder.returns(TypeNameUtils.getTypeName(dto.getReturnStr(),structureDTO.getPackagePath()+".dto"));
            builder.addParameters(TypeNameUtils.getParameters(dto.getParameterStr(),structureDTO.getPackagePath()+".dto"));
            builder.addAnnotation(Override.class);
            builder.addException(Exception.class);
            builder.addStatement("$T $N = null",TypeNameUtils.getTypeName(dto.getReturnStr(),structureDTO.getPackagePath()+".dto"),dto.getReturnName());
            builder.addStatement("return $N",dto.getReturnName());
            MethodSpec methodSpec = builder.build();
            typeSpec.addMethod(methodSpec);
        }
    }

    @Override
    public JavaFile getJavaFile() {
        return JavaFile.builder(structureDTO.getPackagePath()+".bo.impl", typeSpec.build()).build();
    }


}
