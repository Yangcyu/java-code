package pers.ycy.javacode.business.codeGerenetor.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.business.codeGerenetor.service.impl.MbgServiceImpl;
import pers.ycy.javacode.mbg.config.MbgUiConfigDTO;
import pers.ycy.javacode.system.MyException;
import pers.ycy.javacode.system.WrapperResponse;

@RestController
@Api(value = "MBG",tags = "MBG")
@RequestMapping(value = "/mbg")
public class MbgController {

    @Autowired
    MbgServiceImpl mbgService;

    @ApiOperation(value = "mbg配置实现")
    @PostMapping("/mbgGenerator")
    public WrapperResponse<Boolean> mbgGenerator(@RequestBody MbgUiConfigDTO mbgUiConfigDTO) {
        try {
            Boolean flag = mbgService.mbgGenerator(mbgUiConfigDTO);
            return WrapperResponse.success(flag);
        } catch (MyException ex) {
            ex.printStackTrace();
            return WrapperResponse.error(1,ex.getMessage(),false);
        }catch (Exception e) {
            e.printStackTrace();
            return WrapperResponse.fail(e.getMessage(),false);
        }
    }

    @ApiOperation(value = "mbg创建文件项目路径")
    @PostMapping("/makeDirs")
    public WrapperResponse<Boolean> makeDirs(@RequestBody MbgUiConfigDTO mbgUiConfigDTO) {
        try {
            Boolean flag = mbgService.makeDirs(mbgUiConfigDTO);
            return WrapperResponse.success(flag);
        } catch (MyException ex) {
            return WrapperResponse.error(1,ex.getMessage(),false);
        }catch (Exception e) {
            return WrapperResponse.fail(e.getMessage(),false);
        }
    }
}
