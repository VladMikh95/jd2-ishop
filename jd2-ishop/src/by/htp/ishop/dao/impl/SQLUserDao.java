package by.htp.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.User;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.UserDao;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPool;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolException;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolFactory;

public class SQLUserDao implements UserDao{
	
	private final static String NOT_EXIST = "Not Exist";
	private final static String INSERT_USER = "INSERT INTO users(login, password, name, surname, "
			+ "phone_number, email,status, roles_id) VALUES (?,?,?,?,?,?,?,?)";
	private final static String SELECT_LOGIN_PASSWORD = "SELECT * FROM users INNER JOIN roles ON "
			+ "users.roles_id = roles.id WHERE users.login = ? AND users.password = ?" ;
	private final static String SELECT_LOGIN = "SELECT * FROM users WHERE login  = ?";
	

	@Override
	public boolean registration(User user) throws DAOException {
		
		Connection con = null;
		ConnectionPool cp = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			/*if(checkLogin(user.getLogin())) {
				return false;
			}*/
			cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			cp.initPoolData();
			con = cp.takeConnection();
			ps = con.prepareStatement(SELECT_LOGIN);
			
			ps.setString(1, user.getLogin());
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return false;
			}
			//cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			//cp.initPoolData();
			//con = cp.takeConnection();
			ps.close();
			ps = con.prepareStatement(INSERT_USER);
			
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSurname());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getStatus());
			ps.setInt(8, user.getRole());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException | ConnectionPoolException e) {
			System.out.println("SQLError");
			e.printStackTrace();
			throw new DAOException(e);
			
		} finally {
			cp.closeConnection(con, ps, rs);
		}
		

	}

	@Override
	public AuthorizationUser authorization(String login, String password) throws DAOException {
		Connection con = null;
		ConnectionPool cp = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			System.out.println("a");
			cp.initPoolData();
			System.out.println("b");
			con = cp.takeConnection();
			System.out.println("c");
			
			ps = con.prepareStatement(SELECT_LOGIN_PASSWORD);
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println(1);
				System.out.println(rs.getString(11));
				AuthorizationUser user = new AuthorizationUser(rs.getString(4),
															   rs.getString(5),
															   rs.getString(6),
															   rs.getString(7),
															   rs.getString(8),
															   rs.getString(11));
				System.out.println(4);
				return user;
			}
			return new AuthorizationUser(null, null, null, null, NOT_EXIST, null);
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("SQL exception");
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			System.out.println();
			throw new DAOException(e);
		}finally {
			cp.closeConnection(con, ps, rs);
		}
	}

	@Override
	public boolean changeUserStatus(int id, String status) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*private boolean checkLogin(String login) throws DAOException {
		Connection con = null;
		ConnectionPool cp = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			cp.initPoolData();
			con = cp.takeConnection();
			ps = con.prepareStatement(SELECT_LOGIN);
			
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException | ConnectionPoolException e) {
			System.out.println("1");
			throw new DAOException(e);
		} finally {
			cp.closeConnection(con, ps, rs);
		}
	}*/

}
