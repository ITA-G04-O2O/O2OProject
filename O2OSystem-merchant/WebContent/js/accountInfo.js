$(function() {
	console.log('account Info');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/new",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			$("#jsonData").text(data.message);
		}
	});
});