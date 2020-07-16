package by.htp.ishop.service;

public class ServiceInvalidDataException  extends ServiceException{

	private static final long serialVersionUID = 1L; 
	
	public ServiceInvalidDataException() {
		super();
	}
	
	public ServiceInvalidDataException(String message) {
		super(message);
	}
	
	public ServiceInvalidDataException(Exception e) {
		super(e);
	}
	
	public ServiceInvalidDataException(String message, Exception e) {
		super(message, e);
	}

}
