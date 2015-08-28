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

var createOrdersDiv = function(status, data) {
	if (status == "rece") {
		var receTBody = $("#receOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
		console.log("::::::" + data.object.length);
		for (var i = 0; i < data.object.length; i++) {
			var trs = $("<tr></tr>");
			var order_id_td = $("<td><a>" + data.object[i].id + "</a>");
			var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
			var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
			var order_status_td = $("<td>" + data.object[i].status + "</td>");
			var order_operation_td = $("<td><button type='button' id='" + i + "receDetailBtn' class='detailBtn btn-primary'>詳情..</button></td>");

			order_id_td.appendTo(trs);
			order_recetime_td.appendTo(trs);
			order_people_td.appendTo(trs);
			order_status_td.appendTo(trs);
			order_operation_td.appendTo(trs);
			trs.appendTo(receTBody);


			$("#" + i + "receDetailBtn").on("click", function() {
				var id = $(this).parent().parent().find("td").eq(0).find("a").eq(0).text();
				$.ajax({
					url: "http://localhost:17236/o2osystem-merchant/orders/" + id,
					type: 'GET',
					dataType: 'json'
				}).done(function(data, status, xhr) {
					var createDate = data.object.createDate;
					var completedDate = data.object.completedDate;
					var status = data.object.status;
					var connectPeople = data.object.connectPeople;
					var tel = data.object.tel;
					var address = data.object.address;
					var menuList = "";
					$.each(data.object.menuItemAmountMap, function(key, values) {
						var row = key + "*" + values;
						menuList = menuList + row + " ";
					});
					$("#OrderMID").val(id);
					$("#OrderMCreateDate").val(createDate);
					$("#OrderMChangeDate").val(completedDate);
					$("#OrderMStatus").val(status);
					$("#OrderMContact").val(connectPeople);
					$("#OrderMTel").val(tel);
					$("#OrderMAddr").val(address);
					$("#OrderMMenuList").val(menuList);
					$("#detailModal").modal("show");
				}).fail(function(xhr, status, error) {
					console.log('fail');
				});
			});
		}

	} else if (status == "finish") {
		var failTBody = $("#succOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
		for (var i = 0; i < data.object.length; i++) {
			var trs = $("<tr></tr>");
			var order_id_td = $("<td><a>" + data.object[i].id + "</a><input type='hidden' value='" + data + "'/></td>");
			var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
			var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
			var order_status_td = $("<td>" + data.object[i].status + "</td>");
			var order_operation_td = $("<td><button type='button' id='" + i + "failDetailBtn' class='detailBtn btn-primary'>詳情..</button></td>");

			order_id_td.appendTo(trs);
			order_recetime_td.appendTo(trs);
			order_people_td.appendTo(trs);
			order_status_td.appendTo(trs);
			order_operation_td.appendTo(trs);

			trs.appendTo(failTBody);

			$("#" + i + "failDetailBtn").on("click", function() {
				var id = $(this).parent().parent().find("td").eq(0).find("a").eq(0).text();
				$.ajax({
					url: "http://localhost:17236/o2osystem-merchant/orders/" + id,
					type: 'GET',
					dataType: 'json'
				}).done(function(data, status, xhr) {
					var createDate = data.object.createDate;
					var completedDate = data.object.completedDate;
					var status = data.object.status;
					var connectPeople = data.object.connectPeople;
					var tel = data.object.tel;
					var address = data.object.address;
					var menuList = "";
					$.each(data.object.menuItemAmountMap, function(key, values) {
						var row = key + "*" + values;
						menuList = menuList + row + " ";
					});
					$("#OrderMID").val(id);
					$("#OrderMCreateDate").val(createDate);
					$("#OrderMChangeDate").val(completedDate);
					$("#OrderMStatus").val(status);
					$("#OrderMContact").val(connectPeople);
					$("#OrderMTel").val(tel);
					$("#OrderMAddr").val(address);
					$("#OrderMMenuList").val(menuList);
					$("#detailModal").modal("show");
				}).fail(function(xhr, status, error) {
					console.log('fail');
				});
			});
		}
	} else if (status == "fail") {
		var succTBody = $("#failOrdersDiv").find("div").eq(1).find("table").eq(0).find("tbody").eq(0);
		for (var i = 0; i < data.object.length; i++) {
			var trs = $("<tr></tr>");
			var order_id_td = $("<td><a>" + data.object[i].id + "</a><input type='hidden' value='" + data + "'/></td>");
			var order_recetime_td = $("<td>" + data.object[i].receDate + "</td>");
			var order_people_td = $("<td>" + data.object[i].connectPeople + "</td>");
			var order_status_td = $("<td>" + data.object[i].status + "</td>");
			var order_operation_td = $("<td><button type='button' id='" + i + "succDetailBtn' class='detailBtn btn-primary'>詳情..</button></td>");

			order_id_td.appendTo(trs);
			order_recetime_td.appendTo(trs);
			order_people_td.appendTo(trs);
			order_status_td.appendTo(trs);
			order_operation_td.appendTo(trs);
			$("<td type=>" + data + "</td>").appendTo(trs);
			trs.appendTo(succTBody);

			$("#" + i + "succDetailBtn").on("click", function() {
				var id = $(this).parent().parent().find("td").eq(0).find("a").eq(0).text();
				$.ajax({
					url: "http://localhost:17236/o2osystem-merchant/orders/" + id,
					type: 'GET',
					dataType: 'json'
				}).done(function(data, status, xhr) {
					var createDate = data.object.createDate;
					var completedDate = data.object.completedDate;
					var status = data.object.status;
					var connectPeople = data.object.connectPeople;
					var tel = data.object.tel;
					var address = data.object.address;
					var menuList = "";
					$.each(data.object.menuItemAmountMap, function(key, values) {
						var row = key + "*" + values;
						menuList = menuList + row + " ";
					});
					$("#OrderMID").val(id);
					$("#OrderMCreateDate").val(createDate);
					$("#OrderMChangeDate").val(completedDate);
					$("#OrderMStatus").val(status);
					$("#OrderMContact").val(connectPeople);
					$("#OrderMTel").val(tel);
					$("#OrderMAddr").val(address);
					$("#OrderMMenuList").val(menuList);
					$("#detailModal").modal("show");
				}).fail(function(xhr, status, error) {
					console.log('fail');
				});
			});
		}
	}
};

var loadOrders = function() {

	loadReceiveOrders();
	loadFinishOrders();
	loadFailOrders();
};
//});