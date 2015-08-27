$(function() {
	
//			console.log(data.object[i].id);
//			console.log(data.object[i].createDate);
//			console.log(data.object[i].status);
//			console.log(data.object[i].connectPeople);
//			console.log(data.object[i].tel);
//			console.log(data.object[i].address);
//			console.log(data.object[i].menuItemAmountMap);
//			console.log(data.object[i].menuItemPriceMap);
//			console.log(data.object[i].totalPrices);
	
	
	var loadReceiveOrders = function() {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/receive",
			type: 'GET',
			dataType: 'json'
		}).done(function(data, status, xhr) {
//			$("#receJsonData").text(data.object.message);
			console.log("rece"+data.object);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};

	var loadFinishOrders = function() {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/finish",
			type: 'GET',
			dataType: 'json'
		}).done(function(data, status, xhr) {
//			$("#finishJsonData").text(data.object.message);
			console.log("finish"+data.object);

		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};

	var loadFailOrders = function() {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/fail",
			type: 'GET',
			dataType: 'json'
		}).done(function(data, status, xhr) {
//			$("#failJsonData").text(data.object.message);
			console.log("fail"+data.object);

		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};
	
	var createTable = function(data){
		
	};

	loadReceiveOrders();
	loadFinishOrders();
	loadFailOrders();
	
});