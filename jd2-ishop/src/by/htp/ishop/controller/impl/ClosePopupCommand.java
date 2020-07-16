package by.htp.ishop.controller.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.ishop.controller.Command;

public class ClosePopupCommand implements Command{
	
	private static final String PRODUCT_ID = "productId";
	
	private static final String REQUEST = "Controller?command=GET_PRODUCT";
	
	private static final String CLOSE_POPUP = "&popupMessage=close&productId=";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.sendRedirect(REQUEST + CLOSE_POPUP + req.getParameter(PRODUCT_ID));
		
	}

}
