package by.htp.ishop.dao.impl.connection_pool;


public class ConnectionPoolFactory {
	
	private final static ConnectionPoolFactory instance = new ConnectionPoolFactory();
	
	private ConnectionPool connectionPool = new ConnectionPool();
;
	
	public static ConnectionPoolFactory getInstance() {
		return instance;
	}
	
	public ConnectionPool getConnectionPool() {
		return connectionPool;
	}

}
