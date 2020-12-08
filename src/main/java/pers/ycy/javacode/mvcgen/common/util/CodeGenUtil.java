package pers.ycy.javacode.mvcgen.common.util;

import com.squareup.javapoet.*;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.lang.model.element.Modifier;

public class CodeGenUtil {

    @Test
    public void classGenerate() throws Exception{
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .addJavadoc("Date")
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        javaFile.writeTo(System.out);
    }


    @Test
    public void test()throws Exception{

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec.Builder builder= TypeSpec.classBuilder("MyTest");
        builder.addModifiers(Modifier.PUBLIC).addMethod(main);

        ClassName Autowired = ClassName.get(Autowired.class);
        ClassName String = ClassName.get(String.class);
        AnnotationSpec annotationSpec = AnnotationSpec.builder(Api.class).addMember("tag","\"这个测试\"").build();
        FieldSpec fieldSpec = FieldSpec.builder(String,"name",Modifier.PRIVATE).addAnnotation(Autowired).addAnnotation(annotationSpec).build();


        builder.addMethod(main);
        builder.addField(fieldSpec);
        TypeSpec typeSpec = builder.build();

        //文件
        JavaFile javaFile = JavaFile.builder("com.example.helloworld", typeSpec)
                .build();

        javaFile.writeTo(System.out);

    }
}
