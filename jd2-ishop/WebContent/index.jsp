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
	<fmt:message bundle="${loc}" key="local.button.registration"	var="registration" />
	<fmt:message bundle="${loc}" key="local.button.authorization"	var="authorization" />
	<fmt:message bundle="${loc}" key="local.button.cart" var="cart" />
	<fmt:message bundle="${loc}" key="local.index.wood" var="wood" />
	<fmt:message bundle="${loc}" key="local.index.leather" var="leather" />
	<fmt:message bundle="${loc}" key="local.index.wool" var="wool" />

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
			<input type="hidden" name="page" value="index.jsp"/>
			<button class="local_button">${ru_button}</button>
		</form>

		<form action="Controller" method="post">
			<input type="hidden" name="local" value="en" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="index.jsp"/>
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
				<form action="authorization" method="post">
					<button class="menu_button">
						<img class="menu_img_button" src="images/signout.svg">
						<div class="text_button">${authorization}</div>
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
		
	</div>
	
	<div class="category">
	
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="wood"/>
			<input type="hidden" name="categoryHeader" value= "woodGoods"/>
			<button>
				<img src="images/wood.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${wood}"/>
	</div>
	
	<div class="category">
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="leather"/>
			<input type="hidden" name="categoryHeader" value= "leatherGoods"/>
			<button>
				<img src="images/leather.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${leather}" />
	</div>
	
	<div class="category">
		<div >
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="GET_PRODUCTS_BY_CATEGORY"/>
			<input type="hidden" name="categoryName" value="wool"/>
			<input type="hidden" name="categoryHeader" value= "woolGoods"/>
			<button>
				<img src="images/wool.jpg" height="200" width="200">
			</button>							
		</form>
		</div>
		<c:out value="${wool}"/>	
	</div>
</body>
</html>
