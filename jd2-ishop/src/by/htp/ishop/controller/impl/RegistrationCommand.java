package by.htp.ishop.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.bean.User;
import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;
import by.htp.ishop.service.ServiceInvalidDataException;
import by.htp.ishop.service.UserService;


public class RegistrationCommand implements Command {
	
	private static final String REQUEST_REGISTRATION_SUCCESS = "Controller?command=GO_TO_REGISTRATION_SUCCESS_PAGE";
	
	private static final String REQUEST_USER_ALREADY_EXIST = "Controller?command=GO_TO_REGISTRATION_PAGE"
			+ "&fail=userAlreadyExist";
	
	private static final String REQUEST_INVALID_DATA = "Controller?command=GO_TO_REGISTRATION_PAGE"
			+ "&fail=invalidData";
	
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
				resp.sendRedirect(REQUEST_REGISTRATION_SUCCESS);
			} else {
				resp.sendRedirect(REQUEST_USER_ALREADY_EXIST);
				System.out.println("hbdxc");
			}
			System.out.println("hbdxc");
		} catch (ServiceInvalidDataException e) {
			resp.sendRedirect(REQUEST_INVALID_DATA);
		} catch (ServiceException e) {
			System.out.println("Incorrect data");
		}
		
	}

}
