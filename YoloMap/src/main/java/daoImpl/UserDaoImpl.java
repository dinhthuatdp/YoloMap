package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.UserDao;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;
	
	@Override
	public boolean isValidUser(String userName, String password) throws SQLException {
	
		String query = "select Count(*) from user where user_name = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {

			if(resultSet.getInt("Count(*)") >= 1) {
				
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
}
