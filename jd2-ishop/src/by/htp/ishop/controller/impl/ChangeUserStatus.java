package by.htp.ishop.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.controller.Command;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;
import by.htp.ishop.service.UserService;


public class ChangeUserStatus implements Command{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		

    	int id =12;
    	String status = "aaa";

    	
    	ServiceFactory instance = ServiceFactory.getInstance();
		UserService userService = instance.getUserService();
		
		try {
			userService.changeUserStatus(id, status);

		} catch (ServiceException e) {

		}

	}

}
