$(function() {
	console.log('success Order');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/receive",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			$("#receJsonData").text(data.message);
		}
	});
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/finish",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			$("#finishJsonData").text(data.message);
		}
	});
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/fail",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(data);
			$("#failJsonData").text(data.message);
		}
	});


});