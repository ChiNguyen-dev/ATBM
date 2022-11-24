<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="container">
        <div class ="navigation">
            <ul>
                <li>
                    <a href='<c:url value="/admin-product"></c:url>'>
                        <span class="icon"><ion-icon name="watch-outline"></ion-icon></span>
                        <span class="title">NLU WATCH</span>
                    </a>
                </li>
            
                <li>
                   <a href='<c:url value="/admin-order"></c:url>'>
                        <span class="icon"><ion-icon name="receipt-outline"></ion-icon></span>
                        <span class="title">Quản lí hóa đơn</span>
                    </a>
                </li>
                <li>
                   <a href='<c:url value="/admin-product"></c:url>'>
                        <span class="icon"><ion-icon name="bag-handle-outline"></ion-icon></span>
                        <span class="title">Quản lí sản phẩm</span>
                    </a>
                </li>
                
              
                <li>
                    <a href='<c:url value="/logout"></c:url>'>
                        <span class="icon"><ion-icon name="exit-outline"></span>
                        <span class="title">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>