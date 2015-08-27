$(function() {
	console.log('Menu Manager');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/menuTypes",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			$("#menuTypeJsonData").text(data[0].MenuTypeName);
		}
	});
});