package pers.ycy.javacode.mvcgen.businessCodeGenerate.service;

import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.system.WrapperResponse;

import java.util.List;
import java.util.Map;

/**
 * @Description: mvc代码生成
 * @Author: ycy
 * @Date: 2021-07-05
 */
public interface BusinessCodeGenService {
    /**
     * 预览
     */
    WrapperResponse<Map<String,String>> generateCodeStr(CodeStructureDTO structureDTO) throws Exception;

    /**
     * 创建文件夹路径
     */
    WrapperResponse<Boolean> createPath(CodeStructureDTO structureDTO) throws Exception;
}

