package pers.ycy.javacode.business.codeGerenetor.service.impl;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.business.codeGerenetor.service.MbgService;
import pers.ycy.javacode.mbg.config.MbgUiConfigEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author ycy
 * @date 2020-06-17
 */
@Service
public class MbgServiceImpl implements MbgService {

    @Autowired
    private Environment env;

    @Override
    public Boolean mbgGenerator(MbgUiConfigEntity entity) {
        try {
            List<String> warnings = new ArrayList<>();
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "generatorConfig.xml";
            File configFile = new File(path);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            Context context = config.getContext("mybatis");
            contextCustom(context,entity);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void contextCustom(Context context,MbgUiConfigEntity entity){
        JDBCConnectionConfiguration jdbcConnectionConfiguration = context.getJdbcConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
        jdbcConnectionConfiguration.setConnectionURL(env.getProperty("spring.datasource.url"));
        jdbcConnectionConfiguration.setUserId(env.getProperty("spring.datasource.name"));
        jdbcConnectionConfiguration.setPassword(env.getProperty("spring.datasource.password"));

        JavaModelGeneratorConfiguration modelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        modelGeneratorConfiguration.setTargetProject(entity.getEntityTargetProject());
        modelGeneratorConfiguration.setTargetPackage(entity.getEntityTargetPackage());
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(entity.getDaoTargetProject());
        javaClientGeneratorConfiguration.setTargetPackage(entity.getDaoTargetPackage());
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = context.getSqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(entity.getMapperTargetProject());
        sqlMapGeneratorConfiguration.setTargetPackage(entity.getMapperTargetPackage());
    }
}