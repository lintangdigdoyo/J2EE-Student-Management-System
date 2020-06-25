package student.util;

import java.sql.*;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	
	static ResourceBundle rb = ResourceBundle.getBundle("jdbc_mysql");
	static String driver = rb.getString("jdbc.driver");
	static String url = rb.getString("jdbc.url");
	static String user = rb.getString("jdbc.user");
	static String pass = rb.getString("jdbc.pass");
	
	public static Connection getConnection() throws Exception {

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driver);            
		cpds.setJdbcUrl(url);
		cpds.setUser(user);                                  
		cpds.setPassword(pass);  
		
		Connection con = cpds.getConnection();
		
		return con;
	}

	public static void release(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
