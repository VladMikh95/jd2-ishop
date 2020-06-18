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
			+ "ishop.products.image, ishop.products.price, ishop.masters.name, ishop.masters.surname, ishop.masters.phoneNumber, "
			+ "ishop.masters.email, ishop.categories.name FROM ishop.products JOIN ishop.categories ON "
			+ "ishop.products.categories_id = ishop.categories.id JOIN ishop.masters ON ishop.products.masters_id = ishop.masters.id"
			+ " WHERE ishop.categories.name = ?";
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
				Master master = new Master(rs.getString(6),
						   					rs.getString(7),
						   					rs.getString(8),
						   					rs.getString(9));
				Product product = new Product(rs.getInt(1),
												rs.getString(2),
												rs.getString(3),
												rs.getDouble(4),
												rs.getString(5),
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
		// TODO Auto-generated method stub
		return null;
	}

}
