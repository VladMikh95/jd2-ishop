package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ProductService;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;

public class GetProductCommand implements Command{

	private static final String PRODUCT_PAGE_URL = "WEB-INF/jsp/product.jsp";
	private static final String PRODUCT_ID = "productId";
	private static final String PRODUCT = "product";
	private static final String POPUP_MESSAGE = "popupMessage";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		Integer productId  = Integer.parseInt(req.getParameter(PRODUCT_ID));
		
		ServiceFactory instance = ServiceFactory.getInstance();
		ProductService productService = instance.getProductService();
		HttpSession session = req.getSession(true);
		
		try {
			session.setAttribute(PRODUCT, productService.getProduct(productId));
			req.setAttribute(POPUP_MESSAGE, req.getParameter(POPUP_MESSAGE));
            RequestDispatcher dispatcher = req.getRequestDispatcher(PRODUCT_PAGE_URL);
            dispatcher.forward(req, resp);
		} catch (ServiceException e) {
			System.out.println("fdhd");
		}
		
	}

}
