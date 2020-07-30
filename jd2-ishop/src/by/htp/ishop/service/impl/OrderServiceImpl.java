package by.htp.ishop.service.impl;

import by.htp.ishop.bean.ProductForCart;
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
	public ProductForCart addProductToCart(int productId) throws ServiceException {
		try {
			DAOFactory instance = DAOFactory.getInstance();
			return instance.getOrderDao().addProductToCart(productId);
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

}
