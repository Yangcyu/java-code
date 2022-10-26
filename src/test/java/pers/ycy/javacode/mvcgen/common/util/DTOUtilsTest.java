package pers.ycy.javacode.mvcgen.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

/***
 * @title: DTOUtilsTest
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-06-27
 */
@SpringBootTest
class DTOUtilsTest {


    @Autowired
    private DataSource dataSource;


    @Test
    void getColumnsByTableTest() throws Exception {
        System.out.printf(dataSource.getConnection().getCatalog());
    }

}
