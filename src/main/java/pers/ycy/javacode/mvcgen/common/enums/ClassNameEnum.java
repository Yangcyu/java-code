package pers.ycy.javacode.mvcgen.common.enums;

import com.squareup.javapoet.ClassName;

/***
 * @title: ClassNameEnum
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2020-10-28
 */
public enum ClassNameEnum {
   ;
    private Class aClass;

    private String classStr;

    ClassNameEnum(Class aClass,String classstr){
        this.aClass = aClass;
        this.classStr = classstr;
    }
}
