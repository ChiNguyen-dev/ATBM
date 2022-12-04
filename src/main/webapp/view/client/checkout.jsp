<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:setLocale value = "vi_VN"/>
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
			<form method="post" action='<c:url value="/place-order"></c:url>'
				class="container order">
				<div class="order-left">
					<div class="order-form">
						<h4 class="order-form__heading">Thông tin thanh toán</h4>
						<div class="order-form-group small">
							<div class="form-group-small">
								<label for="ho" class="title">Họ Tên*</label> <input type="text"
									id="ho" class="ho" name="ho" required="required">
							</div>
							<div class="form-group-small">
								<label for="email" class="title">Email*</label>
								<input type="email" id="email" class="ten" name="email"  required="required">
							</div>
						</div>
						<div class="order-form-group">
							<label for="diachi" class="title">Địa chỉ*</label> <input
								type="text" class="diachi" id="diachi" name="diachi" required="required">
						</div>
						<div class="order-form-group">
							<label for="thanhpho" class="title">Thành phố*</label> <input
								type="text" class="thanhpho" id="thanhpho" name="thanhpho" required="required">
						</div>
						<div class="order-form-group">
							<label for="sdt" class="title">Số điện thoại*</label> <input
								type="text" class="sdt" id="sdt" name="sdt" required="required">
						</div>
						<div class="order-form-group">
							<label for="ghichu" class="title">Public key</label>
							<textarea name="pKey" id="ghichu" rows="10"></textarea>
						</div>
					</div>
				</div>
				<div class="order-right">
					<div class="order-info">
						<div class="order-info-wrapper">
							<h4 class="order-info__heading">Đơn hàng của bạn</h4>
							<div class="order__row bold upper">
								<span>Sản phẩm</span> <span>Tổng</span>
							</div>
							<c:forEach var="o" items="${cart.items}">
								<div class="order__row">
									<div class="order__product">
										<span class="order__product-name">${o.value.product.name }</span>
										<span class="order__product-quantity bold"> x
											${o.value.quantity }</span>
									</div>
									<span class="bold"><fmt:formatNumber type="currency"
											value="${o.value.price}"></fmt:formatNumber></span>
								</div>
							</c:forEach>
							<div class="order__row">
								<span class="bold">Giao hàng</span> <span>Giao hàng miễn
									phí</span>
							</div>
							<div class="order__row bold">
								<span>Tổng</span> <span><fmt:formatNumber type="currency"
											value="${cart.getTotalPrice()}"></fmt:formatNumber></span>
							</div>
							<button type="submit" class="btn btn--place-order">Đặt
								hàng</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- Footer -->
		<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>