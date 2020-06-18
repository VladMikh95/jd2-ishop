package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.controller.Command;

public class ChangeLocalCommand implements Command {
	
	private static final String LOCAL = "local";
	private static final String NAME_PAGE = "page";
	//private static final String COMMAND = "Controller?command=";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getSession(true).setAttribute(LOCAL, req.getParameter(LOCAL));
		//resp.sendRedirect(message);
		req.getRequestDispatcher(req.getParameter(NAME_PAGE)).forward(req, resp);
		
	}

}
