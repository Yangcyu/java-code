package pers.ycy.javacode.mvcgen.common.util;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
import pers.ycy.javacode.system.MyException;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

/***
 * @title: TypeNameUtils
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-07-05
 */
public class TypeNameUtils {
    public static TypeName getTypeByString(String name, String path) {
        TypeName typeName = null;
        switch (name) {
            case "Void":
                typeName = TypeName.VOID;
                break;
            case "Boolean":
                typeName = TypeName.get(Boolean.class);
                break;
            case "Byte":
                typeName = TypeName.BYTE;
                break;
            case "Char":
                typeName = TypeName.CHAR;
                break;
            case "Double":
                typeName = TypeName.DOUBLE;
                break;
            case "Float":
                typeName = TypeName.FLOAT;
                break;
            case "Object":
                typeName = TypeName.OBJECT;
                break;
            case "Short":
                typeName = TypeName.SHORT;
                break;
            case "int":
                typeName = TypeName.INT;
                break;
            case "Long":
                typeName = TypeName.LONG;
                break;
            case "Integer":
                typeName = TypeName.get(Integer.class);
                break;
            case "String":
                typeName = TypeName.get(String.class);
                break;
            case "Date":
                typeName = TypeName.get(Date.class);
                break;
            case "BigDecimal":
                typeName = TypeName.get(BigDecimal.class);
                break;
            default: {
                typeName = ClassName.get(path, name);
            }
        }
        return typeName;
    }

    public static TypeName getTypeName(String name, String path) throws MyException {
        //集合
        if (Pattern.matches("^[A-Z][A-Za-z]*$", name)) {
            //单个
            return TypeNameUtils.getTypeByString(name, path);
        } else if (Pattern.matches("^List<[A-Za-z]*>+$", name)) {
            //List
            name = StringUtils.substringBetween(name, "<", ">");
            return ParameterizedTypeName.get(ClassName.get(List.class), TypeNameUtils.getTypeByString(name, path));
        } else if (Pattern.matches("^Map<[A-Za-z]*,[A-Za-z]*>+$", name)) {
            //Map
            name = StringUtils.substringBetween(name, "<", ">");
            String[] strs = StringUtils.split(name, ",");
            return ParameterizedTypeName.get(ClassName.get(Map.class), TypeNameUtils.getTypeByString(strs[0], path), TypeNameUtils.getTypeByString(strs[1], path));
        } else if (Pattern.matches("^Set<[A-Za-z]*>+$", name)) {
            //set
            name = StringUtils.substringBetween(name, "<", ">");
            return ParameterizedTypeName.get(ClassName.get(Set.class), TypeNameUtils.getTypeByString(name, path));
        } else {
            throw new MyException(name + " 类型错误");
        }
    }

    public static List<ParameterSpec> getParameters(String params, String path) throws MyException {
        String[] paramArr = params.split(",");
        List<ParameterSpec> parameterSpecList = new LinkedList<>();
        for(String paramKeyAndValueArr : paramArr){
            String[] paramKeyAndValue = paramKeyAndValueArr.trim().split("\\s+");
            TypeName typeName = getTypeName(paramKeyAndValue[0],path);
            parameterSpecList.add(ParameterSpec.builder(typeName,paramKeyAndValue[1]).build());
        }
        return parameterSpecList;
    }
}

