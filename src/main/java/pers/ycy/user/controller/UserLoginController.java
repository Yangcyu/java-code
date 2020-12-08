package pers.ycy.user.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import pers.ycy.javacode.system.WrapperResponse;
import pers.ycy.user.dto.User;

@Api(tags = "用户登陆")
@RestController
@RequestMapping("user")
public class UserLoginController {

    @PostMapping("/login")
    public WrapperResponse<User> login(@RequestBody User user){
        if("admin".equals(user.getUsername()) &&"123456".equals(user.getPassword())){
            user.setToken("admin-token");
            return WrapperResponse.success(user);
        }
        return WrapperResponse.fail(user);
    }

    @GetMapping("/info")
    public WrapperResponse<String> info(String str){
        return WrapperResponse.success(str);
    }

    @PostMapping("/logout")
    public WrapperResponse<String> logout(String str){
        return WrapperResponse.success("sucess");
    }
}
