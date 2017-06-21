package cn.dataAnalysis.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * 该方法用于大批量数据查询
 *
 * Created by feng on 2017/6/21.
 */
public class JdbcQueryUtils {

    /*@Value("${spring.datasource.url}")
    private static String url;

    @Value("${spring.datasource.username}")
    private static String username;

    @Value("${spring.datasource.password}")
    private static String password;*/


    public static Connection getConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydata?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "hiih1234";
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.print("链接建立成功！");
        return con;
    }

    /*public static void main(String rags[]) throws Exception {
        Connection con = JdbcQueryUtils.getConnection();

    }*/
}
