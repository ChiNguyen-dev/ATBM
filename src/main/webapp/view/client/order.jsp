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
			   <div class="container order">
                <div class="order-left ordered">
                   <div class="order-info ordered">
                      <div class="order-info-wrapper ordered">
                        <h4 class="order-info__heading">Chi tiết đơn hàng</h4>
                        <div class="order__row bold upper ordered">
                            <span>Sản phẩm</span>
                            <span>Tổng</span>
                        </div>
                       <c:forEach var="o" items="${order.orderDetails}">
                        <div class="order__row ordered">
                            <div class="order__product">
                                <span class="order__product-name"> ${o.product.name}</span>
                                <span class="order__product-quantity bold"> x ${o.quantity }</span>
                            </div>
                            <span class="bold"><fmt:formatNumber type="currency" value="${o.getDetailsTotal()}"></fmt:formatNumber></span>
                        </div>
                       </c:forEach>
                        <div class="order__row ordered">
                             <span class="bold">Giao hàng</span>
                             <span>Giao hàng miễn phí</span>
                        </div>
                        <div class="order__row ordered">
                             <span class="bold">Phương thức thanh toán</span>
                             <span>Trả tiền mặt khi nhận hàng</span>
                        </div>
                        <div class="order__row bold ordered">
                         <span>Tổng</span>
                         <span><fmt:formatNumber type="currency" value = "${order.getTotalOrder()}"></fmt:formatNumber></span>
                         </div>
                        
                      </div>
                   </div>
               </div>
               <div class="order-right ordered">
                <div class="ordered-thank">
                   <div class="thank__wrapper">
                    <h4 class="thank__heading">
                        Cảm ơn bạn, đơn hàng của bạn đã được nhận
                    </h4>
                    <ul class="thank__list">
                        <li class="thank__item">
                            Mã đơn hàng : <span>${order.id }</span>
                        </li>
                        <li class="thank__item">
                            Ngày:  <span><fmt:formatDate  value="${order.placeDate}"/></span>
                        </li>
                        <li class="thank__item">
                            Tổng cộng: <span><fmt:formatNumber type="currency" value = "${order.getTotalOrder()}"></fmt:formatNumber></span>
                        </li>
                        <li class="thank__item">
                            Phương thức thanh toán : <span>Trả tiền trước khi nhận hàng</span>
                        </li>
                    </ul>
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