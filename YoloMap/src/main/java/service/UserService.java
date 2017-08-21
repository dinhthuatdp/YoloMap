package service;

import java.sql.SQLException;

public interface UserService {
	public boolean isValidUser(String userName, String password) throws SQLException;
}
