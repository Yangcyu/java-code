package pers.ycy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.ycy.javacode.system.MyException;
import pers.ycy.javacode.system.WrapperResponse;

import javax.servlet.http.HttpServletRequest;

/***
 * @title: MyExceptionHandler
 * @projectName springboot
 * @description: controller异常封装
 * @author yangchenyu
 * @date 2021-06-10
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public WrapperResponse bizExceptionHandler(HttpServletRequest req, MyException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        e.printStackTrace();
        return WrapperResponse.fail(e.getMessage());
    }

    /**
     * 处理volidated异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public WrapperResponse exceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        String errorMesssage = "校验失败:";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }
        return WrapperResponse.fail(errorMesssage);
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public WrapperResponse exceptionHandler(HttpServletRequest req, Exception e){
        log.error("发生未知异常！原因是：{}",e.getMessage());
        e.printStackTrace();
        return WrapperResponse.fail(e.getMessage());
    }

}
