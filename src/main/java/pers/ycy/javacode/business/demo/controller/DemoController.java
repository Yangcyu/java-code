package pers.ycy.javacode.business.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "demo测试")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @ApiModelProperty(value = "hello world")
    @GetMapping("/helloWorld")
    public String helloWold(){
        return "hello world!";
    }
}