package by.htp.ishop.service;

public interface OrderService{
	
	boolean createOrder(int userId) throws ServiceException;
	 
	boolean addProductToCart(int orderId, int productId, int countOfProducts) throws ServiceException;

}
