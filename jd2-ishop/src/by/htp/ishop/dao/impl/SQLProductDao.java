package by.htp.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.ishop.bean.Master;
import by.htp.ishop.bean.Product;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.ProductDao;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPool;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolException;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolFactory;

public class SQLProductDao implements ProductDao{
	
	private static final String GET_PRODUCTS_BY_CATEGORY = "SELECT ishop.products.id, ishop.products.name,"
			+ "ishop.products.image, ishop.products.material, ishop.products.price, ishop.masters.name, ishop.masters.surname, ishop.masters.phoneNumber, "
			+ "ishop.masters.email, ishop.categories.name FROM ishop.products JOIN ishop.categories ON "
			+ "ishop.products.categories_id = ishop.categories.id JOIN ishop.masters ON ishop.products.masters_id = ishop.masters.id"
			+ " WHERE ishop.categories.name = ? AND ishop.products.statuses_product_id = 1";
	
	private static final String GET_PRODUCT_BY_ID = "SELECT p.id, p.name, "
			+ "p.image, p.material, p.price, c.name, m.name, m.surname, m.phoneNumber, "
			+ "m.email FROM ishop.products p JOIN ishop.categories c ON "
			+ "p.categories_id = c.id JOIN ishop.masters m ON p.masters_id ="
			+ " m.id WHERE p.id = ?";
	
	@Override
	public List<Product> getProductsByCategory(String nameCategory) throws DAOException {
		Connection con = null;
		ConnectionPool cp = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println(nameCategory);
			cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			System.out.println("a");
			cp.initPoolData();
			System.out.println("b");
			con = cp.takeConnection();
			System.out.println("c");
			
			ps = con.prepareStatement(GET_PRODUCTS_BY_CATEGORY);
			System.out.println("d");
			System.out.println(nameCategory);
			ps.setString(1, nameCategory);
			System.out.println("e");
			rs = ps.executeQuery();
			System.out.println("f");
			
			List<Product> products = new ArrayList<Product>();
			
			while (rs.next()) {
				Master master = new Master(rs.getString(7),
						   					rs.getString(8),
						   					rs.getString(9),
						   					rs.getString(10));
				Product product = new Product(rs.getInt(1),
												rs.getString(2),
												rs.getString(3),
												rs.getString(4),
												rs.getDouble(5),
												rs.getString(6),
												master);
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		}finally {
			cp.closeConnection(con, ps, rs);
		}
	}

	@Override
	public Product getProduct(int productId) throws DAOException {
		Connection con = null;
		ConnectionPool cp = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println(productId);
			cp = ConnectionPoolFactory.getInstance().getConnectionPool();
			System.out.println("a");
			cp.initPoolData();
			System.out.println("b");
			con = cp.takeConnection();
			System.out.println("c");
			
			ps = con.prepareStatement(GET_PRODUCT_BY_ID);
			System.out.println("d");
			ps.setInt(1, productId);
			System.out.println("e");
			rs = ps.executeQuery();
			System.out.println("f");
			
			Product product = new Product();
			
			if (rs.next()) {
				Master master = new Master(rs.getString(7),
						   					rs.getString(8),
						   					rs.getString(9),
						   					rs.getString(10));
				product = new Product(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getDouble(5),
										rs.getString(6),
										master);
			}
			return product;
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		}finally {
			cp.closeConnection(con, ps, rs);
		}
	}

}
