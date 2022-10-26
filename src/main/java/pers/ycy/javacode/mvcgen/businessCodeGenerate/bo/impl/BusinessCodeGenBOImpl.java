package pers.ycy.javacode.mvcgen.businessCodeGenerate.bo.impl;

import cn.hutool.core.io.FileUtil;
import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.bo.BusinessCodeGenBO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.concreteBuilder.*;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.director.BusinessCodeDirector;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: mvc代码生成
 * @Author: ycy
 * @Date: 2021-07-05
 */
@Service
@Slf4j
public class BusinessCodeGenBOImpl implements BusinessCodeGenBO {
    /**
     * 预览
     */
    @Override
    public Map<String, String> generateCodeStr(CodeStructureDTO structureDTO) throws Exception {
        Map<String, String> map = new LinkedHashMap<>(6);
        Map<String, JavaFile> javaFileMap = getjavaFiles(structureDTO);
        for (Map.Entry<String, JavaFile> entry : javaFileMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public Map<String, JavaFile> getjavaFiles(CodeStructureDTO structureDTO) throws Exception {
        Map<String, JavaFile> javaFileMap = new LinkedHashMap<>(6);
        BusinessCodeBuilder controller = new ControllerCodeConcreteBuilder(structureDTO);
        BusinessCodeBuilder service = new ServiceCodeConcreteBuilder(structureDTO);
        BusinessCodeBuilder serviceImpl = new ServiceImplCodeConcreteBuilder(structureDTO);
        BusinessCodeBuilder bo = new BOCodeConcreteBuilder(structureDTO);
        BusinessCodeBuilder boImpl = new BOImplCodeConcreteBuilder(structureDTO);
        JavaFile controllerJavaFile = new BusinessCodeDirector(controller).construct();
        JavaFile serviceJavaFile = new BusinessCodeDirector(service).construct();
        JavaFile serviceImplJavaFile = new BusinessCodeDirector(serviceImpl).construct();
        JavaFile boJavaFile = new BusinessCodeDirector(bo).construct();
        JavaFile boImplJavaFile = new BusinessCodeDirector(boImpl).construct();
        javaFileMap.put("controller", controllerJavaFile);
        javaFileMap.put("service", serviceJavaFile);
        javaFileMap.put("serviceImpl", serviceImplJavaFile);
        javaFileMap.put("bo", boJavaFile);
        javaFileMap.put("boImpl", boImplJavaFile);
        return javaFileMap;
    }

    /**
     * 创建文件夹路径
     */
    @Override
    public Boolean createPath(CodeStructureDTO structureDTO) throws Exception {
        try {
            String basePath = structureDTO.getProjectPath() +"/src/main/java/"+ structureDTO.getPackagePath().replace(".", "/");
            boolean controller = FileUtil.mkdir(basePath + "/controller").mkdirs();
            boolean service = FileUtil.mkdir(basePath + "/service").mkdirs();
            boolean serviceImpl = FileUtil.mkdir(basePath + "/service/impl").mkdir();
            boolean bo = FileUtil.mkdir(basePath + "/bo").mkdir();
            boolean boImpl = FileUtil.mkdir(basePath + "/bo/impl").mkdir();
            return true;
        } catch (Exception e) {
            log.error("创建文件失败：{}", e.getMessage());
            return false;
        }
    }
}

