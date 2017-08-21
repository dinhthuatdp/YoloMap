package dao;

import java.sql.SQLException;

public interface UserDao {

	public boolean isValidUser(String userName, String password) throws SQLException;
}
