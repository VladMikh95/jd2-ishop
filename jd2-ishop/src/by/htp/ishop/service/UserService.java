package by.htp.ishop.service;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.User;

public interface UserService {
	
	boolean registration(User user) throws ServiceException;
	AuthorizationUser authorization(String login, String password) throws ServiceException;
	boolean changeUserStatus(int id, String newStatus) throws ServiceException;

}
