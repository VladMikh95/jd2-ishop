package by.htp.ishop.service;

import by.htp.ishop.bean.ProductForCart;

public interface OrderService{
	
	boolean createOrder(int userId) throws ServiceException;
	 
	ProductForCart addProductToCart(int productId) throws ServiceException;

}
