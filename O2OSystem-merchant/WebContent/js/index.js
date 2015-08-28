$(function() {
	// 页面默认选择newOrder.html
	$('#change').load('html/newOrder.html');
	// 点击切换
	$('.list-group li').on('click', function() {
		var loadhtml = $(this).attr('id');
		if (loadhtml) {
			$('#change').load('html/' + loadhtml + '.html');
		}
	});
	$("#accountInfo").live("click", function() {
		showAccount();
	});

	$("#newOrder").live("click", function() {
		// alert("Hello");
		loadNewOrderFunction();
	});

	$("#successOrder").live("click", function() {
		// alert("Hello");
		loadOrders();
	});


	var restid = 2;

	//title  restaurant/{id}
	//	var loadFailOrders = function() {
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/restaurant/" + restid,
		type: 'GET',
		dataType: 'json'
	}).done(function(data, status, xhr) {

		$("#restName").text(data.name);
		$("#restGrade").text(data.grade);
		$("#restOpenTime").text(data.openTime);
		$("#collectionTimes").text(data.collectionTimes);
	}).fail(function(xhr, status, error) {
		console.log('fail');
	});
	//};

	$("#newOrder").live("click", function() {
		// alert("Hello");
		loadNewOrderFunction();
	});

	$("#successOrder").live("click", function() {
		// alert("Hello");
		loadOrders();
	});
	$("#storeInfo").live("click", function() {
		loadRestInfo();
	});
	$("#basicInfo").live("click", function() {
		loadBasicInfo();
	});

});