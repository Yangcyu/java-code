package pers.ycy.javacode.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import pers.ycy.javacode.mbg.config.MbgUiConfigEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorTest {

    public static void main(String[] args) {
        try {
            MbgUiConfigEntity entity = new MbgUiConfigEntity();

            entity.setEntityTargetProject("src/main/java");
            entity.setEntityTargetPackage("pers.ycy.javacode.business.demo.entity");
            entity.setDaoTargetProject("src/main/java");
            entity.setDaoTargetPackage("pers.ycy.javacode.business.demo.dao");
            entity.setMapperTargetProject("src/main/resources");
            entity.setMapperTargetPackage("mapper");

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "generatorConfig.xml";
            File configFile = new File(path);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            Context context = config.getContext("mybatis");
            JavaModelGeneratorConfiguration modelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
            modelGeneratorConfiguration.setTargetProject(entity.getEntityTargetProject());
            modelGeneratorConfiguration.setTargetPackage(entity.getEntityTargetPackage());
            JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
            javaClientGeneratorConfiguration.setTargetProject(entity.getDaoTargetProject());
            javaClientGeneratorConfiguration.setTargetPackage(entity.getDaoTargetPackage());
            SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = context.getSqlMapGeneratorConfiguration();
            sqlMapGeneratorConfiguration.setTargetProject(entity.getMapperTargetProject());
            sqlMapGeneratorConfiguration.setTargetPackage(entity.getMapperTargetPackage());
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}