<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=utf-8">
<title>Registration</title>
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="local" var="loc" />

	<fmt:message bundle="${loc}" key="local.locbutton.name.ru"	var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en"	var="en_button" />
	<fmt:message bundle="${loc}" key="local.registrationSuccess.headerName" var="headerName" />
	<fmt:message bundle="${loc}" key="local.registrationSuccess.index" var="indexPage" />
	<fmt:message bundle="${loc}" key="local.registrationSuccess.authorization" var="authorization" />
	<fmt:message bundle="${loc}" key="local.headerPage.one" var="headerPageOne" />
	<fmt:message bundle="${loc}" key="local.headerPage.two" var="headerPageTwo" />
	<fmt:message bundle="${loc}" key="local.products.homepage" var="homePage" />
	
	<link rel="stylesheet" href="style.css">
</head>
 
</head>
<body class="body">
	<div class="header">
		<p class="header_text_one"><c:out value="${headerPageOne}" /></p>
		<p class="header_text_two"><c:out value="${headerPageTwo}" /></p>
	</div>
	<div class="local">
		<form action="Controller" method="post">
			<input type="hidden" name="local" value="ru" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="WEB-INF/jsp/registrationSuccess.jsp"/>
			<button class="local_button">${ru_button}</button>
		</form>

		<form action="Controller" method="post">
			<input type="hidden" name="local" value="en" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="WEB-INF/jsp/registrationSuccess.jsp"/>
			<button class="local_button">${en_button}</button>
		</form>
	</div>
	
	<div class="menu">
		<div>
			<form action="authorization" method="post">
				<button class="menu_button">
					<img class="menu_img_button" src="images/signin.svg">
					<div class="text_button">${authorization}</div>
				</button>
			</form>
		</div>
		
		<div>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="GO_TO_INDEX_PAGE"/>
					<button class="menu_button">
						<img class="menu_img_button" src="images/home.svg">
						<div class="text_button"> ${homePage}</div>
					</button>
				</form>
		</div>	
	</div>
	
	<div>
		<c:out value="${headerName}" />
	</div>
</body>
</html>