package by.htp.ishop.service.impl;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.User;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.DAOFactory;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceInvalidDataException;
import by.htp.ishop.service.UserService;

public class UserServiceImpl implements UserService{
	
	public static final String NOT_EXIST = "Not Exist";

	@Override
	public boolean registration(User user) throws ServiceException {
		if ((user == null) ||(user.getLogin() == null) || user.getLogin().isEmpty()
				|| (user.getPassword() == null) || (user.getPassword().isEmpty())
				|| (user.getName() == null) || (user.getName().isEmpty())
				|| (user.getSurname() == null) || (user.getSurname().isEmpty())
				|| (user.getPhoneNumber() == null) || (user.getPhoneNumber().isEmpty())
				|| (user.getEmail() == null) || (user.getEmail().isEmpty())) {
			throw new ServiceInvalidDataException("Registration error. Invalid data");
		}
		try {
			DAOFactory instance = DAOFactory.getInstance();
			if(instance.getUserDao().registration(user)) {
				return true;
			}
			return false;
		} catch (DAOException e) {
			throw new ServiceException("Registration error", e);
		}
		
	}

	@Override
	public AuthorizationUser authorization(String login, String password) 
			throws ServiceException, ServiceInvalidDataException {
		if((login == null) || (login.isEmpty()) || (password == null) || (password.isEmpty())) {
			throw new ServiceInvalidDataException("Authorization error. Invalid data");
		}
		
		try {
			DAOFactory instance = DAOFactory.getInstance();
			return instance.getUserDao().authorization(login, password);
		} catch(DAOException e) {
			throw new ServiceException("Authorization error");
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
