<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Footer -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer class="footer">
	<div class="container">
		<div class="footer__content">
			<div class="footer-col">
				<h4 class="footer__heading">Thông tin liên hệ</h4>
				<ul class="footer__list">
					<li class="footer__list__item"><i
						class="fas fa-map-marker-alt"></i>319 C16 Lý Thường Kiệt, Phường
						15, Quận 11, Tp.HCM</li>
					<li class="footer__list__item">076 922 0162</li>
					<li class="footer__list__item">demonhunterg@gmail.com</li>
					<li class="footer__list__item">demonhunterp</li>
				</ul>
			</div>
			<div class="footer-col">
				<h4 class="footer__heading">Liên kết</h4>
				<ul class="footer__list">
					<li class="footer__list__item"><a href="#" class="link">Giới
							thiệu</a></li>
					<li class="footer__list__item"><a href="#" class="link">Đồng
							hồ nam</a></li>
					<li class="footer__list__item"><a href="#" class="link">Đồng
							hồ nữ</a></li>
					<li class="footer__list__item"><a href="#" class="link">Blogs</a></li>
					<li class="footer__list__item"><a href="#" class="link">Liên
							hệ</a></li>
				</ul>
			</div>
			<div class="footer-col">
				<h4 class="footer__heading">Hỗ trợ</h4>
				<ul class="footer__list">
					<li class="footer__list__item"><a href="#" class="link">Hướng
							dẫn mua hàng</a></li>
					<li class="footer__list__item"><a href="#" class="link">Hướng
							dẫn thanh toán</a></li>
					<li class="footer__list__item"><a href="#" class="link">Chính
							sách bảo hành</a></li>
					<li class="footer__list__item"><a href="#" class="link">Chính
							sách đổi trả</a></li>
					<li class="footer__list__item"><a href="#" class="link">Tư
							vấn khách hàng</a></li>

				</ul>
			</div>
			<div class="footer-col">
				<h4 class="footer__heading">Tải ứng dụng trên</h4>
				<ul class="footer__list">
					<li class="footer__list__item">Ứng dụng Mona Watch hiện có sẵn
						trên Google Play & App Store. Tải nó ngay.</li>
					<li class="footer__list__item"><a href="#" class="link"> <img
							src="	http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/img-googleplay.jpg"
							alt="">
					</a></li>
					<li class="footer__list__item"><a href="#" class="link"> <img
							src="	http://mauweb.monamedia.net/donghohaitrieu/wp-content/uploads/2019/07/img-appstore.jpg"
							alt="">
					</a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>

<script>
	window.onscroll = function() {
		stickyFuntion()
	};

	var navbar = document.getElementById("navbar");
	var sticky = navbar.offsetTop;
	function stickyFuntion() {
		if (window.pageYOffset >= sticky) {
			navbar.classList.add("sticky")
		} else {
			navbar.classList.remove("sticky");
		}
	}
</script>
<script src='<c:url value="/view/client/js/slider.js"></c:url>'></script>
<script src='<c:url value="/view/client/js/product-slider.js"></c:url>'></script>
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.js"></script>
