package student.Dao;

import student.entity.Login;

public interface LoginDao {

	boolean validate(Login loginBean) throws Exception;
	
}
