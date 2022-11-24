<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="app">
		<!-- Header -->
		<jsp:include page="/view/client/common/header.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="content">
			<div class="container">
				<div class="single-product">
					<div class="col-2 ">
						<img id="main-img"
							src='<c:url value="${product.img}"></c:url>'
							alt="" class="single-product__img">
						<div class="small-img-row ">
							<c:forEach var="o" items="${imgs}">
							
								<div class="samll-img-col">
									<img class="smallImg"
										src='<c:url value="${o}"></c:url>'
										alt="">
								</div>
							</c:forEach>
							

						</div>
					</div>
					<form method="post" action="add-to-cart" class="col-2">
						<div class="brcum">
							<a href=""> TRANG CHỦ</a>/ <a href="">YÊU THÍCH</a>
						</div>
						<h4 class="single-product-name">${product.name }</h4>
						<div class="single-product-price">
							Giá mới:
							<fmt:formatNumber type="currency" value="${product.price}"></fmt:formatNumber>
							<c:if test="${product.basePrice > product.price }">
								<span>Giá gốc: <fmt:formatNumber type="currency"
										value="${product.basePrice}"></fmt:formatNumber></span>

							</c:if>

						</div>
						<div class="single-product-desc">${product.desc }</div>
						<ul class="details">
							<li>Danh mục : ${product.cateId}</li>
							<li>Tag: ${product.male == true ? "Nam" : "Nữ"} </li>
						</ul>

						<input type="button" id="minus" class="minus detail" value="-">
						<input type="number" id="quantity" class="quantity detail"
							value="1" name="quantity"> <input type="button" id="add"
							class="add detail" value="+"> <input type="hidden"
							name="productId" value="${product.id}">

						<button type="submit" class="btn btn--add">Thêm vào giỏ</button>
						<div class="single-product-id">Mã sản phẩm: P006-1-1-1-1-1</div>
					</form>
				</div>
				<div class="reivew"></div>

			</div>

		</div>
		<!-- Footer -->
		<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>