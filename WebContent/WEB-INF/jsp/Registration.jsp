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
</head> 
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/Registration.jsp"/>
		<input type="submit" value="${ru_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/Registration.jsp"/>
		<input type="submit" value="${en_button}" /><br />
	</form>
	
	<h1 style="text-align:center"><c:out value="${headerPage}" /></h1>
	
		<p style="text-align:center">
		<c:if test="${fail == -1}">
			<c:out value = "${failMessage}"/>
		</c:if>
	</p>
	
	<p style="text-align:center"><c:out value="${message}" /></p>

	<form style="text-align:center" action="Controller" method="post">
            <input type="hidden" name="command" value="REGISTRATION" >

            <label for="login"><c:out value="${login}"></c:out></label>
            <input type="text" id="login" name="login" required>
            <br><br>
            <label for="password"><c:out value="${password}" /></label>
            <input type="password" id="psw" name="password" required>
			<br><br>
			
            <label for="name"><c:out value="${name}" /></label>
            <input type="text" id="name" name="name" required>
			<br><br>
			
            <label for="surname"><c:out value="${surname}" /></label>
            <input type="text" id="surname" name="surname" required>
			<br><br>
            <label for="phoneNumber"><c:out value="${phoneNumber}" /></label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
			<br><br>
            
            <label for="email"><c:out value="${email}" /></label>
            <input type="email" id="email" name="email" required>
			<br><br>

            <input type="submit" value="${submit}">
        </form>
</body>
</html>