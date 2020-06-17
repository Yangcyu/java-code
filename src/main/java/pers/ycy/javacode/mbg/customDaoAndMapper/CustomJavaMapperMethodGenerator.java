package pers.ycy.javacode.mbg.customDaoAndMapper;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

/**
 * dao中添加自定义方法
 */
public class CustomJavaMapperMethodGenerator extends AbstractJavaMapperMethodGenerator {

    @Override
    public void addInterfaceElements(Interface interfaze) {

        addinterQueryList(interfaze);
        addInterfaceInsertBatchSelective(interfaze);
    }

    /**
     * 添加自定 querylist 方法
     *
     * @param interfaze
     */
    private void addinterQueryList(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        Method method = new Method("queryList");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setAbstract(true);
        //设置返回值
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importedTypes.add(listType);
        returnType.addTypeArgument(listType);
        method.setReturnType(returnType);
        //设置参数
        FullyQualifiedJavaType doType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        method.addParameter(new Parameter(doType, "record"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectAllMethodGenerated(method,
                interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    private void addInterfaceInsertBatchSelective(Interface interfaze) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        // 添加Lsit的包
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        Method method = new Method("insertBatchSelective");
        method.setAbstract(true);
        method.setVisibility(JavaVisibility.PUBLIC);

        // 设置返回类型是List
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
        method.setReturnType(returnType);

        // 设置参数类型是List
        FullyQualifiedJavaType parameterType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listparameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importedTypes.add(parameterType);
        importedTypes.add(listparameterType);
        parameterType.addTypeArgument(listparameterType);
        method.addParameter(new Parameter(parameterType, "records"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }
}