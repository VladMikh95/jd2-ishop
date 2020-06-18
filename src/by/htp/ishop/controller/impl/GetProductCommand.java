package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.ishop.controller.Command;

public class GetProductCommand implements Command{

	private static final String PRODUCT_PAGE_URL = "WEB-INF/jsp/product.jsp";
	private static final String PRODUCT = "product";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		
		//req.getRequestDispatcher(PRODUCT_PAGE_URL).forward(req, resp);
		req.setAttribute(PRODUCT, req.getParameter(PRODUCT));
		RequestDispatcher dispatcher = req.getRequestDispatcher(PRODUCT_PAGE_URL);
		dispatcher.forward(req, resp);
		
	}

}
