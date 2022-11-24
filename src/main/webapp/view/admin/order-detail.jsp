<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/admin/includes-admin/style.css">
<title>Admin</title>
</head>
<body>
	<%@ include file="includes-admin/header.jsp"%>

	<!-- main -->
	<div class="main">
		
		<div class="listOrder">
			<div class="order">

				<table class="order-table">
					<tr>
						<th>Sản phẩm</th>
						<th>Số lượng</th>
						<th>Tổng tiền sản phẩm</th>
					</tr>

					<c:forEach var="o" items = "${ods}">
						<tr>
							<td>
								<div class="detail-info">
									<img class="order-detail-image" src='<c:url value="${o.product.img }"></c:url>'>
									<div>
										<p>${o.product.name }</p>
										<small>Giá: <fmt:formatNumber
													type="currency" value="${o.product.basePrice}"></fmt:formatNumber></small>

									</div>
								</div>
							</td>

							<td>${o.quantity}</td>
							<td><fmt:formatNumber
													type="currency" value="${o.product.price * o.quantity}"></fmt:formatNumber></td>
						</tr>
					</c:forEach>

				</table>
				<div class="total-price">
					<table>
						
						<tr>
							<td>Tổng hóa đơn</td>
							<td><fmt:formatNumber
													type="currency" value="${total}"></fmt:formatNumber></td>
						</tr>
						<tr>
					</table>
				</div>

			</div>
		</div>


	</div>

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodules
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="includes-admin/admin.js"></script>

</body>
</html>