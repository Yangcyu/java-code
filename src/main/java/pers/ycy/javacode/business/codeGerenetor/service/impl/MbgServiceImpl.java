package pers.ycy.javacode.business.codeGerenetor.service.impl;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.business.codeGerenetor.service.MbgService;
import pers.ycy.javacode.mbg.config.MbgUiConfigDTO;
import pers.ycy.javacode.system.MyException;

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
    public Boolean mbgGenerator(MbgUiConfigDTO entity) throws Exception {
        isChartPathExist(entity);
        List<String> warnings = new ArrayList<>();
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "generatorConfig.xml";
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        Context context = config.getContext("mybatis");
        contextCustom(context, entity);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        return true;
    }

    public void contextCustom(Context context, MbgUiConfigDTO entity) {
        JDBCConnectionConfiguration jdbcConnectionConfiguration = context.getJdbcConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
        jdbcConnectionConfiguration.setConnectionURL(env.getProperty("spring.datasource.url"));
        jdbcConnectionConfiguration.setUserId(env.getProperty("spring.datasource.name"));
        jdbcConnectionConfiguration.setPassword(env.getProperty("spring.datasource.password"));

        JavaModelGeneratorConfiguration modelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        modelGeneratorConfiguration.setTargetProject(entity.getProjectPath() + File.separator + entity.getEntityTargetProject());
        modelGeneratorConfiguration.setTargetPackage(entity.getEntityTargetPackage());

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(entity.getProjectPath() + File.separator + entity.getDaoTargetProject());
        javaClientGeneratorConfiguration.setTargetPackage(entity.getDaoTargetPackage());

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = context.getSqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(entity.getProjectPath() + File.separator + entity.getMapperTargetProject());
        sqlMapGeneratorConfiguration.setTargetPackage(entity.getMapperTargetPackage());

        List<TableConfiguration> tableConfigurations = context.getTableConfigurations();
        for (TableConfiguration table : tableConfigurations) {
            table.setTableName(entity.getTableName());
            table.setDomainObjectName(entity.getDomainObjectName());
        }
    }

    public void isChartPathExist(MbgUiConfigDTO dto) throws Exception {
        File entityFile = new File(dto.getProjectPath() + File.separator + dto.getEntityTargetProject());
        File daoFile = new File(dto.getProjectPath() + File.separator + dto.getDaoTargetProject());
        File mapperFile = new File(dto.getProjectPath() + File.separator + dto.getMapperTargetProject());
        if (!entityFile.exists()) {
            throw new MyException(1, "文件不存在");
        }
        if (!daoFile.exists()) {
            throw new MyException(1, "文件不存在");
        }
        if (!mapperFile.exists()) {
            throw new MyException(1, "文件不存在");
        }
    }

    @Override
    public Boolean makeDirs(MbgUiConfigDTO dto) throws Exception {
        File entityFile = new File(dto.getProjectPath() + File.separator + dto.getEntityTargetProject());
        File daoFile = new File(dto.getProjectPath() + File.separator + dto.getDaoTargetProject());
        File mapperFile = new File(dto.getProjectPath() + File.separator + dto.getMapperTargetProject());
        if (!entityFile.exists()) {
            entityFile.mkdirs();
        }
        if (!daoFile.exists()) {
            daoFile.mkdirs();
        }
        if (!mapperFile.exists()) {
            mapperFile.mkdirs();
        }
        return true;
    }
}