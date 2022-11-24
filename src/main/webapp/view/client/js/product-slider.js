$(document).ready(function() {
	$(".product-slider").hide();
	$(".product-slider").first().fadeIn()
	$(".session-heading span").click(function() {
		$(".session-heading span").removeClass("active");
		$(this).addClass("active");
		let id_tab_content = $(this).children('a').attr('href');
		$(".product-slider").hide();
		$(id_tab_content).fadeIn();
		return false;
	})
	window.onscroll = function() { stickyFuntion() };

	var navbar = document.getElementById("navbar");
	var sticky = navbar.offsetTop;
	function stickyFuntion() {
		if (window.pageYOffset >= sticky) {
			navbar.classList.add("sticky")
		} else {
			navbar.classList.remove("sticky");
		}
	}
	var add = $('#add');
	var minus = $('#minus');
	var quantity = $('#quantity')
	add.click(function() {
		quantity.attr('value', parseInt(quantity.val()) + 1)
	})

	minus.click(function() {
		if (quantity.val() > 1)
			quantity.attr('value', parseInt(quantity.val()) - 1)
	})

	var mainImg = document.querySelector("#main-img");
	var smallImg = document.querySelectorAll(".smallImg")
	smallImg[0].onclick = function() {

		mainImg.src = smallImg[0].src;
	}
	smallImg[1].onclick = function() {
		mainImg.src = smallImg[1].src;
	}
	smallImg[2].onclick = function() {
		mainImg.src = smallImg[2].src;
	}
	smallImg[3].onclick = function() {
		mainImg.src = smallImg[3].src;
	}

});