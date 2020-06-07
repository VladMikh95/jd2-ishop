<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=utf-8">
<title>Authorization
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="local" var="loc" />

	<fmt:message bundle="${loc}" key="local.locbutton.name.ru"	var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en"	var="en_button" />
	<fmt:message bundle="${loc}" key="local.authorization.headerPage" var="headerPage" />
	<fmt:message bundle="${loc}" key="local.authorization.login" var="login" />
	<fmt:message bundle="${loc}" key="local.authorization.password" var="password" />
	<fmt:message bundle="${loc}" key="local.authorization.submit" var="submit" />
	<fmt:message bundle="${loc}" key="local.authorization.failMessage" var="failMessage" />
</title>
</head>
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/Authorization.jsp"/>
		<input type="submit" value="${ru_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/Authorization.jsp"/>
		<input type="submit" value="${en_button}" /><br />
	</form>
	
	<h1><c:out value="${headerPage}" /></h1>
	
	<form action="Controller" method="post">
	  	<input type="hidden" name="command" value="AUTHORIZATION" />
	  	<label for="login"><c:out value="${login}" /></label>
	    <input type="text"  name="login" required>
	    <br><br>

	    <label for="password"><c:out value="${password}" /></label>
	  	<input type="password" id="password" name="password" required>
		<br><br>
		<p>
			<c:if test="${fail == -1}">
				<c:out value = "${failMessage}"/>
			</c:if>
		</p>
	    <input type="submit" value="${submit}">
	  </form>
</body>
</html>