package by.htp.ishop.controller.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.bean.ProductForCart;
import by.htp.ishop.controller.Command;

public class ReduceQuantityProductCommand implements Command{

	private static final String PRODUCTS_LIST = "productsList";
	
	private static final String PRODUCT_ID = "productId";
	
	private static final String GET_CART_COMMAND = "Controller?command=GET_CART";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		Map<Integer, ProductForCart> products 
		= (HashMap<Integer, ProductForCart>)session.getAttribute(PRODUCTS_LIST);
		int productId = Integer.parseInt(req.getParameter(PRODUCT_ID));
		ProductForCart product = products.get(productId);
		if (product.getQuantity() == 1) {
			resp.sendRedirect(GET_CART_COMMAND);
		} else {
			product.setQuantity(product.getQuantity() - 1);
			products.put(productId, product);
			session.setAttribute(PRODUCTS_LIST, products);
			resp.sendRedirect(GET_CART_COMMAND);
		}

		
	}

}
