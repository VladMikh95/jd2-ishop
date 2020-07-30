package by.htp.ishop.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ishop.controller.impl.AddToCartCommand;
import by.htp.ishop.controller.impl.AuthorizationCommand;
import by.htp.ishop.controller.impl.ChangeLocalCommand;
import by.htp.ishop.controller.impl.ChangeUserStatus;
import by.htp.ishop.controller.impl.ClosePopupCommand;
import by.htp.ishop.controller.impl.DeleteProductFromCartCommand;
import by.htp.ishop.controller.impl.GetCartCommand;
import by.htp.ishop.controller.impl.GetProductCommand;
import by.htp.ishop.controller.impl.GetProductsByCategoryCommand;
import by.htp.ishop.controller.impl.GoToAuthorizationPageCommand;
import by.htp.ishop.controller.impl.GoToIndexPageCommand;
import by.htp.ishop.controller.impl.GoToRegistrationPageCommand;
import by.htp.ishop.controller.impl.GoToRegistrationSuccessPageCommand;
import by.htp.ishop.controller.impl.IncreaseQuantityProductCommand;
import by.htp.ishop.controller.impl.ReduceQuantityProductCommand;
import by.htp.ishop.controller.impl.RegistrationCommand;
import by.htp.ishop.controller.impl.SignOutCommand;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
		commands.put(CommandName.ADD_TO_CART, new AddToCartCommand());
		commands.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPageCommand());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPageCommand());
		commands.put(CommandName.GO_TO_REGISTRATION_SUCCESS_PAGE, 
				new GoToRegistrationSuccessPageCommand());
		commands.put(CommandName.GO_TO_AUTHORIZATION_PAGE, new GoToAuthorizationPageCommand());
		commands.put(CommandName.GET_PRODUCTS_BY_CATEGORY, new GetProductsByCategoryCommand());
		commands.put(CommandName.GET_PRODUCT, new GetProductCommand());
		commands.put(CommandName.GET_CART, new GetCartCommand());
		commands.put(CommandName.REDUCE_QUANTITY_PRODUCT, new ReduceQuantityProductCommand());
		commands.put(CommandName.INCREASE_QUANTITY_PRODUCT, new IncreaseQuantityProductCommand());
		commands.put(CommandName.DELETE_PRODUCT_FROM_CART, new DeleteProductFromCartCommand());
		commands.put(CommandName.CHANGE_LOCAL, new ChangeLocalCommand());
		commands.put(CommandName.CHANGE_USER_STATUS, new ChangeUserStatus());
		commands.put(CommandName.SIGN_OUT, new SignOutCommand());
		commands.put(CommandName.CLOSE_POPUP, new ClosePopupCommand());

	}
	
	public Command getCommand(String strCommandName) {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(strCommandName.toUpperCase());
			command = commands.get(commandName);
		} catch(IllegalArgumentException | NullPointerException e) {
			System.out.println("SGDV");
		} 
		return command;
	}

}
