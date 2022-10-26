package pers.ycy.javacode.mvcgen.businessCodeGenerate.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.service.BusinessCodeGenService;
import pers.ycy.javacode.system.WrapperResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Description: mvc代码生成
 * @Author: ycy
 * @Date: 2021-07-05
 */
@RestController
@Api(
        tags = "mvc代码生成"
)
@RequestMapping("javacode/mvcgen/businessCodeGenerate")
public class BusinessCodeGenController {

    @Autowired
    private BusinessCodeGenService businessCodeGenService;

    /**
     * 预览
     */
    @ApiOperation("预览")
    @PostMapping("/generateCodeStr")
    public WrapperResponse<Map<String,String>> generateCodeStr(@RequestBody @Valid CodeStructureDTO structureDTO) throws Exception {
        return businessCodeGenService.generateCodeStr(structureDTO);
    }

    /**
     * 创建文件夹路径
     */
    @ApiOperation("创建文件夹路径")
    @GetMapping("/createPath")
    public WrapperResponse<Boolean> createPath(CodeStructureDTO structureDTO) throws Exception {
        return businessCodeGenService.createPath(structureDTO);
    }
}

