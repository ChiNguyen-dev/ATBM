<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="app">
		<!-- Header -->
		<jsp:include page="/view/client/common/header.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="slider">
			<div class="myslider fade" style="display: block;">
				<div class="text ">
					<h3 class="name">
						Mona Watch
						</h3>
						<h2 class="type">
							Đồng hồ Classico
							</h2>
							<p class="slider__text">Cùng với sự phát triển không ngừng
								của thời trang thế giới, rất nhiều thương hiệu cho ra đời những
								mẫu đồng hồ nam chính hãng đa dạng về phong cách, kiểu dáng, màu
								sắc, kích cỡ…</p>
							<button class="shop">Xem sản phẩm</button>
				</div>
				<img
					src="http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/slide-bg-2.jpg"
					alt="" class="silder__img">
			</div>
			<div class="myslider fade">
				<div class="text ">
					<h3 class="name">
						Mona Watch
						</h3>
						<h2 class="type">
							Đồng hồ Classico
							</h2>
							<p class="slider__text">Cùng với sự phát triển không ngừng
								của thời trang thế giới, rất nhiều thương hiệu cho ra đời những
								mẫu đồng hồ nam chính hãng đa dạng về phong cách, kiểu dáng, màu
								sắc, kích cỡ…</p>
							<button class="shop">Xem sản phẩm</button>
				</div>
				<img
					src="http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/slide-bg-1.jpg"
					alt="" class="silder__img">
			</div>
			<a class="previous fade" onclick="plusSlider(-1)">&#10094</a> <a
				class="next fade" onclick="plusSlider(1)">&#10095</a>
			<div class="dotsbox">
				<span class="dot" onclick="currentSlide(1)"></span> <span
					class="dot" onclick="currentSlide(2)"></span>
			</div>
		</div>
		<div class="content">
			<div class="container">
				<!-- Banner 1-->
				<div class="banner">
					<a href="#" class="banner-left"
						style="background-image: url('http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/trend-1.jpg');">
						<div class="banner__txt">
							<h3 class="trend-heading">Xu hướng 2021</h3>
							<h2 class="trend-cate">Đồng hồ nam</h2>
						</div>
					</a> <a href="#" class="banner-right"
						style="background-image: url('http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/trend-2.jpg');">
						<div class="banner__txt">
							<h3 class="trend-heading">Xu hướng 2021</h3>
							<h2 class="trend-cate">Đồng hồ nữ</h2>
						</div>
					</a>
				</div>
				<!-- End banner -->
				<div class="best-seller">
					<div class="session-heading">Sản phẩm bán chạy</div>
					<div class="product__list">
						<c:forEach var="o" items="${listP}">
							<div class="product__item product-slider-content">
								<a
									href='<c:url value="/product-details?productId=${o.id}"></c:url>'>
									<span class="product__img product__4"
									style="background-image: url('<c:url value = "${o.img}"></c:url>');"></span>
								</a> <a class="product__name"
									href='<c:url value="/product-details?productId=${o.id}"></c:url>'>
									<span> ${o.name}</span>
								</a>
								<div class="product__price">
									<span class="product__new-price"><fmt:formatNumber
											type="currency" value="${o.price}"></fmt:formatNumber></span>
									<c:if test="${o.basePrice > o.price}">
										<span class="product__base-price"><fmt:formatNumber
												type="currency" value="${o.basePrice}"></fmt:formatNumber></span>
									</c:if>

								</div>
								<a href='<c:url value="/add-to-cart?productId=${o.id}"></c:url>'
									class="btn add-to-cart">Thêm vào giỏ</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- Banner 2-->
				<div class="banner">
					<a href="#" class="banner-left second-banner"
						style="background-image: url('http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/banner-03.jpg');">
						<div class="banner__txt txt-top">
							<h2 class="trend-cate">Cổ điển</h2>
							<h3 class="trend-desc">Đa dạng về phong cách, kiểu dáng, màu
								sắc, kích cỡ…</h3>
						</div>
					</a> <a href="#" class="banner-right second-banner"
						style="background-image: url('http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/banner-04.jpg');">
						<div class="banner__txt txt-bottom">
							<h2 class="trend-cate">SMART WATCH</h2>
							<h3 class="trend-desc">Đa dạng về phong cách, kiểu dáng, màu
								sắc, kích cỡ…</h3>
						</div>
					</a>
				</div>
				<!-- End banner 2-->

				<!--Feature product-->
				<div class="feature-product">
					<div class="session-heading">
						<!--Tab pane-->
						<span><a href="#tab1" class="tab-heading">Sản phẩm phổ
								biến</a></span>
								 

					</div>
					<!--Tab content-->
					<div id="tab1" class="product__list product-slider product-wrap">
						<c:forEach var="o" items="${list2}" begin="0" end="5">
							<div class="product__item product-slider-content">
								<a
									href='<c:url value="/product-details?productId=${o.id}"></c:url>'>
									<span class="product__img product__4"
									style="background-image: url('<c:url value = "${o.img}"></c:url>');"></span>
								</a> <a class="product__name product__4"
									href='<c:url value="/product-details?productId=${o.id}"></c:url>'>
									<span> ${o.name}</span>
								</a>
								<div class="product__price">
									<span class="product__new-price"><fmt:formatNumber
											type="currency" value="${o.price}"></fmt:formatNumber></span>
									<c:if test="${o.basePrice > o.price}">
										<span class="product__base-price"><fmt:formatNumber
												type="currency" value="${o.basePrice}"></fmt:formatNumber></span>
									</c:if>

								</div>
								<a href='<c:url value="/add-to-cart?productId=${o.id}"></c:url>'
									class="btn add-to-cart">Thêm vào giỏ</a>
							</div>
						</c:forEach>

					</div>


				</div>
				<!--End feature product-->

				<!--Blog Session-->
				<div class="blog">
					<div class="container">
						<div class="blog__wrapper">
							<a href="#" class="blog__box">
								<div class="blog__img">
									<img
										src="http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/new-4.jpg"
										alt="">
								</div>
								<p class="blog__title">Chiếc đồng hồ của những CEO quyền lực
									nhất thế giới</p>
								<p class="blog__text">Đối với một số doanh nhân, một chiếc
									đồng hồ đeo tay không chỉ là ssssssssssssssssssssssssss</p>

							</a> <a href="#" class="blog__box">
								<div class="blog__img">
									<img
										src="http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/new-4.jpg"
										alt="">
								</div>
								<p class="blog__title">Chiếc đồng hồ của những CEO quyền lực
									nhất thế giới</p>
								<p class="blog__text">Đối với một số doanh nhân, một chiếc
									đồng hồ đeo tay không chỉ là ssssssssssssssssssssssssss</p>

							</a> <a href="#" class="blog__box">
								<div class="blog__img">
									<img
										src="http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/new-4.jpg"
										alt="">
								</div>
								<p class="blog__title">Chiếc đồng hồ của những CEO quyền lực
									nhất thế giới</p>
								<p class="blog__text">Đối với một số doanh nhân, một chiếc
									đồng hồ đeo tay không chỉ là ssssssssssssssssssssssssss</p>

							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>