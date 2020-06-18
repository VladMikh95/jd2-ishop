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
	<fmt:message bundle="${loc}" key="local.products.wood" var="categoryWood" />
	<fmt:message bundle="${loc}" key="local.products.leather" var="categoryLeather" />
	<fmt:message bundle="${loc}" key="local.products.wool" var="categoryWool" />

</head>
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/products.jsp"/>
		<input type="submit" value="${ru_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="command" value="CHANGE_LOCAL"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/products.jsp"/>
		<input type="submit" value="${en_button}" /><br />
	</form>
	
	<h2><c:if test="${categoryName == 'wood'}">
			<c:out value="${categoryWood}" />
		</c:if>
		<c:if test="${categoryName == 'leather'}">
			<c:out value="${categoryLeather}" />
		</c:if>
		<c:if test="${categoryName == 'wool'}">
			<c:out value="${categoryWool}" />
		</c:if>
	</h2>
	
	<div>
		<c:forEach items="${products}" var="product">
			<div class="product">
				<div class="product-title">
					<c:out value="${product.name}" />
				</div>
				
				<div class="product-picture">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="GET_PRODUCT"/>
						<input type="hidden" name="product" value="${product}"/>
						<button class="btn-local">
							<img class="img-btn" src="${product.imagePath}" height="200" width="200">
						</button>							
					</form>
				</div>
				<div class="product-price">
					<c:out value="${product.price}" />
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>