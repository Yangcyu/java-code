package pers.ycy.javacode.business.codeGerenetor.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.business.codeGerenetor.service.impl.MbgServiceImpl;
import pers.ycy.javacode.mbg.config.MbgUiConfigEntity;
import pers.ycy.javacode.system.WrapperResponse;

@RestController
@Api("MBG")
@RequestMapping(value = "/mbg")
public class MbgController {

    @Autowired
    MbgServiceImpl mbgService;

    @ApiOperation(value = "mbg配置实现")
    @PostMapping("/mbgGenerator")
    public WrapperResponse<Boolean> mbgGenerator(@RequestBody MbgUiConfigEntity mbgUiConfigEntity) {
        try {
            Boolean flag = mbgService.mbgGenerator(mbgUiConfigEntity);
            return WrapperResponse.success(flag);
        } catch (Exception e) {
            return WrapperResponse.success(false);
        }
    }
}