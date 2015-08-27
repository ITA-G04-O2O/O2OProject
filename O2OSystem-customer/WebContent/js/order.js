

var Order=(function(){
	
	var getOrderInfo=function(id){
		$.ajax({
			url : 'http://localhost:8888/O2OSystem-customer/orders/'+id,
			type : 'GET',
			dataType : 'json',
		}).done(function(data, status, xhr) {
//			alert(data.object.mycomment);
			loadData(data.object);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};
	
	var loadData=function(object){
		var totalPrice=0;
		for(var i=0;i<object.items.length;i++){
			$(".table-hover tbody").append("<tr data-desc='menuItem'></tr>");
			var TR=$("tr[data-desc=menuItem]:last");
			TR.append("<td>"+object.items[i].itemName+"</td>");
			TR.append("<td>"+object.items[i].number+"</td>");
			TR.append("<td data-desc='price'>"+object.items[i].price+"</td>");
			totalPrice=totalPrice+parseFloat($("td[data-desc=price]:last").text());
//			alert(pay);
		}
		$("#totalPrice").text(totalPrice);
		
		/*设置饭点名字等*/
		$(".content-center:first h4").text(object.restName);
		$("#orderNumber").text(object.orderNumber);
		$("#merchantTel").text(object.merchantTel);
		$("#orderShowTime").text(object.orderShowTime);
		$('#orderStatus').text(object.orderStatus);
		$('#receiverTel').text(object.receiverTel);
		$('#receiver').text(object.receiver);
		$('#address').text(object.address);
		$('#score').text(object.myscore);
		$('#comment').text(object.mycomment);
	};
	
	return {
		getOrderInfo:getOrderInfo
	};
	
})();

var UserInfo=(function(){
	var getInfo=function(id){
		$.ajax({
			url : 'http://localhost:8888/O2OSystem-customer/users/'+id,
			type : 'GET',
			dataType : 'json',
		}).done(function(data, status, xhr) {
//			alert(data.object.mycomment);
			loadData(data.object);
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};
	var loadData=function(object){
		$("#inf-nickName").text(object.uname);
		$("#inf-tel").text(object.tel);
		$("#inf-blance").text(object.blance);
	};
	return {
		getInfo:getInfo
	};
})();

$(function(){
	$("#submitBtn").on("click",function(){
		location.href="order.html";
	});
	var url = window.location.search;
    var id = url.substring(url.lastIndexOf('=')+1, url.length);
//    alert(id);
	Order.getOrderInfo(id);
	
	
	$("li[role=presentation]").eq(1).click(function(){
		UserInfo.getInfo(id);
	});
});

