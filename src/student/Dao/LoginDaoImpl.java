package student.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student.entity.Login;
import student.util.JDBCUtil;

public class LoginDaoImpl implements LoginDao{
	
	@Override
	public boolean validate(Login login) throws Exception  {

		boolean status = false;
		Connection conn = JDBCUtil.getConnection();		
			
		String sql = "select * from login where username = ? and password = ? ";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setObject(1, login.getUsername());
		pst.setObject(2, login.getPassword());
		ResultSet rs = pst.executeQuery();
		status = rs.next();
	
		return status;
	}
}
