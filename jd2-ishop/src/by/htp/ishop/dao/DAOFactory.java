package by.htp.ishop.dao;

import by.htp.ishop.dao.impl.SQLUserDao;

public final class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	private UserDao userDao = new SQLUserDao();
	
	private DAOFactory() {
		
	}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	

}
