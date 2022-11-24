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
		<div class="topbar">

			<!--search-->
			<form action='<c:url value="/admin-search-product"></c:url>' method="get" class="search">
					<div class="search__form-group">
						<input type="text" placeholder="Tìm kiếm" class="search__input" name="pName" value = "${pName }">
						<button type="submit" class="btn btn--search">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
			<!--end search-->
			
		</div>

		<!--detail order-->
		<div class="detailsproduct">
			<form id="admin-paging" action='<c:url value="/${action}"></c:url>' method="get"
				class="product">
				<div class="cardHeader3">
					<h2>Danh sách sản phẩm </h2>
					<a href='<c:url value ="/view/admin/add-product.jsp"></c:url>'
						class="btn insert" title="Thêm sản phẩm"><i class="fa-solid fa-plus"></i></a>
				</div>
				<table>
					<thead>
						<tr>
							<td>Ảnh</td>
							<td>Tên sản phẩm</td>
							<td>Giá</td>
							<td>Danh Mục</td>
							<td></td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${listP}">
							<tr>
								<td width="60px"><div class="imgBox">
										<img src='<c:url value="${product.img}"></c:url>'>
									</div></td>
								<td><c:out value="${product.name}" /></td>
								<td><span><fmt:formatNumber type="currency"
											value="${product.basePrice}"></fmt:formatNumber></span></td>
								<td><c:out value="${product.cateId}" /></td>
								<td><a href='<c:url value="/load-product?pid=${product.id}"></c:url>'
									class="btn edit"><i class="fas fa-edit"></i></a>&nbsp;
									<a
									href='<c:url value="/admin-delete-product?pId=${product.id}"></c:url>'
									class="btn delete"><i class="fa-solid fa-trash-can"></i></a>
								</td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
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
				<input id="crrPage" type="hidden" name="page" value="${currentPage}" />
			</form>
		</div>

	</div>


	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodules
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script type="text/javascript">
    var btnPages = document.querySelectorAll('.page__item');
	  var prev =  document.getElementById('prevBtn')
	  var next = document.getElementById('nextBtn')
	  if (prev != null) {
		  prev.addEventListener('click', () => {
			    $("#crrPage").attr('value', ${currentPage - 1})
		         document.getElementById('admin-paging').submit()
		  })
		}
	   if(next != null) {
		   next.addEventListener('click', () => {
			    $("#crrPage").attr('value', ${currentPage + 1})
		         document.getElementById('admin-paging').submit()
		  })
	   }
	
    btnPages.forEach(item => item.addEventListener('click', () => {
          $("#crrPage").attr('value', item.innerText)
         document.getElementById('admin-paging').submit()
     
    }))
    </script>
	<script src="includes-admin/admin.js"></script>
</body>
</html>