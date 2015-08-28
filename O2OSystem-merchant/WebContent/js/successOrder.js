//$(function() {

	var loadReceiveOrders = function() {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/receive",
			type: 'GET',
			dataType: 'json'
		}).done(function(data, status, xhr) {
			console.log("rece" + data.object);
			createOrdersDiv('rece', data);
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
			console.log("finish" + data.object);
			createOrdersDiv('finish', data);

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
			console.log("fail" + data.object);
			createOrdersDiv('fail', data);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};


	//			console.log(data.object[i].id);
	//			console.log(data.object[i].createDate);	
	//			console.log(data.object[i].receDate);
	//			console.log(data.object[i].completedDate);
	//			console.log(data.object[i].status);
	//			console.log(data.object[i].connectPeople);
	//			console.log(data.object[i].tel);
	//			console.log(data.object[i].address);
	//			console.log(data.object[i].menuItemAmountMap);
	//			console.log(data.object[i].menuItemPriceMap);
	//			console.log(data.object[i].totalPrices);


	var createOrdersDiv = function(status, data) {
		if (status == "rece") {
			var receTBody = $("#receOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
			for (var i = 0; i < data.object.length; i++) {
				var trs = $("<tr></tr>");
				var order_id_td = $("<td><a>" + data.object[i].id + "</a><input type='hidden' value='"+data+"'/></td>");
				var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
				var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
				var order_status_td = $("<td>" + data.object[i].status + "</td>");
				var order_operation_td = $("<td><button type='button' class='detailBtn btn-primary'>詳情..</button></td>");

				order_id_td.appendTo(trs);
				order_recetime_td.appendTo(trs);
				order_people_td.appendTo(trs);
				order_status_td.appendTo(trs);
				order_operation_td.appendTo(trs);

				trs.appendTo(receTBody);
			}
		} else if (status == "finish") {
			var failTBody = $("#failOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
			for (var i = 0; i < data.object.length; i++) {
				var trs = $("<tr></tr>");
				var order_id_td = $("<td><a>" + data.object[i].id + "</a><input type='hidden' value='"+data+"'/></td>");
				var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
				var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
				var order_status_td = $("<td>" + data.object[i].status + "</td>");
				var order_operation_td = $("<td><button type='button' class='detailBtn btn-primary'>詳情..</button></td>");

				order_id_td.appendTo(trs);
				order_recetime_td.appendTo(trs);
				order_people_td.appendTo(trs);
				order_status_td.appendTo(trs);
				order_operation_td.appendTo(trs);

				trs.appendTo(failTBody);
			}
		} else if (status == "fail") {
			var succTBody = $("#succOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
			for (var i = 0; i < data.object.length; i++) {
				var trs = $("<tr></tr>");
				var order_id_td = $("<td><a>" + data.object[i].id + "</a><input type='hidden' value='"+data+"'/></td>");
				var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
				var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
				var order_status_td = $("<td>" + data.object[i].status + "</td>");
				var order_operation_td = $("<td><button type='button' class='detailBtn btn-primary'>詳情..</button></td>");

				order_id_td.appendTo(trs);
				order_recetime_td.appendTo(trs);
				order_people_td.appendTo(trs);
				order_status_td.appendTo(trs);
				order_operation_td.appendTo(trs);
				$("<td type=>"+data+"</td>").appendTo(trs);
				trs.appendTo(succTBody);
			}
		}
		
		$(".detailBtn").on("click",function(){
			var data = $(this).parent().parent().find("td").eq(0).find("input").val();
			alert(data);
			$("#detailModal").modal("show");
			
//			$("#OrderMID").val(data.object.);
		});
	};

//	loadReceiveOrders();
//	loadFinishOrders();
//	loadFailOrders();

	var loadOrders = function() {
		console.log("so");
		
		loadReceiveOrders();
		loadFinishOrders();
		loadFailOrders();
	};
<<<<<<< HEAD
	
=======

>>>>>>> 03367ce4f7637ab2c2d648e79b36fcda48b9bc52
//});