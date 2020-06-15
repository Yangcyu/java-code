package pers.ycy.javacode.business.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class GeneratorSwagger2Doc extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String classAnnotation = "@ApiModel(value=\"" + introspectedTable.getRemarks()+ "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation)) {
            topLevelClass.addAnnotation(classAnnotation);
        }

        String apiModelAnnotationPackage = this.properties.getProperty("apiModelAnnotationPackage");
        String apiModelPropertyAnnotationPackage = this.properties.getProperty("apiModelPropertyAnnotationPackage");
        if (null == apiModelAnnotationPackage) {
            apiModelAnnotationPackage = "io.swagger.annotations.ApiModel";
        }

        if (null == apiModelPropertyAnnotationPackage) {
            apiModelPropertyAnnotationPackage = "io.swagger.annotations.ApiModelProperty";
        }

        topLevelClass.addImportedType(apiModelAnnotationPackage);
        topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);
        field.addAnnotation("@ApiModelProperty(value=\"" + introspectedColumn.getRemarks() + "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }
}