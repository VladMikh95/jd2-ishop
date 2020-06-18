package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.bean.User;
import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;
import by.htp.ishop.service.UserService;


public class RegistrationCommand implements Command {
	
	private static final String PATH = "/WEB-INF/jsp/registrationSuccess.jsp";
	private static final String REGISTRATION_FAIL = "fail";
	private static final String REGISTRATION_PATH = "/WEB-INF/jsp/Registration.jsp";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	String login = req.getParameter("login");
    	String password = req.getParameter("password");
    	String name = req.getParameter("name");
    	String surname = req.getParameter("surname");
    	String phoneNumber = req.getParameter("phoneNumber");
    	String email = req.getParameter("email");
    	String status = "active";
    	int role = 1;
    	
    	User user = new User(login, password, name, surname, phoneNumber, email, status, role);
    	
    	
    	ServiceFactory instance = ServiceFactory.getInstance();
		UserService userService = instance.getUserService();
		
		try {
			if(userService.registration(user)) {
				req.getRequestDispatcher(PATH).forward(req, resp);
			} else {
				req.setAttribute(REGISTRATION_FAIL, -1);
				req.getRequestDispatcher(REGISTRATION_PATH).forward(req, resp);
				System.out.println("hbdxc");
			}
			System.out.println("hbdxc");
		} catch (ServiceException e) {
			System.out.println("Incorrect data");
		}
		
	}

}
