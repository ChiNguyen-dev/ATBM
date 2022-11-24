<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NLU Watch</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href='<c:url value ="/view/client/css/style.css"></c:url>'>
	<link rel="stylesheet"
	href='<c:url value = "/view/client/css/order.css"></c:url>'>
	<link rel="stylesheet"
	href='<c:url value = "/view/client/css/single-product.css"></c:url>'>

<link rel="stylesheet"
	href='<c:url value = "/view/client/css/login.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value = "/view/client/css/cart.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value = "/view/client/css/shop.css"></c:url>'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />

</head>
<header class="header">
	<div class="top-header">
		<div class="container">
			<div class="top-header__content">
				<div class="shop-info">
					<div class="shop__address">
						<i class="fas fa-map-marker-alt"></i> 319 - C16 Lý Thường Kiệt,
						P.15, Q.11, Tp.HCM
					</div>
					<div class="shop__phone">
						<i class="fas fa-phone-alt"></i> 076 922 0162
					</div>
				</div>
				<div class="shop-socials">
					<c:if test="${user == null }">
						<a href='<c:url value="/view/client/login.jsp"></c:url>' class="log__action">Đăng nhập</a>
						<a href='<c:url value="/view/client/register.jsp"></c:url>' class="log__action">Đăng ký</a>
					</c:if>
					<c:if test="${user != null}">
					<span>Hi ${user.lastName }!</span>
					<a href='<c:url value="/logout"></c:url>' class="log__action">Đăng xuất</a>
					</c:if>
					<i class="fab fa-facebook-square"></i> <i class="fab fa-instagram"></i>
					<i class="fab fa-twitter"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="main-header">
		<div class="container">
			<div class="main-header__content">
				<a href='<c:url value="/home"></c:url>' class="logo">  NLU Watch </a>
				<form action='<c:url value="/search"></c:url>' method="get" class="search">
					<div class="search__form-group">
						<input type="text" placeholder="Tìm kiếm" class="search__input" name="pName" value = "${pName }">
						<button type="submit" class="btn btn--search">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<div class="header__cart">
					<a href='<c:url value="/view/client/cart.jsp"></c:url>' class="header__cart__link"> 
					<i class="fas fa-shopping-cart"></i>
					<c:if test="${cart.items.size() > 0 }">
						 <span class="header__cart__quantity">${cart.items.size() }</span>
					 </c:if>
					</a>
				</div>
			</div>
		</div>
	</div>
	<nav id="navbar" class="navbar">
		<ul class="list">
			<li class="list__item"><a href='<c:url value="/home"></c:url>' class="list__item__link">Trang
					chủ</a></li>
			<li class="list__item"><a href='<c:url value="/shop?gender=1"></c:url>' class="list__item__link">Đồng
					hồ nam</a></li>
			<li class="list__item"><a href='<c:url value="/shop?gender=0"></c:url>' class="list__item__link">Đồng
					hồ nữ</a></li>
			
		</ul>
	</nav>
</header>


