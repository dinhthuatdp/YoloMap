package serviceImpl;

import java.sql.SQLException;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {

	 UserDao userDao;
	 
	 public UserDao getUserDao() {
		 
		 return this.userDao;
	 }
	 
	 public void setUserDao(UserDao userDao) {
		 
		 this.userDao = userDao;
	 }

	@Override
	public boolean isValidUser(String userName, String password) throws SQLException {
		
		 return userDao.isValidUser(userName, password);
	}

}
