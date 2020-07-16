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
	<fmt:message bundle="${loc}" key="local.registration.headerPage" var="headerPage" />
	<fmt:message bundle="${loc}" key="local.registration.message" var="message" />
	<fmt:message bundle="${loc}" key="local.registration.login" var="login" />
	<fmt:message bundle="${loc}" key="local.registration.password" var="password" />
	<fmt:message bundle="${loc}" key="local.registration.name" var="name" />
	<fmt:message bundle="${loc}" key="local.registration.surname" var="surname" />
	<fmt:message bundle="${loc}" key="local.registration.phoneNumber" var="phoneNumber" />
	<fmt:message bundle="${loc}" key="local.registration.email" var="email" />
	<fmt:message bundle="${loc}" key="local.registration.submit" var="submit" />
	<fmt:message bundle="${loc}" key="local.registration.failMessage" var="failMessage" />
	
	<link rel="stylesheet" href="style.css">
</head> 
<body class="body_form">
	<div class="form">
		<div class="local_form">
			<form action="Controller" method="post">
				<input type="hidden" name="local" value="ru" /> 
				<input type="hidden" name="command" value="CHANGE_LOCAL"/>
				<input type="hidden" name="page" value="WEB-INF/jsp/Registration.jsp"/>
				<button class="local_button">${ru_button}</button>
			</form>

			<form action="Controller" method="post">
				<input type="hidden" name="local" value="en" /> 
				<input type="hidden" name="command" value="CHANGE_LOCAL"/>
				<input type="hidden" name="page" value="WEB-INF/jsp/Registration.jsp"/>
				<button class="local_button">${en_button}</button>
			</form>
		</div>

		<form action="Controller" method="post">
			<h1 class="form_title"><c:out value="${headerPage}" /></h1>
			<c:if test="${param.fail != 'invalidData'}"> 
				<p  class="form_text"><c:out value="${message}" /></p>
			</c:if>
			
			<c:if test="${param.fail == 'invalidData'}"> 
				<p  class="error_message"><c:out value="${message}" /></p>
			</c:if>
			
			<p class="error_message">
				<c:if test="${param.fail == 'userAlreadyExist'}">
					<c:out value = "${failMessage}"/>
				</c:if>
			</p>
            <input type="hidden" name="command" value="REGISTRATION" >

            <label for="login" class="form_text"><c:out value="${login}"></c:out></label>
            <input type="text" id="login" name="login"  class="form_input">
            <br><br>
            <label for="password" class="form_text"><c:out value="${password}" /></label>
            <input type="password" id="psw" name="password" class="form_input">
			<br><br>
			
            <label for="name" class="form_text"><c:out value="${name}" /></label>
            <input type="text" id="name" name="name"  class="form_input">
			<br><br>
			
            <label for="surname" class="form_text"><c:out value="${surname}" /></label>
            <input type="text" id="surname" name="surname"  class="form_input">
			<br><br>
            <label for="phoneNumber" class="form_text"><c:out value="${phoneNumber}" /></label>
            <input type="text" id="phoneNumber" name="phoneNumber"  class="form_input">
			<br><br>
            
            <label for="email" class="form_text"><c:out value="${email}" /></label>
            <input type="email" id="email" name="email" class="form_input">
			<br><br>

            <button class="form_button">${submit}</button>
        </form>
        </div>
</body>
</html>