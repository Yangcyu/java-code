package pers.ycy.javacode.mvcgen.common.util;

import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;

import java.util.Iterator;

/***
 * @title: MethodUtils
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-30
 */
public final class MethodUtils {

    public static String getParameterName(Iterable<ParameterSpec> parameterSpecs) {
        StringBuilder builder = new StringBuilder("(");
        Iterator iterator = parameterSpecs.iterator();
        while (iterator.hasNext()) {
            ParameterSpec parameterSpec = (ParameterSpec) iterator.next();
            builder.append(parameterSpec.name);
            if (iterator.hasNext()) {
                builder.append(",");
            }
        }
        builder.append(")");
        return builder.toString();
    }

    public static String getNameByTypeName(TypeName typeName) {
        String name = null;
        return name;
    }
}
