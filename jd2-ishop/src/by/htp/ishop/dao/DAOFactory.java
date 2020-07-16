package by.htp.ishop.dao;

import by.htp.ishop.dao.impl.SQLOrderDao;
import by.htp.ishop.dao.impl.SQLProductDao;
import by.htp.ishop.dao.impl.SQLUserDao;

public final class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	private UserDao userDao = new SQLUserDao();
	
	private ProductDao productDao = new SQLProductDao();
	
	private OrderDao orderDao = new SQLOrderDao();
	
	private DAOFactory() {
		
	}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}
	
	public OrderDao getOrderDao() {
		return orderDao;
	}
	
	

}
