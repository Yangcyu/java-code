package pers.ycy.javacode.mvcgen.businessCodeGenerate.enums;

import org.springframework.web.bind.annotation.GetMapping;

/***
 * @title: RequetTypeEnum
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-29
 */
public enum RequestTypeEnum {

    Get, Post;

    public static Class getaClass(RequestTypeEnum str) {
        Class aClass;
        switch (str) {
            case Get:
                aClass = GetMapping.class;
                break;
            case Post:
                aClass = GetMapping.class;
                break;
            default: {
                aClass = GetMapping.class;
            }
        }
        return aClass;
    }
}
