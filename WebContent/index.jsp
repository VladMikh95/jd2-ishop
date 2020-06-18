<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>IShop</title>
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="local" var="loc" />

	<fmt:message bundle="${loc}" key="local.locbutton.name.ru"	var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en"	var="en_button" />
	<fmt:message bundle="${loc}" key="local.index.headerPage"	var="headerPage" />
	<fmt:message bundle="${loc}" key="local.index.button.registration"	var="registration" />
	<fmt:message bundle="${loc}" key="local.index.button.authorization"	var="authorization" />
	<fmt:message bundle="${loc}" key="local.index.wood" var="wood" />
	<fmt:message bundle="${loc}" key="local.index.leather" var="leather" />
	<fmt:message bundle="${loc}" key="local.index.wool" var="wool" />
</head>
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="index.jsp"/>
		<input type="submit" value="${ru_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="index.jsp"/>
		<input type="submit" value="${en_button}" /><br />
	</form>
	<h2><c:out value="${headerPage}" /></h2>

	<a href="registration"><c:out value="${registration}" /></a>
	<a href="authorization"><c:out value="${authorization}" /></a>
	
	<br><br>
	
	<c:if test="${user != null}">
						<c:out value="${user.name}" />
	</c:if>
	
	<div>
	
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="wood"/>
			<input type="hidden" name="categoryHeader" value= "woodGoods"/>
			<button class="btn-local">
				<img class="img-btn" src="images/wood.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${wood}"/>
	</div>
	
	<div>
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="leather"/>
			<input type="hidden" name="categoryHeader" value= "leatherGoods"/>
			<button class="btn-local">
				<img class="img-btn" src="images/leather.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${leather}" />
	</div>
	
	<div>
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="wool"/>
			<input type="hidden" name="categoryHeader" value= "woolGoods"/>
			<button class="btn-local">
				<img class="img-btn" src="images/wool.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${wool}"/>	
	</div>
		
	

</body>
</html>
