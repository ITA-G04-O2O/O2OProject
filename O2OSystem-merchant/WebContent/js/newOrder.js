//$(function() {


	var loadNewOrderFunction = function() {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/new",
			type: 'GET',
			dataType: 'json'
		}).done(function(data, status, xhr) {
			createPanel(data);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});

	};
	loadNewOrderFunction();

	var createPanel = function(data) {

		for (var i = 0; i < data.object.length; i++) {
			//			console.log(data.object[i].id);
			//			console.log(data.object[i].createDate);
			//			console.log(data.object[i].status);
			//			console.log(data.object[i].connectPeople);
			//			console.log(data.object[i].tel);
			//			console.log(data.object[i].address);
			//			console.log(data.object[i].menuItemAmountMap);
			//			console.log(data.object[i].menuItemPriceMap);
			//			console.log(data.object[i].totalPrices);

			var status = "";
			if (data.object[i].status == 1) {
				status = "等待確認接單";
			}
			var container = $("#orderContainer");
			var panel = $("<div class='panel panel-primary'></div>");
			var panel_head = $("<div class='panel-heading'>新的订单</div>");
			var panel_body = $("<div class='panel-body'></div>");

			//menuDiv
			var menu_container = $("<div class='container col-xs-12'></div>");
			var menu_div = $("<div id='menusDiv' class='col-xs-5'></div>");
			var menu_panel = $("<div class='panel panel-info'></div>");
			var menu_panel_head = $("<div class='panel-heading'><span>订单</span></div>");
			var menu_panel_body = $("<div class='panel-body' id='ordertable'></div>");
			var menu_panel_body_table = $("<table class='table table-bordered table-hover info'></table>");
			var menu_panel_body_table_head = $("<thead><tr class='active'><td>餐点</td><td>份数</td><td>价格</td></tr></thead>");
			var menu_panel_body_table_body = $("<tbody></tbody>");
			$.each(data.object[i].menuItemAmountMap, function(key, values) {
				var menu_panel_body_table_body_tr = $("<tr></tr>");
				var menu_panel_body_table_body_tr_foodNameTd = $("<td>" + key + "</td>");
				var menu_panel_body_table_body_tr_foodAmountTd = $("<td>" + values + "</td>");
				var menu_panel_body_table_body_tr_foodPriceTd = $("<td>" + data.object[i].menuItemPriceMap[key] + "</td>");
				menu_panel_body_table_body_tr_foodNameTd.appendTo(menu_panel_body_table_body_tr);
				menu_panel_body_table_body_tr_foodAmountTd.appendTo(menu_panel_body_table_body_tr);
				menu_panel_body_table_body_tr_foodPriceTd.appendTo(menu_panel_body_table_body_tr);
				menu_panel_body_table_body_tr.appendTo(menu_panel_body_table_body);
			});
			var menu_panel_body_table_foot = $("<tfoot></tfoot>");
			var menu_panel_body_table_foot_tr = $("<tr></tr>");
			var menu_panel_body_table_foot_tr_td = $("<td colspan='3'></td>");
			var menu_panel_body_table_foot_tr_td_div = $("<div class='col-sm-offset-2 col-sm-6 row'></div>");

			var totalSpanTitle = $("<span class='label label-default sum'>总价：￥</span>");
			var totalSpan = $("<span id='totalPrice' class='label label-default sum'>" + data.object[i].totalPrices + "</span>");
			var freightSpanTitle = $("<span class='label label-info'>配送费：￥</span>");
			var freightSpan = $("<span id=' freight' class='label label-info'>" + 50.0 + "</span>");

			totalSpanTitle.appendTo(menu_panel_body_table_foot_tr_td_div);
			totalSpan.appendTo(menu_panel_body_table_foot_tr_td_div);
			freightSpanTitle.appendTo(menu_panel_body_table_foot_tr_td_div);
			freightSpan.appendTo(menu_panel_body_table_foot_tr_td_div);


			menu_div.appendTo(menu_container);
			menu_panel.appendTo(menu_div);
			menu_panel_head.appendTo(menu_panel);
			menu_panel_body.appendTo(menu_panel);
			menu_panel_body_table.appendTo(menu_panel_body);
			menu_panel_body_table_head.appendTo(menu_panel_body_table);
			menu_panel_body_table_body.appendTo(menu_panel_body_table);
			menu_panel_body_table_foot.appendTo(menu_panel_body_table);
			menu_panel_body_table_foot_tr.appendTo(menu_panel_body_table_foot);
			menu_panel_body_table_foot_tr_td.appendTo(menu_panel_body_table_foot_tr);
			menu_panel_body_table_foot_tr_td_div.appendTo(menu_panel_body_table_foot_tr_td);

			//confirmList
			var confirmList = $("<div class='confirmList col-xs-7'></div>");
			var confirm_panel = $("<div class='panel panel-default'></div>");
			var confirm_panel_body = $("<div class='panel-body'></div>");
			var confirm_panel_body_orderNum = $("<div class='form-group row'><label class='col-sm-3 control-label'>訂單號：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputOrderNum' value='" + data.object[i].id + "' disabled='disabled'></div></div>");
			var confirm_panel_body_receTime = $("<div class='form-group row'><label class='col-sm-3 control-label'>下單日期：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputCreTime' value='" + data.object[i].createDate + "' disabled='disabled'></div></div>");
			var confirm_panel_body_orderStatus = $("<div class='form-group row'><label class='col-sm-3 control-label'>訂單狀態：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputStatus' value='" + status + "' disabled='disabled'></div></div>");
			var confirm_panel_body_contact = $("<div class='form-group row'><label class='col-sm-3 control-label'>联系人：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputContact' value='" + data.object[i].connectPeople + "' disabled='disabled'></div></div>");
			var confirm_panel_body_tel = $("<div class='form-group row'><label class='col-sm-3 control-label'>電話：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputTel' value='" + data.object[i].tel + "' disabled='disabled'></div></div>");
			var confirm_panel_body_addr = $("<div class='form-group row'><label class='col-sm-3 control-label'>地址：</label><div class='col-sm-9'><input type='text' class='form-control' id='inputAddr' value='" + data.object[i].address + "' disabled='disabled'></div></div>");
			var confirm_panel_body_operation = $("<div class='form-group row'><div class='col-sm-offset-6 col-sm-6 row'><button type='button' class='submitOrderBtn btn-success'>確認接單</button><button type='button' class='rejectOrderBtn btn-danger'>拒絕接單</button></div></div>");

			confirmList.appendTo(menu_container);
			confirm_panel.appendTo(confirmList);
			confirm_panel_body.appendTo(confirm_panel);
			confirm_panel_body_orderNum.appendTo(confirm_panel_body);
			confirm_panel_body_receTime.appendTo(confirm_panel_body);
			confirm_panel_body_orderStatus.appendTo(confirm_panel_body);
			confirm_panel_body_contact.appendTo(confirm_panel_body);
			confirm_panel_body_tel.appendTo(confirm_panel_body);
			confirm_panel_body_addr.appendTo(confirm_panel_body);
			confirm_panel_body_operation.appendTo(confirm_panel_body);

			panel.appendTo(container);
			panel_head.appendTo(panel);
			panel_body.appendTo(panel);
			menu_container.appendTo(panel_body);
		}


		$(".submitOrderBtn").on("click", function() {
			var id = $(this).parent().parent().parent().find("div").eq(0).find("div").eq(0).find("input").eq(0).val();
			console.log("id=" + id);
			submitOrderAction(id);
		});

		$(".rejectOrderBtn").on("click", function() {
			var id = $(this).parent().parent().parent().find("div").eq(0).find("div").eq(0).find("input").eq(0).val();
			console.log("id=" + id);
			rejectOrderAction(id);
		});
	};

	////1: user add order. 2:merchant received order. 3:merchant refused order.  4: order finished.

	var submitOrderAction = function(id) {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/" + id + "/2",
			type: 'POST',
			dataType: 'json',
			data: {
				_method: "PUT"
			}
		}).done(function(data, status, xhr) {
			$("#orderContainer").empty();
			//			createPanel(data);
			loadNewOrderFunction();
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});

		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/"+id+"/rece",
			type: 'POST',
			dataType: 'json',
			data: {
				_method: "PUT"
			}
		}).done(function(data, status, xhr) {
			console.log('suc');
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};

	var rejectOrderAction = function(id) {
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/" + id + "/3",
			type: 'POST',
			dataType: 'json',
			data: {
				_method: "PUT"
			}
		}).done(function(data, status, xhr) {
			$("#orderContainer").empty();
			//			createPanel(data);
			loadNewOrderFunction();
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
		
		$.ajax({
			url: "http://localhost:17236/o2osystem-merchant/orders/"+id+"/comp",
			type: 'POST',
			dataType: 'json',
			data: {
				_method: "PUT"
			}
		}).done(function(data, status, xhr) {
			console.log('suc');
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};


//});