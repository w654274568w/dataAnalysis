package cn.dataAnalysis.test;

import java.sql.*;

public class MysqlTest {
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost/lianjiadata";
	public static String name = "root";
	public static String password = "123456";
	
	/**
	 * �������ݿ�
	 * @return 
	 * @throws SQLException 
	 */
	public static ResultSet connectMysql(String sql) throws SQLException{
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void  main(String[] args){
		String sql = "select id,title from secondhandhouse where id = 3000;";
		ResultSet rs =null;
		try {
			rs = connectMysql(sql);
			String id = null ;
			String title = null ;
			while(rs.next()){
				id = rs.getString("id");
				title = rs.getString("title");
				System.out.println(id + title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
