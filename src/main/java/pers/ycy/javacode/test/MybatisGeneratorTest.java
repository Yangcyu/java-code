package pers.ycy.javacode.test;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MybatisGeneratorTest {
    /*public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            Configuration config = new Configuration();
            Context context = new Context(ModelType.CONDITIONAL);
            //   ... fill out the config object as appropriate...
            context.setId("id");
            JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
            jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
            jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://127.0.0.1:3306/hsa");
            jdbcConnectionConfiguration.setUserId("root");
            jdbcConnectionConfiguration.setPassword("root");
            context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
            javaModelGeneratorConfiguration.setTargetPackage("pers.ycy.javacode.business.demo.entity");
            javaModelGeneratorConfiguration.setTargetProject("src/main/java");
            context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName("clct_bill_b");
            tableConfiguration.setAlias("clctBill");
            context.addTableConfiguration(tableConfiguration);

            //实体添加序列化
            PluginConfiguration serializablePluginConfiguration = new PluginConfiguration();
            serializablePluginConfiguration.addProperty("type", "org.mybatis.generator.plugins.SerializablePlugin");
            serializablePluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
            context.addPluginConfiguration(serializablePluginConfiguration);

            // Lombok 插件
            PluginConfiguration pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.addProperty("type", "com.softwareloop.mybatis.generator.plugins.LombokPlugin");
            pluginConfiguration.setConfigurationType("com.softwareloop.mybatis.generator.plugins.LombokPlugin");
            context.addPluginConfiguration(pluginConfiguration);



            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            config.addContext(context);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            String path =System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"generatorConfig.xml";
            File configFile = new File(path);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}