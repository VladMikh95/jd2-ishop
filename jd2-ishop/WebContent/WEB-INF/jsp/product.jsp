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
	<fmt:message bundle="${loc}" key="local.products.homepage" var="homePage" />
	<fmt:message bundle="${loc}" key="local.products.price" var="price" />
	<fmt:message bundle="${loc}" key="local.product.add.to.cart" var="addToCart" />
	<fmt:message bundle="${loc}" key="local.product.material" var="material" />
	<fmt:message bundle="${loc}" key="local.product.master" var="master" />
	<fmt:message bundle="${loc}" key="local.product.master.phone.number" var="mastersPhoneNumber" />
	<fmt:message bundle="${loc}" key="local.product.popup.add.success" var="addsuccess" />
	<fmt:message bundle="${loc}" key="local.product.popup.already.added" var="alreadyadded" />
	<fmt:message bundle="${loc}" key="local.product.popup.button" var="popupButton" />
	
</head>
<body>
	<div class="body">
	<div class="header">
		<p class="header_text_one"><c:out value="${headerPageOne}" /></p>
		<p class="header_text_two"><c:out value="${headerPageTwo}" /></p>
	</div>
	<div class="local">
		<form action="Controller" method="post">
			<input type="hidden" name="local" value="ru" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="WEB-INF/jsp/product.jsp"/>
			<button class="local_button">${ru_button}</button>
		</form>

		<form action="Controller" method="post">
			<input type="hidden" name="local" value="en" /> 
			<input type="hidden" name="command" value="CHANGE_LOCAL"/>
			<input type="hidden" name="page" value="WEB-INF/jsp/product.jsp"/>
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

	<div class="product">
		<img src="${product.imagePath}" class="product_image">
		
		<div class="product_info">
			<div class="product_title">
				<c:out value="${product.name}" />
			</div>
			
			<form action="Controller" method="post">
					<input type="hidden" name="command" value="ADD_TO_CART" />
					<input type="hidden" name="productId" value="${product.id}" />
					<button class="add_to_cart_button">
						<img class="menu_img_button" src="images/cart.svg">
						<div class="add_to_cart_text"> ${addToCart}</div>
					</button>
			</form>
			<div>
				<div class="text_lime">
					<c:out value="${material}" />
				</div>
				<c:out value="${product.material}" />
			</div>
		</div>
	</div>
	
	<div>
		<div class="text_lime">
			<c:out value="${master}" />
		</div>
		<c:out value="${product.master.name} ${product.master.surname}"  />
		<div class="text_lime">
			<c:out value="${mastersPhoneNumber}" />
		</div>
		<c:out value="${product.master.phoneNumber}"  />
		<div class="text_lime">
			<c:out value="email" />
		</div>
		<c:out value="${product.master.email}"  />
	</div>
	</div>
	
	<c:if test="${requestScope.popupMessage eq 'addSuccess'}" >
	<div class="modal">
	<div class="form">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="CLOSE_POPUP" />
			<input type="hidden" name="productId" value="${product.id}" />
			<div class=text_black>
				<c:out value="${addsuccess}" />
			</div>
			<button class="form_button">${popupButton}</button>
		</form>
		</div>
	</div>
	</c:if>
	
	<c:if test="${requestScope.popupMessage eq 'alreadyAdded'}" >
	<div class="modal">
	<div class="form">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="CLOSE_POPUP" />
			<input type="hidden" name="productId" value="${product.id}" />
			<div class=text_black>
				<c:out value="${alreadyadded}" />
			</div>
			<button class="form_button">${popupButton}</button>
		</form>
	</div>
	</div>
	</c:if>

</body>
</html>