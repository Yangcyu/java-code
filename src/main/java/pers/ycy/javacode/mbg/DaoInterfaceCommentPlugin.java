package pers.ycy.javacode.mbg;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaoInterfaceCommentPlugin extends PluginAdapter {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean validate(List<String> list) {
        return true;
    }
    /***
     * dao注释
     * @param interfaze
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addJavaDocLine("/*******************");
        interfaze.addJavaDocLine(" *@Description "+introspectedTable.getRemarks()+"操作实现");
        interfaze.addJavaDocLine(" *@Table "+introspectedTable.getTableConfiguration());
        interfaze.addJavaDocLine(" *@Author ycy");
        interfaze.addJavaDocLine(" *@Date "+ sdf.format(new Date()) );
        interfaze.addJavaDocLine(" *******************/");
        return true;
    }
}