package by.htp.ishop.dao;

import java.util.List;

import by.htp.ishop.bean.Product;

public interface ProductDao {
	
	List<Product>getProductsByCategory(String nameCategory) throws DAOException;
	Product getProduct(int productId) throws DAOException;
}
