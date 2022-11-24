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

		<!-- Main content -->

		<div class="content">
			<div class="container">
				<div class="page__title">
					<div class="breadcrumb">
						<a href="#" class="home__link">Trang chủ</a>
						<c:if test="${location != null }"></c:if>
						<span class="current__page">/ đồng hồ ${location}</span>
					</div>
					<form id="sort__product"
						action='<c:url value="/${action}"></c:url>' class="page__sort "
						method="get">
						<span class="sort___text">Hiển thị một kết quả duy nhất</span> <select
							name="sort" id="sort" class="sory__by">
							<option value="default">Thứ tự mặc định</option>
							<option value="price-asc">Giá thấp đến cao</option>
							<option value="price-desc">Giá cao đến thấp</option>
						</select>
						<c:if test="${currentPage != null}">
							<input id="crrPage" type="hidden" name="page"
								value="${currentPage}" />
						</c:if>
						<c:if test="${gender != null}">
							<input type="hidden" name="gender" value="${gender}" />
						</c:if>
						<c:if test="${currentCateId != null}">
							<input id="cateId" type="hidden" name="category"
								value="${currentCateId}" />
						</c:if>
						<c:if test="${pName != null}">
							<input type="hidden" name="pName" value="${pName}" />
						</c:if>

					</form>
				</div>
				<div class="products__wrapper">
					<div class="products__leftside">
						<h2 class="new-title">Danh mục sản phẩm</h2>
						<div class="category-box">
							<c:forEach var="o" items="${listC}">
								<span class="category__link">${o.cateName} <input
									type="hidden" name="cateTemp" value="${o.cateId}" /></span>
							</c:forEach>

						</div>
					</div>
					<div class="products__rigtside">
						<div class="product__list product-wrap">
							<c:forEach var="o" items="${listP}">
								<div class="product__item product-slider-content">

									<a
										href='<c:url value="/product-details?productId=${o.id}"></c:url>'>
										<span class="product__img "
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
									<a
										href='<c:url value="/add-to-cart?productId=${o.id}"></c:url>'
										class="btn add-to-cart">Thêm vào giỏ</a>
								</div>
							</c:forEach>
						</div>
						<div class="pagingation">
							<div class="pagination__wrapper">
								<c:if test="${currentPage > 1}">
									<span id="prevBtn" class="prev-page"><i
										class="fas fa-chevron-left"></i></span>
								</c:if>
								<c:forEach begin="${currentPage - 2 <= 0? 1: currentPage - 2 }"
									end="${currentPage + 2 >= totalPages ?totalPages : currentPage + 2 }"
									var="i">

									<span
										class="page__item <c:if test="${currentPage == i }">page-active</c:if>">${i}</span>


								</c:forEach>

								<c:if test="${currentPage < totalPages}">
									<span id="nextBtn" class="next-page"><i
										class="fas fa-chevron-right"></i></span>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
	$('.category__link').each( function () {
		$(this).click(function(){
			if($("#cateId").val() == undefined){
				var $input = $("<input/>", {id: "cateId", type: "hidden", name: "category", value: "${currentcateId}"})
				$('#sort__product').append($input);
			}
			$("#crrPage").val(1);
			$('#cateId').val($(this).children('input').val());
			$('#sort__product').submit()
		})
	})
	
	
	 $('#sort').on('change', function() {
		    this.form.submit();
		    localStorage.setItem("sort", $(this).val());
		 });
	 if ($('#sort').length && ${sortBy != null}) {
		    $('#sort').val(localStorage.getItem("sort"));
	 }
	
	  var btnPages = document.querySelectorAll('.page__item');
	  var prev =  document.getElementById('prevBtn')
	  var next = document.getElementById('nextBtn')
	  if (prev != null) {
		  prev.addEventListener('click', () => {
			    $("#crrPage").attr('value', ${currentPage - 1})
		         document.getElementById('sort__product').submit()
		  })
		}
	   if(next != null) {
		   next.addEventListener('click', () => {
			    $("#crrPage").attr('value', ${currentPage + 1})
		         document.getElementById('sort__product').submit()
		  })
	   }
	
      btnPages.forEach(item => item.addEventListener('click', () => {
            $("#crrPage").attr('value', item.innerText)
           document.getElementById('sort__product').submit()
       
      }))
	</script>
</body>
</html>