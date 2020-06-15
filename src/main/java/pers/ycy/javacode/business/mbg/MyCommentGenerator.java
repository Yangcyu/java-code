package pers.ycy.javacode.business.mbg;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.kotlin.KotlinFile;
import org.mybatis.generator.api.dom.kotlin.KotlinFunction;
import org.mybatis.generator.api.dom.kotlin.KotlinProperty;
import org.mybatis.generator.api.dom.kotlin.KotlinType;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * mybatis generator 自定义comment生成器.
 */
public class MyCommentGenerator implements CommentGenerator {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void addConfigurationProperties(Properties properties) {

    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/******************************************");
        topLevelClass.addJavaDocLine(" * @Table: " + introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(" * @Description: " + introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(" * @author ycy");
        topLevelClass.addJavaDocLine(" * @date   " + sdf.format(new Date()));
        topLevelClass.addJavaDocLine(" ******************************************/");
    }

    @Override
    public void addModelClassComment(KotlinType modelClass, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        method.addJavaDocLine("/**");
        switch (method.getName()) {
            case "deleteByPrimaryKey":
                method.addJavaDocLine(" *@Description  根据主键删除");
                break;
            case "insert":
                method.addJavaDocLine(" *@Description  插入");
                break;
            case "selectByPrimaryKey":
                method.addJavaDocLine(" *@Description  根据主键查询");
                break;
            case "updateByPrimaryKeySelective":
                method.addJavaDocLine(" *@Description  根据主键，更新非空字段");
                break;
            case "updateByPrimaryKey":
                method.addJavaDocLine(" *@Description  根据字段非空更新");
                break;
            case "queryList":
                method.addJavaDocLine(" *@Description  根据dto查询，返回List");
                break;
            case "insertBatchSelective":
                method.addJavaDocLine(" *@Description  根据字段非空批量插入");
                break;
            case "insertSelective":
                method.addJavaDocLine(" *@Description  根据字段非空插入");
                break;
        }
        method.addJavaDocLine(" */");
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }

    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addRootComment(XmlElement xmlElement) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addFileComment(KotlinFile kotlinFile) {

    }

    @Override
    public void addGeneralFunctionComment(KotlinFunction kf, IntrospectedTable introspectedTable, Set<String> imports) {

    }

    @Override
    public void addGeneralPropertyComment(KotlinProperty property, IntrospectedTable introspectedTable, Set<String> imports) {

    }
}