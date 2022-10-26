package pers.ycy.javacode.mvcgen.businessCodeGenerate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.bo.BusinessCodeGenBO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.service.BusinessCodeGenService;
import pers.ycy.javacode.system.WrapperResponse;

import java.util.Map;

/**
 * @Description: mvc代码生成
 * @Author: ycy
 * @Date: 2021-07-05
 */
@Service
public class BusinessCodeGenServiceImpl implements BusinessCodeGenService {

    @Autowired
    private BusinessCodeGenBO businessCodeGenBO;

    /**
     * 预览
     */
    @Override
    public WrapperResponse<Map<String, String>> generateCodeStr(CodeStructureDTO structureDTO) throws Exception {
        return WrapperResponse.success(businessCodeGenBO.generateCodeStr(structureDTO));
    }

    /**
     * 创建文件夹路径
     */
    @Override
    public WrapperResponse<Boolean> createPath(CodeStructureDTO structureDTO) throws Exception {
        return WrapperResponse.success(businessCodeGenBO.createPath(structureDTO));
    }
}

