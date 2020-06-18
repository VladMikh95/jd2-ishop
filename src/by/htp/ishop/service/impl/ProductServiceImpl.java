package by.htp.ishop.service.impl;

import java.util.List;

import by.htp.ishop.bean.Product;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.DAOFactory;
import by.htp.ishop.service.ProductService;
import by.htp.ishop.service.ServiceException;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> getProductsByCategory(String nameCategory) throws ServiceException {
		if(nameCategory == null) {
			throw new ServiceException("Incorrect Product data");
		}
		
		try {
			DAOFactory instance = DAOFactory.getInstance();
			System.out.println(nameCategory);
			return instance.getProductDao().getProductsByCategory(nameCategory);
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Product getProduct(int productId) throws ServiceException {
		if(productId == 0) {
			throw new ServiceException("Incorrect Product data");
		}
		
		try {
			DAOFactory instance = DAOFactory.getInstance();
			System.out.println(productId);
			return instance.getProductDao().getProduct(productId);
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

}
