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
        url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+ type,
        type: 'get',
        dataType: 'json'
    }).done(function (data, status, xhr) {
        $('div[name=restaurant]').empty();
        for (var i = 0; i < data.object.length; i++) {
            $('div[name=restaurant]')
			.append(
					'<div class="restaurant col-xs-4"><div class="mealBox border"><a href="html/restaurant.html" class="thumbnail"><img src="img/oocl_logo.gif"></a><h4>'+data.object[i].name+'</h4><h5 class="text-muted">评分：4分 销量：888单</h5><h5 class="text-muted">起送：￥30 免费送餐</h5><h5 class="text-muted">配送时间：30分钟</h5></div></div>');
        }
    }).fail(function (xhr, status, error) {
        console.log('fail');
    });
};

$(function () {
    $(".restaurant").on("click", function () {
        location.href = "restaurant.html";
    });

    getRestType();

    $('.typeBtn').on("click",function(){
    	var id=$(this).attr('id');
    	alert(id);
    });
});