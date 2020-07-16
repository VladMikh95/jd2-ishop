package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.controller.Command;

public class SignOutCommand implements Command{
	
	private static final String USER = "user";
	
	private static final String PATH = "path";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getSession().setAttribute(USER, null);
		req.getRequestDispatcher(req.getParameter(PATH)).forward(req, resp);
	}
	

}
