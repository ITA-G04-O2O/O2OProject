$(function () {
	OrderHelp.getOrderInfo();
	$("#submitOrderBtn").on("click", function () {
		location.href = 'good.html';
	});
});

var OrderHelp =(function(){
	

	var getOrderInfo = function() {
		$.ajax({
			url : 'http://localhost:8888/O2OSystem-customer/order/get',
			type : 'GET',
			dataType : 'json',
		}).done(function(data, status, xhr) {
			var info=eval(data.object);
//			console.log(info);
			loadData(info);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};
	
	var loadData=function(info){
		var totalPrice=0;
		for(var i=0;i<info.length;i++){
			var id=info[i].id;
			var price=info[i].price;
			var name=info[i].name;
			var number=info[i].number;
//			console.log(id+price+name+number);
			$("#show-order-detail").append("<tr data-desc=orderInfo></tr>");
			var TR=$("#show-order-detail").find("tr[data-desc=orderInfo]:last");
			TR.append("<td style='display:none'>"+id+"</td>");
			TR.append("<td>"+name+"</td>");
			TR.append("<td>"+number+"</td>");
			TR.append("<td  data-desc='price'>"+price+"</td>");
			totalPrice=totalPrice+parseFloat(TR.find("td[data-desc=price]:last").text());
		}
		$("#totalPrice").text(totalPrice);
		$(".sum:last").text(totalPrice);
	};
	return {
		getOrderInfo:getOrderInfo
	};
})();