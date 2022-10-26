package pers.ycy.javacode.mvcgen.businessCodeGenerate.bo;

import java.lang.Exception;
import java.lang.String;
import java.util.List;
import java.util.Map;

import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;

/**
 * @Description: mvc代码生成
 * @Author: ycy
 * @Date: 2021-07-05
 */
public interface BusinessCodeGenBO {
    /**
     * 预览
     */
    Map<String,String> generateCodeStr(CodeStructureDTO structureDTO) throws Exception;

    /**
     * 创建文件夹路径
     */
    Boolean createPath(CodeStructureDTO structureDTO) throws Exception;
}

