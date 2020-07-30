package by.htp.ishop.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.bean.ProductForCart;
import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;

public class AddToCartCommand implements Command{
	
	private static final String USER = "user";
	
	private static final String AUTHORIZATION_COMMAND = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
	
	private static final String PRODUCTS_LIST ="productsList";
	
	private static final String PRODUCT_ID = "productId";
	
	private static final String COMMAND_ADD = "&popupMessage=addSuccess&productId=";
	
	private static final String REQUEST = "Controller?command=GET_PRODUCT";
	
	private static final String ALREADY_ADDED = "&popupMessage=alreadyAdded&productId=";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		if (req.getSession().getAttribute(USER) == null) {
			resp.sendRedirect(AUTHORIZATION_COMMAND);
		} else {
			HttpSession session = req.getSession(true);
			Map<Integer, ProductForCart> productsList 
			= (HashMap<Integer, ProductForCart>) session.getAttribute(PRODUCTS_LIST);
			Integer productId = Integer.parseInt(req.getParameter(PRODUCT_ID));
			ServiceFactory instance = ServiceFactory.getInstance();
			
			try {
				
				if (session.getAttribute(PRODUCTS_LIST) == null) {
					productsList = new HashMap<Integer, ProductForCart>();
				}
				
				if (productsList.containsKey(productId)) {
					resp.sendRedirect(REQUEST + ALREADY_ADDED + req.getParameter(PRODUCT_ID));
					System.out.println(REQUEST + ALREADY_ADDED + req.getParameter(PRODUCT_ID));
				} else {
					productsList.put(productId, instance.getOrderService().addProductToCart(productId));
					session.setAttribute(PRODUCTS_LIST, productsList);
					resp.sendRedirect(REQUEST + COMMAND_ADD + req.getParameter(PRODUCT_ID));
					System.out.println(REQUEST + COMMAND_ADD + req.getParameter(PRODUCT_ID));
				}
			} catch (ServiceException e) {
				System.out.println("error");
			}
			
		}
	}

}
