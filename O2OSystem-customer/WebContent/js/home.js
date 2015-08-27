var getRestType = function () {
    $.ajax({
        url: 'http://localhost:8888/O2OSystem-customer/restaurantType',
        type: 'get',
        dataType: 'json'
    }).done(function (data, status, xhr) {
        $('div[name=restType]').empty();
        for (var i = 0; i < data.object.length; i++) {
            $('div[name=restType]')
			.append(
					'<div class="btn-group" role="group"><button type="button" class="btn btn-default typeBtn" id="'+data.object[i]+'">'+data.object[i]+'</button></div>');
        }
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
        for (var i = 0; i < data.object.length; i++) {
            $('div[name=restaurant]')
			.append(
					'<div class="mealBox border"><a href="restaurant.html?id="'+data.object[i].id+' class="thumbnail"><img src="img/oocl_logo.gif"></a><h4><span name="restName">XX汉堡店</span></h4><h5 class="text-muted"><span>评分：</span><span name="score">4</span><span>分 销量：</span><span name="sales">888</span><span>单</span></h5><h5 class="text-muted"><span>起送：￥</span><span name="price">30</span><span>免费送餐</span></h5><h5 class="text-muted"><span>配送时间：</span><span name="time">30</span><span>分钟</span></h5></div>');
        }
    }).fail(function (xhr, status, error) {
        console.log('fail');
    });
};

$(function () {

    getRestType();

    $('.typeBtn').on("click",function(){

    	alert(restType);
    	
    });
    
    
});