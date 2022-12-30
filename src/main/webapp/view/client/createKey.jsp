<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value = "vi_VN"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Key</title>
</head>
<body>
<div class="app">
    <!-- Header -->
    <jsp:include page="/view/client/common/header.jsp"></jsp:include>

    <!-- Main Content -->
    <div class="container" style="display: flex; justify-content: center; height: 50vh; margin-top: 100px;">
       <div style="width: 50%; ">
           <div class="order-form-group" style="display: flex; justify-content: center; align-items: center;" >
               <label for="" class="title" style="display: inline-block; width: 100px;">public key</label>
               <input  type="text" class="sdt" id="" name="publicKey" value="${publicKey}" disabled>
           </div>
           <div style="display: flex; justify-content: space-between; gap: 12px; margin-top: 20px;">
               <a href='<c:url value = "/create-key"></c:url>'  class="btn btn--place-order">Tạo key</a>
               <a href='<c:url value = "/save-key?publicKey=${publicKey}"></c:url>' class="btn btn--place-order">Lưu Key</a>
           </div>
       </div>
    </div>
    <!-- Footer -->
    <jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</div>
</body>
</html>