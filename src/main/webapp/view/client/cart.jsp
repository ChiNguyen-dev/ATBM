<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value = "vi_VN"/>
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
    <div class="content">
        <c:if test="${cart.items.size() == 0 || cart == null}">
            <div class="empty-cart">
                <div class="empty-cart__wrapper">
                    <h4 class="empty-cart__heading">Chưa có sản phẩm nào trong giỏ hàng</h4>
                    <a href='<c:url value="/shop?gender=1"></c:url>' class="btn btn--continue-shopping">Cửa hàng đồng hồ nam</a>
                    <a href='<c:url value="/shop?gender=0"></c:url>' class="btn btn--continue-shopping">Cửa hàng đồng hồ nữ</a>
                </div>
            </div>
        </c:if>
        <c:if test="${cart.items.size() > 0}">
            <div class="container cart">
                <div class="cart-left">
                    <table class="cart-details">
                        <thead class="cart__row">
                        <tr >
                            <th class="cart__heading">
                                Sản Phẩm
                            </th>
                            <th class="cart__heading">
                                Giá
                            </th>
                            <th class="cart__heading">
                                Số lượng
                            </th>
                            <th class="cart__heading">
                                Tổng
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="o" items="${cart.items}">
                            <tr class="cart__row">
                                <td class="cart__product">
                                    <a itemId="${o.key}" id="remove" class="item--remove"><i class="far fa-times-circle"></i></a>
                                    <a href="#" class="item__img">
                                        <img src='<c:url value="${o.value.product.img }"></c:url>' alt="">
                                    </a>

                                    <a href="#" class="item__name">${o.value.product.name}</a>
                                </td>
                                <td class="cart__price">
                                    <fmt:formatNumber type="currency" value="${o.value.product.price}"></fmt:formatNumber>
                                </td>
                                <td class="cart__quantity">
                                    <a itemId="${o.key}" class="minus">-</a>
                                    <input type="number" class="quantity" value="${o.value.quantity }" name="quantity">
                                    <a  itemId="${o.key}" class="add">+</a>
                                </td>
                                <td class="cart__total item--total"> <fmt:formatNumber type="currency" value="${o.value.price}"></fmt:formatNumber></td>
                            </tr>

                        </c:forEach>


                        </tbody>
                    </table>
                    <a href='<c:url value="/shop?gender=${gender == true? 1: 0}"></c:url>' class="btn btn--continue"> <i class="fas fa-long-arrow-alt-left"></i>Tiếp tục xem sản phẩm</a>
                </div>
                <div class="cart-right">
                    <h4 class="order__title">
                        Thông tin đơn hàng
                    </h4>
                    <div class="fee">
                        <span class="fee__text">Tổng sản phẩm</span>
                        <span class="fee__number cart--total"><fmt:formatNumber type="currency" value="${cart.getTotalPrice()}"></fmt:formatNumber></span>
                    </div>
                    <div class="fee">
                        <span class="fee__text">Giao hàng</span>
                        <span class="fee__number">Miễn phí</span>
                    </div>
                    <div class="fee">
                        <span class="fee__text">Tổng</span>
                        <span   class="fee__number cart--total"><fmt:formatNumber type="currency" value="${cart.getTotalPrice()}"></fmt:formatNumber></span>
                    </div>
                    <a href='<c:url value="/checkoutprocess"></c:url>' class="btn btn--place-order">
                        Tiến hành đặt hàng
                    </a>
                </div>
            </div>
        </c:if>

    </div>
    <!-- Footer -->
    <jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</div>
<script type="text/javascript">
    $('.add').click(function() {
        var itemId = $(this).attr('itemId')
        input = $(this).closest("tr").find("input[name='quantity']")
        itemTotal= $(this).closest('tr').find('td:eq(3)')
        $.ajax({
            type: "GET",
            url: "<c:url value = "/addjust"></c:url>",
            data: {
                itemId: itemId
            },
            success: function(data){
                var map = data.items;
                var total = 0

                for(var key in map){
                    total += map[key].price
                }
                for (var key in map) {
                    if (map.hasOwnProperty(key)) {
                        if(key == itemId){

                            input.val(map[key].quantity)
                            var formatter = new Intl.NumberFormat('vi-VN', {
                                style: 'currency',
                                currency: 'VND',
                            });
                            itemTotal.text(formatter.format(map[key].quantity * map[key].product.price ))
                            $('.cart--total').html(formatter.format(total))

                        }
                    }
                }}
        });
    })
    $('.minus').click(function() {
        var itemId = $(this).attr('itemId')
        itemTotal= $(this).closest('tr').find('td:eq(3)')
        input = $(this).closest("tr").find("input[name='quantity']")
        if (input.val() > 1) {
            $.ajax({
                type: "GET",
                url: "<c:url value = "/minus"></c:url>",
                data: {
                    itemId: itemId
                },
                success: function(data){
                    var map = data.items;
                    var total = 0

                    for(var key in map){
                        total += map[key].price

                    }
                    for (var key in map) {
                        if (map.hasOwnProperty(key)) {
                            if(key == itemId){

                                input.val(map[key].quantity)
                                var formatter = new Intl.NumberFormat('vi-VN', {
                                    style: 'currency',
                                    currency: 'VND',
                                });
                                itemTotal.text(formatter.format(map[key].quantity * map[key].product.price ))

                                $('.cart--total').html(formatter.format(total))

                            }
                        }
                    }}
            });
        }
        if(input.val() <= 1){

            tr = $(this).closest("tr")
            $.ajax({
                type: "GET",
                url: "<c:url value = "/remove"></c:url>",
                data: {
                    itemId: itemId
                },
                success: function(data){
                    tr.remove();
                    var map = data.items;
                    var total = 0
                    var count = 0;
                    for(var key in map){
                        total += map[key].price
                        count++;
                    }
                    $('.header__cart__quantity').text(count)
                    if (count <=0) {
                        $('.header__cart__quantity').remove()
                    }
                    var formatter = new Intl.NumberFormat('vi-VN', {
                        style: 'currency',
                        currency: 'VND',
                    });
                    $('.cart--total').html(formatter.format(total))

                }
            });
        }

    })

    $('.item--remove').click(function(){
        var itemId = $(this).attr('itemId');
        tr = $(this).closest("tr")
        $.ajax({
            type: "GET",
            url: "<c:url value = "/remove"></c:url>",
            data: {
                itemId: itemId
            },
            success: function(data){
                tr.remove();

                var map = data.items;
                var total = 0
                var count = 0;
                for(var key in map){
                    total += map[key].price
                    count++;
                }
                $('.header__cart__quantity').text(count)
                if (count <=0) {
                    $('.header__cart__quantity').remove()
                }
                var formatter = new Intl.NumberFormat('vi-VN', {
                    style: 'currency',
                    currency: 'VND',
                });
                $('.cart--total').html(formatter.format(total))

            }
        });
    })

</script>
</body>
</html>