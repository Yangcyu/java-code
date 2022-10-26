package pers.ycy.javacode.mvcgen.common.util;

import com.squareup.javapoet.CodeBlock;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @title: CommentDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */

@Component
@Data
public class CommentUtils {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static String author = "ycy";

    private static String date = simpleDateFormat.format(new Date());


    public static CodeBlock getCommentInfo(String description) {
        return CodeBlock.builder()
                .add("@Description: " + description + "\n")
                .add("@Author: " + author + "\n")
                .add("@Date: " + date + "\n")
                .build();
    }

}
