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
		<div class="container">
		<form action='<c:url value="/register"></c:url>' class="login-form">
			<div class="login__img">
				<img src="https://i.pinimg.com/736x/3e/00/b4/3e00b4c574ca1da703d8058c7e927370.jpg" alt="">
			</div>
			<div class="login__main">
			   <div class="login__main__wrapper">
				  <div class="sign-up__title">
					  <h4 class="sign-up__heading">Đăng ký</h4>
				  </div>
				  <div class="sign-up__form-group small">
					<div class="sign-up__form-group">
						<lab class="sub-title" for="username">Họ và Tên</lab>
					  <input required="required" type="text" class="sign-up__input" name="lastname" placeholder="Nhập họ">
					</div>
					<div class="sign-up__form-group">
						<lab class="sub-title" for="username">Email</lab>
					  <input  required="required" type="email" class="sign-up__input" name="email" placeholder="Nhập tên">
					</div>
				  </div>
				  <div class="sign-up__form-group">
					  <lab class="sub-title" for="username">Tài khoản</lab>
					<input  required="required" type="text" class="sign-up__input" name="username" placeholder="Nhập tài khoản">
				  </div>
				  <div class="sign-up__form-group">
					  <lab class="sub-title" for="username">Mật khẩu</lab>
					<input  required="required" type="password" class="sign-up__input" name="password" placeholder="Nhập mật khẩu">
				  </div>
				   <div class="sign-up__form-group">
					   <lab class="sub-title" for="username">Public Key:</lab>
					   <input  required="required" type="password" class="sign-up__input" name="p_key" placeholder="Nhập khóa công khai">
				   </div>
				  <button type="submit" class="btn btn-signin">Đăng ký</button>
				  <div class="not-member">
					Đã có tài khoản? <a href='<c:url value ="/view/client/login.jsp"></c:url>' class="sign-up">Đăng nhập</a>
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