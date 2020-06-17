package pers.ycy.javacode.business.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "demo测试")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @ApiModelProperty(value = "hello world")
    @GetMapping("/helloWorld")
    public String helloWold() {
        return "hello world!";
    }
}
