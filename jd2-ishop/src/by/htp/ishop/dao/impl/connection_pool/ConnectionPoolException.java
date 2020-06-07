package by.htp.ishop.dao.impl.connection_pool;

public class ConnectionPoolException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ConnectionPoolException() {
		super();
	}
	
	public ConnectionPoolException(String message) {
		super(message);
	}
	
	public ConnectionPoolException(Exception e) {
		super(e);
	}
	
	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}
	
	
}
