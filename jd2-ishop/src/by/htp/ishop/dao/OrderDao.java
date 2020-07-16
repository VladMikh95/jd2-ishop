package by.htp.ishop.dao;

public interface OrderDao {
	
	boolean createOrder(int userId) throws DAOException;
	
	boolean addProductToCart(int orderId, int productId, int countOfProduct) throws DAOException;

}
