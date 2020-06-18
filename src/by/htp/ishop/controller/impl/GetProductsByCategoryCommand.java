package by.htp.ishop.controller.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.Product;
import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ProductService;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;
import by.htp.ishop.service.UserService;

public class GetProductsByCategoryCommand implements Command{
	
	private static final  String CATEGORY_NAME = "categoryName";
	private static final String PRODUCTS_PAGE_URL ="WEB-INF/jsp/products.jsp";
	private static final String PRODUCTS_lIST = "products";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		String categoryName= req.getParameter(CATEGORY_NAME);
    	HttpSession session = req.getSession(true);
    	
    	ServiceFactory instance = ServiceFactory.getInstance();
		ProductService productService = instance.getProductService();
		
		
		try {
			//AuthorizationUser authorizationUser = userService.authorization(login, password);
			//List<Product> products = productService.getProductsByCategory(categoryName);
			//session.setAttribute(PRODUCTS_SESSION, products);
			//resp.sendRedirect(AUTHORIZATION_SUCCESS);
			req.setAttribute(PRODUCTS_lIST, productService.getProductsByCategory(categoryName));
			req.setAttribute(CATEGORY_NAME, categoryName);
            RequestDispatcher dispatcher = req.getRequestDispatcher(PRODUCTS_PAGE_URL);
            dispatcher.forward(req, resp);
		} catch (ServiceException e) {
			System.out.println("fdhd");
		}
		
	}

}
