$(function() {
	//页面默认选择newOrder.html
	$('#change').load('html/newOrder.html');
	//点击切换
	$('.list-group li').on('click', function() {
		var loadhtml = $(this).attr('id');
		if (loadhtml) {
			$('#change').load('html/' + loadhtml + '.html');
			
		}
	});
});