package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.UserDao;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;
	
	@Override
	public boolean isValidUser(String userName, String password) throws SQLException {
	
		String query = "select user_name, password from user where user_name = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userName);
		//pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		
		if (resultSet.next()) {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			//if(resultSet.getInt("Count(*)") >= 1) {
			if (encoder.matches(password, resultSet.getString("password"))) {
				
				return true;
			}
			return false;
		}
		return false;
	}
	
	public DataSource getDataSource() {
			
		return this.getDataSource();
	}
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public boolean signUp(String userName, String password) throws SQLException {

		String query = "insert into user(user_name, password) value(?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		try {

			int result = pstmt.executeUpdate();
			if (result > 0) {

				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
