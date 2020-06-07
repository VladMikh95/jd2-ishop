package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;
import by.htp.ishop.service.UserService;


public class AuthorizationCommand implements Command{
	
	private static final  String NOT_EXIST = "Not Exist";
	private static final String AUTHORIZATION_SUCCESS ="Controller?command=GO_TO_MAIN_PAGE";
	private static final String AUTHORIZATION_FAIL = "fail";
	private static final String URL = "WEB-INF/jsp/Authorization.jsp";
	private static final String USER_SESSION = "user";

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession(true);
    	
    	ServiceFactory instance = ServiceFactory.getInstance();
		UserService userService = instance.getUserService();
		
		
		try {
			AuthorizationUser authorizationUser = userService.authorization(login, password);
			if(authorizationUser.getStatus().equals(NOT_EXIST)) {
				request.setAttribute(AUTHORIZATION_FAIL, -1);
				request.getRequestDispatcher(URL).forward(request, response);
			} else {
				session.setAttribute(USER_SESSION, authorizationUser);
				response.sendRedirect(AUTHORIZATION_SUCCESS);				
			}
			
		} catch (ServiceException e) {
			System.out.println("fdhd");
		}
	}

}
