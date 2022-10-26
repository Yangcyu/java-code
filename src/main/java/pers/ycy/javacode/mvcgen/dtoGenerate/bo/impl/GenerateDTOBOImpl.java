package pers.ycy.javacode.mvcgen.dtoGenerate.bo.impl;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.common.util.CommentUtils;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.DTOFileDTO;
import pers.ycy.javacode.mvcgen.common.util.MedaDataUtils;
import pers.ycy.javacode.mvcgen.dtoGenerate.bo.GenerateDTOBO;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.ColumnInfoDTO;

import javax.lang.model.element.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * @title: GenerateDTOBOImpl
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2020-12-08
 */
@Slf4j
@Service
public class GenerateDTOBOImpl implements GenerateDTOBO {

    @Autowired
    private MedaDataUtils medaDataUtils;

    @Override
    public List<ColumnInfoDTO> getColumnInfoByTable(String tableName) throws Exception {
        return medaDataUtils.getColumnsByTable(tableName);
    }

    @Override
    public String getDTOInfo(DTOFileDTO dtoFileDTO) throws Exception {

        Set<FieldSpec> fieldSpecs = new HashSet<>();
        for (ColumnInfoDTO columnInfoDTO : dtoFileDTO.getColumnInfoDTOS()) {
            AnnotationSpec AnnotaionApiModelProperty = AnnotationSpec.builder(ApiModelProperty.class)
                    .addMember("value", "\""+columnInfoDTO.getColumnComment()+"\"")
                    .build();
            Class<?> aclass = Class.forName(columnInfoDTO.getBaseQualifiedName());
            FieldSpec fieldSpec = FieldSpec.builder(aclass, columnInfoDTO.getJavaProperty(), Modifier.PRIVATE)
                    .addAnnotation(AnnotaionApiModelProperty)
                    .build();
            fieldSpecs.add(fieldSpec);
        }

        AnnotationSpec annotationSpec = AnnotationSpec.builder(Api.class)
                .addMember("tags", "\""+dtoFileDTO.getDescription()+"\"")
                .build();
        TypeSpec typeSpec = TypeSpec.classBuilder(dtoFileDTO.getDtoName())
                .addModifiers(Modifier.PUBLIC)
                .addFields(fieldSpecs)
                .addJavadoc(CommentUtils.getCommentInfo(dtoFileDTO.getDescription()))
                .addAnnotation(Data.class)
                .addAnnotation(annotationSpec)
                .build();

        JavaFile javaFile = JavaFile.builder(dtoFileDTO.getPackageName(), typeSpec)
                .build();
        return javaFile.toString();
    }
}
