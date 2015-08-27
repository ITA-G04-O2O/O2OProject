$(function() {
	console.log('New Order');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/new",
		type:'GET',
		dataType: 'json',
		success: function(data) {
			$("#jsonData").text(data.object);
		}
	});
});