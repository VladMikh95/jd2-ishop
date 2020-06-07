package by.htp.ishop.dao;

import by.htp.ishop.bean.AuthorizationUser;
import by.htp.ishop.bean.User;

public interface UserDao{
	
	boolean registration(User user) throws DAOException;
	AuthorizationUser authorization(String login, String password) throws  DAOException;
	boolean changeUserStatus(int id, String status) throws DAOException;

}
