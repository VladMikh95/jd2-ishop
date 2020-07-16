<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>IShop</title>
	<link rel="stylesheet" href="style.css">
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="local" var="loc" />

	<fmt:message bundle="${loc}" key="local.locbutton.name.ru"	var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en"	var="en_button" />
	<fmt:message bundle="${loc}" key="local.headerPage.one" var="headerPageOne" />
	<fmt:message bundle="${loc}" key="local.headerPage.two" var="headerPageTwo" />
	<fmt:message bundle="${loc}" key="local.button.registration" var="registration" />
	<fmt:message bundle="${loc}" key="local.button.authorization" var="authorization" />
	<fmt:message bundle="${loc}" key="local.button.cart" var="cart" />
	<fmt:message bundle="${loc}" key="local.button.signout" var="signout" />
	<fmt:message bundle="${loc}" key="local.products.wood" var="categoryWood" />
	<fmt:message bundle="${loc}" key="local.products.leather" var="categoryLeather" />
	<fmt:message bundle="${loc}" key="local.products.wool" var="categoryWool" />
	<fmt:message bundle="${loc}" key="local.products.homepage" var="homePage" />
	<fmt:message bundle="${loc}" key="local.products.price" var="price" />

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
			<input type="hidden" name="page" value="WEB-INF/jsp/products.jsp"/>
			<button class="local_button">${ru_button}</button>
		</form>

		<form action="Controller" method="post">
			<input type="hidden" name="local" value="en" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="WEB-INF/jsp/products.jsp"/>
			<button class="local_button">${en_button}</button>
		</form>
	</div>
	
	<div class="menu">
		<c:if test="${user == null}">
			<div>
				<form action="registration" method="post">
					<button class="menu_button">
						<img class="menu_img_button" src="images/registr.svg">
						<div class="text_button">${registration}</div>
					</button>
				</form>
			</div>
		
			<div>
				<form action="authorization" method="post">
					<button class="menu_button">
						<img class="menu_img_button" src="images/signin.svg">
						<div class="text_button">${authorization}</div>
					</button>
				</form>
			</div>
		</c:if>
		
		<c:if test="${user != null}">
			<div class="menu_message">
				<c:out value="${user.name}" />
			</div>
			
			<div>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="SIGN_OUT"/>
					<input type="hidden" name="path" value="index.jsp"/>
					<button class="menu_button">
						<img class="menu_img_button" src="images/signout.svg">
						<div class="text_button">${signout}</div>
					</button>
				</form>
			</div>		
		</c:if>
		
		<div>
				<form action="Controller" method="post">
				<input type="hidden" name="command" value="GET_CART" />
					<button class="menu_button">
						<img class="menu_img_button" src="images/cart.svg">
						<div class="text_button"> ${cart}</div>
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
	
	<div class="products_header">
		<p>
			<c:if test="${categoryName == 'wood'}">
				<c:out value="${categoryWood}" />
			</c:if>
			<c:if test="${categoryName == 'leather'}">
				<c:out value="${categoryLeather}" />
			</c:if>
			<c:if test="${categoryName == 'wool'}">
				<c:out value="${categoryWool}" />
			</c:if>
		</p>
	</div>
	
	<div class="products_list">
		<c:forEach items="${products}" var="product">
			<div class="category">
				<div class="product_title">
					<c:out value="${product.name}" />
				</div>
				
				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="GET_PRODUCT"/>
						<input type="hidden" name="productId" value="${product.id}"/>
						<button class="btn-local">
							<img class="img-btn" src="${product.imagePath}" height="200" width="200">
						</button>							
					</form>
				</div>
				<div >
					<c:out value="${price}" />
					<div class="money">
						<c:out value="${product.price}" />
						<c:out value="BYN" />
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>