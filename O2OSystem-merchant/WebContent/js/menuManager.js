$(function() {
	console.log('Menu Manager');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/menuTypes",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(data.object[0]);
			$("#menuTypeJsonData").text(data.object[0]);
		}
	});
});