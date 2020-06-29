<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=utf-8">
<title>Authorization</title>
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="local" var="loc" />

	<fmt:message bundle="${loc}" key="local.locbutton.name.ru"	var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en"	var="en_button" />
	<fmt:message bundle="${loc}" key="local.button.registration"	var="registration" />
	<fmt:message bundle="${loc}" key="local.authorization.headerPage" var="headerPage" />
	<fmt:message bundle="${loc}" key="local.authorization.login" var="login" />
	<fmt:message bundle="${loc}" key="local.authorization.password" var="password" />
	<fmt:message bundle="${loc}" key="local.authorization.submit" var="submit" />
	<fmt:message bundle="${loc}" key="local.authorization.failMessage" var="failMessage" />
	<fmt:message bundle="${loc}" key="local.authorization.ask.registr" var="askRegistr" />
	
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body class="body_form">
	<div class="form">	
		<div class="local_form">
			<form action="Controller" method="post">
				<input type="hidden" name="local" value="ru" /> 
				<input type="hidden" name="command" value="CHANGE_LOCAL"/>
				<input type="hidden" name="page" value="WEB-INF/jsp/Authorization.jsp"/>
				<button class="local_button">${ru_button}</button>
			</form>

			<form action="Controller" method="post">
				<input type="hidden" name="local" value="en" /> 
				<input type="hidden" name="command" value="CHANGE_LOCAL"/>
				<input type="hidden" name="page" value="WEB-INF/jsp/Authorization.jsp"/>
				<button class="local_button">${en_button}</button>
			</form>
		</div>

		<form action="Controller" method="post">
			<h1 class="form_title"><c:out value="${headerPage}" /></h1>
		
	  		<input type="hidden" name="command" value="AUTHORIZATION" />
	  		<div class="form_grup">
	  			<label for="login" class="form_text"><c:out value="${login}" /></label>
	    		<input type="text"  name="login" required class="form_input">
	  		</div>
	  	
	  		<div class="form_grup">
	  			<label for="password" class="form_text"><c:out value="${password}" /></label>
	  			<input type="password" id="password" name="password" required class="form_input">
	  		</div>

	    	<div>
	    		<p class="error_message">
					<c:if test="${fail == -1}">
						<c:out value = "${failMessage}"/>
					</c:if>
				</p>
	    	</div>
			<button class="form_button">${submit}</button>
		</form>
		
		<div class="text_black">
			<c:out value="${askRegistr}" />
		</div >
			
		<div class="link">
			<a href="registration" class="link_text"><c:out value="${registration}" /></a>
		</div>

	</div>
</body>
</html>