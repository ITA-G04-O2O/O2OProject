$(function() {
	// 页面默认选择newOrder.html
	$('#change').load('html/newOrder.html');
	// 点击切换
	$('.list-group li').on('click', function() {
		var loadhtml = $(this).attr('id');
		if (loadhtml) {
			$('#change').load('html/' + loadhtml + '.html');
		}
<<<<<<< HEAD
=======

>>>>>>> a69ceeba5ec6d654cc159769040e4344c4cafda8
	});
	$("#accountInfo").live("click", function() {
		showAccount();
	});
	
	$("#newOrder").live("click",function(){
//		alert("Hello");
		loadNewOrderFunction();
	});
	
	$("#successOrder").live("click",function(){
//		alert("Hello");
		loadOrders();
	});

});