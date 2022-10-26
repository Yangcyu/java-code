package pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.director;

import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.sun.tools.javac.jvm.Code;
import org.junit.jupiter.api.*;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.BusinessCodeBuilder;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.builder.concreteBuilder.*;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.CodeStructureDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.dto.MethodConfigDTO;
import pers.ycy.javacode.mvcgen.businessCodeGenerate.enums.RequestTypeEnum;
import pers.ycy.javacode.mvcgen.common.util.MethodUtils;
import pers.ycy.javacode.system.MyException;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @title: BusinessCodeDirectorTest
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-29
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BusinessCodeDirectorTest {

    public void getFile(String type) throws Exception {
        CodeStructureDTO codeStructureDTO = new CodeStructureDTO();
        codeStructureDTO.setPackagePath("pers.ycy.javacode.mvcgen.businessCodeGenerate");
        codeStructureDTO.setBusinessName("BusinessCodeGen");
        codeStructureDTO.setDescription("mvc代码生成");
        List<MethodConfigDTO> list = new LinkedList<>();
        //1
        MethodConfigDTO dto = new MethodConfigDTO();
        dto.setMethodName("generateCodeStr");
        dto.setReturnStr("String");
        dto.setReturnName("codes");
        dto.setMethodDesc("预览");
        dto.setParameterStr("List<String> lists");
        dto.setRequestType(RequestTypeEnum.Post);
        list.add(dto);

        codeStructureDTO.setMethodConfigDTOS(list);
        BusinessCodeBuilder controller = new ControllerCodeConcreteBuilder(codeStructureDTO);
        BusinessCodeBuilder service = new ServiceCodeConcreteBuilder(codeStructureDTO);
        BusinessCodeBuilder serviceImpl = new ServiceImplCodeConcreteBuilder(codeStructureDTO);
        BusinessCodeBuilder bo = new BOCodeConcreteBuilder(codeStructureDTO);
        BusinessCodeBuilder boImpl = new BOImplCodeConcreteBuilder(codeStructureDTO);
        BusinessCodeDirector businessCodeDirector = null;
        switch (type) {
            case "Controller":
                businessCodeDirector = new BusinessCodeDirector(controller);
                break;
            case "Service":
                businessCodeDirector = new BusinessCodeDirector(service);
                break;
            case "ServiceImpl":
                businessCodeDirector = new BusinessCodeDirector(serviceImpl);
                break;
            case "BO":
                businessCodeDirector = new BusinessCodeDirector(bo);
                break;
            case "BOImpl":
                businessCodeDirector = new BusinessCodeDirector(boImpl);
                break;
            default: {
                throw new MyException("类型错误");
            }
        }
        businessCodeDirector.construct().writeTo(System.out);
    }

    @Order(1)
    @DisplayName("Controller")
    @Test
    void ControllerTest() throws Exception {
        this.getFile("Controller");
    }

    @Order(2)
    @DisplayName("Service")
    @Test
    void serviceTest() throws Exception {
        this.getFile("Service");
    }

    @Order(3)
    @DisplayName("ServiceImpl")
    @Test
    void servoceImplTest() throws Exception {
        this.getFile("ServiceImpl");
    }

    @Order(4)
    @DisplayName("BO")
    @Test
    void boTest() throws Exception {
        this.getFile("BO");
    }

    @Order(5)
    @DisplayName("BOImpl")
    @Test
    void boImplTest() throws Exception {
        this.getFile("BOImpl");
    }

}
