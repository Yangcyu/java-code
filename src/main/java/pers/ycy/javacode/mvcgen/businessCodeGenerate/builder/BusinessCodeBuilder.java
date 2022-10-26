package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder;

import com.squareup.javapoet.JavaFile;
import pers.ycy.javacode.system.MyException;

/***
 * @title: BusinessCodeBuilder
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
public abstract class BusinessCodeBuilder {


    /**
     * buiuler初始化
     */
    public abstract void buildInit();

    /**
     * 实现接口
     */
    public abstract void buildInterface();

    /**
     * 构造注释
     */
    public abstract void buildCodeBlock();

    /**
     * 构造父类
     */
    public abstract void buildSuperClass();

    /**
     * 构造接口
     */
    public abstract void buildAnnotationSpecs();

    /**
     * 构造属性
     */
    public abstract void buildFieldSpecs();

    /**
     * 构造方法
     */
    public abstract void buildMethods() throws Exception;

    /**
     * 返回产品对象
     *
     * @Param: []
     * @Return: JavaFile
     */
    public abstract JavaFile getJavaFile();
}
