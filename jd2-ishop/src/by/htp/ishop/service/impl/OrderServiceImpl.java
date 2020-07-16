package by.htp.ishop.service.impl;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.DAOFactory;
import by.htp.ishop.service.OrderService;
import by.htp.ishop.service.ServiceException;

public class OrderServiceImpl implements OrderService{

	@Override
	public boolean createOrder(int userId) throws ServiceException {
		try {
			DAOFactory instance = DAOFactory.getInstance();
			if (instance.getOrderDao().createOrder(userId)) {
				return true;
			}
			return false;
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Override
	public boolean addProductToCart(int orderId, int productId, int countOfProducts) throws ServiceException {
		try {
			DAOFactory instance = DAOFactory.getInstance();
			if (instance.getOrderDao().addProductToCart(orderId, productId, countOfProducts)) {
				return true;
			}
			return false;
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

}
