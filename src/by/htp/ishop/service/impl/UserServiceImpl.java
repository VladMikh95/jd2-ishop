package by.htp.ishop.service.impl;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.User;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.DAOFactory;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.UserService;

public class UserServiceImpl implements UserService{
	
	public static final String NOT_EXIST = "Not Exist";

	@Override
	public boolean registration(User user) throws ServiceException {
		if (user == null) {
			throw new ServiceException("Incorrect User data");
		}
		try {
			DAOFactory instance = DAOFactory.getInstance();
			if(instance.getUserDao().registration(user)) {
				return true;
			}
			return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public AuthorizationUser authorization(String login, String password) throws ServiceException {
		if((login == null) || (login.isEmpty())) {
			System.out.println("login incorrect");
		}
		if((password == null) || (password.isEmpty())) {
			System.out.println("password incorrect");
		}
		
		try {
			DAOFactory instance = DAOFactory.getInstance();
			return instance.getUserDao().authorization(login, password);
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean changeUserStatus(int id, String newStatus) throws ServiceException {
		if ( id == 0) {
			throw new ServiceException("Id incorrect");
		}
		if((newStatus == null) || (newStatus.isEmpty())) {
			throw new ServiceException("newStatus incorrect");
		}
		try {
			DAOFactory instance = DAOFactory.getInstance();
			if (instance.getUserDao().changeUserStatus(id, newStatus)) {
				return true;
			}
			return false;	
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	

}
