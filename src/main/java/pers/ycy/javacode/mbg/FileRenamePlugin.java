package pers.ycy.javacode.mbg;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * 文件重命名插件
 */
public class FileRenamePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String entityName = introspectedTable.getBaseRecordType();
        String daoName = introspectedTable.getMyBatis3JavaMapperType();
        //String mapperName = introspectedTable.getMyBatis3XmlMapperFileName();
        introspectedTable.setMyBatis3JavaMapperType(daoName.replace("Mapper", "DAO"));
        //introspectedTable.setMyBatis3XmlMapperFileName(mapperName.replace("Mapper","Mapper"));
        introspectedTable.setBaseRecordType(entityName + "DO");
    }
}