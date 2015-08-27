$(function() {
	console.log('New Order');
	$.ajax({
		url: "http://localhost:17236/o2osystem-merchant/orders/new",
		type: 'GET',
		dataType: 'json',
		success: function(data) {
//			console.log("newOrder length is :"+data.object.length);
			for (var i = 0; i < data.object.length; i++) {
				console.log(data.object[i].id);
				console.log(data.object[i].createDate);
				console.log(data.object[i].status);
				console.log(data.object[i].connectPeople);
				console.log(data.object[i].tel);
				console.log(data.object[i].address);
				console.log(data.object[i].menuItemMap);
				console.log(data.object[i].totalPrices);
				
				
				
				
				
			}
		}
	});
});