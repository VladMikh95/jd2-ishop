package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.controller.Command;

public class GoToAuthorizationPageCommand implements Command {
	
	private static final String PATH = "WEB-INF/jsp/Authorization.jsp";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher(PATH).forward(req, resp);
	}

}
