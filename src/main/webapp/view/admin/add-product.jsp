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
				<div class="cardHeader1">

					<h2>Thêm sản phẩm</h2>

				</div>
				<form action='<c:url value ="/add-product"></c:url>' method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>Mã sản phẩm</td>
							<td><input type="text" name="id" required="required"></td>
						</tr>
						<tr>
							<td>Tên sản phẩm</td>
							<td><input type="text" name="name" required="required" ></td>
						</tr>

						<tr>
							<td>Category</td>
							<td>
								<select name="cateId" id="cate-chose">
								  <option value="Cas">Casio</option>
								  <option value="Tit">Tissot</option>
								  <option value="Fos">Fossil</option>
								  <option value="Cit">Citizen</option>
								  <option value="App">Apple Watch</option>
								</select>
							</td>
						</tr>

						<tr>
							<td>Giá hiện tại</td>
							<td><input type="number" name="price" required="required"></td>
						</tr>
						<tr>
							<td>Giá gốc</td>
							<td><input type="number" name="basePrice" required="required"></td>
						</tr>

						<tr>
							<td>Hình ảnh</td>
							<td><input type="file" name="images" multiple  required="required"></td>
						</tr>
						<tr>
							<td>Giới tính</td>
							<td class="radio-group">
								
								<div>
									<input id="male" type = "radio" name ="male" value ="0" re>
									<label for="male">Nam</label>
								</div>
								<div>
									<input id="female" type = "radio" name ="male" value="1">
									<label for="female">Nữ</label>
								</div>
							
							</td>
						</tr>

						<tr>
							<td>Mô tả</td>
							<td><input type="text" name="des"
								value=<c:out value="${product.describe}"/>></td>
						</tr>
					</table>
					<div class="save-btn">
					<button type="submit" class="btn btn-success">Save</button>
					</div>
				</form>
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