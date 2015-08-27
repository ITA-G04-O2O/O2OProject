
var uid =0;
var Order=(function(){
	
	var getAllOrdersID=function(userId){
		$.ajax({
			url : 'http://localhost:8888/O2OSystem-customer/users/'+userId+'/userOrder',
			type : 'GET',
			dataType : 'json',
		}).done(function(data, status, xhr) {
			var temp = data.object;
			for(var i=0;i<temp.length;i++){
				getOrderInfo(data.object[i]);			
			}
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	};
	
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
		var template = $("#order").clone();
		var totalPrice=0;
		for(var i=0;i<object.items.length;i++){
			template.find(".table-hover tbody").append("<tr data-desc='menuItem'></tr>");
			var TR=template.find("tr[data-desc=menuItem]:last");
			TR.append("<td>"+object.items[i].itemName+"</td>");
			TR.append("<td>"+object.items[i].number+"</td>");
			TR.append("<td data-desc='price'>"+object.items[i].price+"</td>");
			totalPrice=totalPrice+parseFloat(template.find("td[data-desc=price]:last").text());
//			alert(pay);
		}
		template.find("#totalPrice").text(totalPrice);
		
		/*设置饭点名字等*/
		template.find(".content-center:first h4").text(object.restName);
		template.find("#orderNumber").text(object.orderNumber);
		template.find("#merchantTel").text(object.merchantTel);
		template.find("#orderShowTime").text(object.orderShowTime);
		template.find('#orderStatus').text(object.orderStatus);
		template.find('#receiverTel').text(object.receiverTel);
		template.find('#receiver').text(object.receiver);
		template.find('#address').text(object.address);
		template.find('#score').text(object.myscore);
		template.find('#comment').text(object.mycomment);
		$("#allorders").append(template);
//		alert(object.uid);
		uid=object.uid;
	};
	
	return {
		getOrderInfo:getOrderInfo,
		getAllOrdersID:getAllOrdersID
	};
	
})();

var User=(function(){
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
	
	var changeUserName=function(){
		
		var newUsername = $("#newUsername").val();
		var regex= new RegExp("^[0-9A-Za-z_]{6,15}$");
		alert(regex.test(newUsername));
		if(regex.test(newUsername)){
			$.ajax({
				url : 'http://localhost:8888/O2OSystem-customer/users/'+uid,
				type : 'post',
				dataType : 'json',
				data:{
					_method:'PUT',
					newName:newUsername
				}
			}).done(function(data, status, xhr) {
//				alert(data.object.mycomment);
				loadData(data.object);
			}).fail(function(xhr, status, error) {
				console.log('fail');
			});
		}else{
			alert("用户名只包含大小写英文、数字和下划线,长度在6-15之间");
		}
	};
	
	return {
		getInfo:getInfo,
		changeUserName:changeUserName
	};
})();

$(function(){
	$("#submitBtn").on("click",function(){
		location.href="order.html";
	});
	/*var url = window.location.search;
    var oid = url.substring(url.lastIndexOf('=')+1, url.length);
//    alert(id);
	Order.getOrderInfo(oid);*/
	Order.getAllOrdersID(10);
	
	$("#myorder-btn").click(function(){
		Order.getAllOrdersID(10);
	});
	$("#modify-username-btn").click(function(){
		User.changeUserName();
	});
});

