package by.htp.ishop.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ishop.controller.impl.AuthorizationCommand;
import by.htp.ishop.controller.impl.ChangeLocalCommand;
import by.htp.ishop.controller.impl.ChangeUserStatus;
import by.htp.ishop.controller.impl.GetProductCommand;
import by.htp.ishop.controller.impl.GetProductsByCategoryCommand;
import by.htp.ishop.controller.impl.GoToAuthorizationPageCommand;
import by.htp.ishop.controller.impl.GoToIndexPageCommand;
import by.htp.ishop.controller.impl.GoToMainPageCommand;
import by.htp.ishop.controller.impl.GoToRegistrationSuccessPageCommand;
import by.htp.ishop.controller.impl.RegistrationCommand;
import by.htp.ishop.controller.impl.WrongRequest;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
		commands.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPageCommand());
		commands.put(CommandName.GO_TO_REGISTRATION_SUCCESS_PAGE, 
				new GoToRegistrationSuccessPageCommand());
		commands.put(CommandName.GO_TO_AUTHORIZATION_PAGE, new GoToAuthorizationPageCommand());
		commands.put(CommandName.GET_PRODUCTS_BY_CATEGORY, new GetProductsByCategoryCommand());
		commands.put(CommandName.GET_PRODUCT, new GetProductCommand());
		commands.put(CommandName.CHANGE_LOCAL, new ChangeLocalCommand());
		commands.put(CommandName.CHANGE_USER_STATUS, new ChangeUserStatus());
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	public Command getCommand(String strCommandName) {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(strCommandName.toUpperCase());
			command = commands.get(commandName);
		} catch(IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.WRONG_REQUEST);
		} 
		return command;
	}

}
