package by.htp.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ishop.bean.ProductForCart;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.OrderDao;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPool;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolException;
import by.htp.ishop.dao.impl.connection_pool.ConnectionPoolFactory;

public class SQLOrderDao  implements OrderDao{
	
	public static final String SELECT_PRODUCT_FOR_CART = "SELECT p.id, p.name, p.image, p.price "
			+ "FROM ishop.products p WHERE p.id = ?";

	@Override
	public boolean createOrder(int userId) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *
	 */
	@Override
	public ProductForCart addProductToCart(int productId) throws DAOException {
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
			
			ps = con.prepareStatement(SELECT_PRODUCT_FOR_CART);
			System.out.println("d");
			ps.setInt(1, productId);
			System.out.println("e");
			rs = ps.executeQuery();
			System.out.println("f");
			
			ProductForCart product = new ProductForCart();
			
			if (rs.next()) {
				product = new ProductForCart(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getDouble(4));
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
