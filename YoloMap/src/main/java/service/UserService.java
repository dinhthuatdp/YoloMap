package service;

import java.sql.SQLException;

public interface UserService {
	public boolean isValidUser(String userName, String password) throws SQLException;
	public boolean signUp(String userName, String password, String email, String create_date)  throws SQLException ;
}
