package by.htp.ishop.service;

import java.util.List;

import by.htp.ishop.bean.Product;


public interface ProductService {
	
	List<Product>getProductsByCategory(String nameCategory) throws ServiceException;
	Product getProduct(int productId) throws ServiceException;

}
