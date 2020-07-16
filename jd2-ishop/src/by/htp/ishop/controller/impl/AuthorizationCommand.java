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
import by.htp.ishop.service.ServiceInvalidDataException;
import by.htp.ishop.service.UserService;


public class AuthorizationCommand implements Command{
	
	private static final  String NOT_EXIST = "Not Exist";
	
	private static final String REQUEST_AUTHORIZATION_SUCCESS ="Controller?command=GO_TO_INDEX_PAGE";
	
	private static final String REQUEST_USER_IS_NOT_EXIST = "Controller?command=GO_TO_AUTHORIZATION_PAGE&fail=notExist";
	
	private static final String REQUEST_INVALID_DATA = "Controller?command=GO_TO_AUTHORIZATION_PAGE&fail=invalidData";
	
	private static final String USER_SESSION = "user";

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		String login = req.getParameter("login");
    	String password = req.getParameter("password");
    	HttpSession session = req.getSession(true);
    	
    	ServiceFactory instance = ServiceFactory.getInstance();
		UserService userService = instance.getUserService();
		
		
		try {
			AuthorizationUser authorizationUser = userService.authorization(login, password);
			if(authorizationUser.getStatus().equals(NOT_EXIST)) {
				resp.sendRedirect(REQUEST_USER_IS_NOT_EXIST);
			} else {
				session.setAttribute(USER_SESSION, authorizationUser);
				resp.sendRedirect(REQUEST_AUTHORIZATION_SUCCESS);				
			}
			
		} catch (ServiceInvalidDataException e) {
			resp.sendRedirect(REQUEST_INVALID_DATA);
		} catch (ServiceException e) {
			System.out.println("fdhd");
		}
	}

}
