var restController = (function() {
	var getRestType = function () {
		$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurantType',
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
			$('div[name=restType]').empty();
				$('div[name=restType]')
				.append(
						'<div class="btn-group" role="group"><button type="button" class="btn btn-default typeBtn" id="'+data.object[i].id+'">'+data.object[i].type+'</button></div>');
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
	};
	
	var getRestByType = function (type) {
		$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/restaurantType/'+ type,
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
			$('div[name=restaurant]').empty();
				$('div[name=restaurant]')
				.append(
						'<div class="mealBox border"><a href="restaurant.html?id="'+data.object[i].id+' class="thumbnail"><img src="img/oocl_logo.gif"></a><h4><span name="restName">'+data.object[i].name+'</span></h4><h5 class="text-muted"><span>评分：</span><span name="score">'+data.object[i].grade+'</span><span>分 销量：</span><span name="sales">'+data.object[i].sum+'</span><span>单</span></h5><h5 class="text-muted"><span>起送：￥</span><span name="price">'+data.object[i].playPrice+'</span><span>免费送餐</span></h5><h5 class="text-muted"><span>配送时间：</span><span name="time">'+data.object[i].actualArrivalTime+'</span><span>分钟</span></h5></div>');
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
	};
	
	return {
		getRestType : getRestType,
		getRestByType : getRestByType
	};
	
})();


$(document).ready(function() {

	restController.getRestType();
    $('.typeBtn').on("click",function(){
    	var type = $(this).attr("id");
    	console.log(type);
    	restController.getRestByType(type);
    });
    
    
});