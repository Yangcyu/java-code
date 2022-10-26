package pers.ycy.tableCompare.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.*;

/***
 * @title: JDBCUtils
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */

@Data
@Component
@ConfigurationProperties(prefix = "table-compare")
public class JDBCConnection {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private String driverClassName2;
    private String url2;
    private String username2;
    private String password2;

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverClassName2);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection2() {
        Connection conn = null;
        try {
            Class.forName(driverClassName2);
            conn = DriverManager.getConnection(url2, username2, password2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
