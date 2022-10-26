package pers.ycy.tableCompare.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.ycy.tableCompare.bo.impl.TableCompareBOImpl;

import java.sql.Connection;

/***
 * @title: JDBCConnectionTest
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
@SpringBootTest
class JDBCConnectionTest {

    @Autowired
    private JDBCConnection jdbcConnection;


    @Autowired
    private TableCompareBOImpl tableCompareBO;

    @Test
    public void test() {
        Connection conn = jdbcConnection.getConnection();
        Connection conn2 = jdbcConnection.getConnection2();
        System.out.println(conn);
        System.out.println(conn2);
    }

    @Test
    public void test2() throws Exception{
        tableCompareBO.getTableCompareResult();
    }

}
