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
				<form action="authorization" method="post">
					<button class="menu_button">
						<img class="menu_img_button" src="images/signout.svg">
						<div class="text_button">${authorization}</div>
					</button>
				</form>
			</div>		
		</c:if>
		
		<div>
				<form action="authorization" method="post">
					<button class="menu_button">
						<img class="menu_img_button" src="images/cart.svg">
						<div class="text_button"> ${authorization}</div>
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
		<h2>${product.name}</h2>
	</div>
	
	<img src="${product.imagePath}" width="300" height="300">
	
	<p>Price: ${product.price}</p>
	<br><br>
	<p>Master: ${product.master.name} ${product.master.surname}</p>
	<p>phone number: ${product.master.phoneNumber}</p>
	<p>e-mail: ${product.master.email}</p>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="ADD_TO_CART"/>
		<input type="hidden" name="page" value="WEB-INF/jsp/products.jsp"/>
		<input type="hidden" name="productId" value="${product.id}"/>
		<input type="submit" value="${ru_button}" /><br />
	</form>

</body>
</html>