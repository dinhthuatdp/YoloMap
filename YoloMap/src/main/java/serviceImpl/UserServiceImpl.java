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

	@Override
	public boolean signUp(String userName, String password, String email, String create_date) throws SQLException  {
		 
		return userDao.signUp(userName, password, email, create_date);
	}

}
