package pers.ycy.javacode.mvcgen.codegen.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.mvcgen.codegen.dto.MethodDTO;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
@RequestMapping("javacode/mvcgen/")
public class MVCGenerateController {
    /**
     * @Description: 获取生成的代码信息
     * @Param: [methodDTOS]
     * @Return: java.util.List<java.lang.String>
     * @Author: yangchenyu
     * @Date: 2020/10/28 4:43 下午
     */
    @GetMapping("/getGenerateCodeList")
    public List<String> getGenerateCodeList(List<MethodDTO> methodDTOS) {

        return new ArrayList<>();
    }
}
