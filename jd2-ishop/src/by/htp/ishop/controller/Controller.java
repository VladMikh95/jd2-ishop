package by.htp.ishop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.controller.CommandProvider;

public class Controller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String COMMAND_NAME = "command";


	
	private final CommandProvider provider = new CommandProvider();
	
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req, resp);
	 }


	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     processRequest(req, resp);
	 }
	 
	 private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	     String commandName;
	     Command command;
	     commandName = req.getParameter(COMMAND_NAME);
	     command = provider.getCommand(commandName);
	     command.execute(req,resp);

	 } 
}
