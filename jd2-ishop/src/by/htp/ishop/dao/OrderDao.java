package by.htp.ishop.dao;

import by.htp.ishop.bean.ProductForCart;

public interface OrderDao {
	
	boolean createOrder(int userId) throws DAOException;
	
	ProductForCart addProductToCart(int productId) throws DAOException;

}
