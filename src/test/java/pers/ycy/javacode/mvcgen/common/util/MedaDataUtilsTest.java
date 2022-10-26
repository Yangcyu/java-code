package pers.ycy.javacode.mvcgen.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @title: MedaDataUtilsTest
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
@SpringBootTest
class MedaDataUtilsTest {

    @Autowired
    private MedaDataUtils medaDataUtils;

    @Test
    public void test() throws Exception{
        medaDataUtils.getTableInfo();
    }
}
