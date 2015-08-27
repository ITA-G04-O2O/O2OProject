var restInfoController = (function() {
	var getRestInfo = function (id) {
		$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+id,
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
			//set title info
            $('#restName').text(data.object.name);
            $('#restPrice').text(data.object.playPrice);
            $('#score').text(data.object.grade);
            $('#time').text(data.object.actualArrivalTime);
            $('#restNotice').text(data.object.notice);
            
            $('div[name=menutype]').empty();
            $('div[name=menuItems]').empty();
            for(var i=0;i<data.object.menuTypes.length;i++){
                $('div[name=menutype]')
                .append(
                        '<div class="btn-group" role="group"><button type="button" data-toggle="collapse" data-parent="#accordion" href="#menutype'+i+'" aria-expanded="false" aria-controls="menutype'+i+'" class="btn btn-default">'+data.object.menuTypes[i].menuTypeName+'<span class="sortable glyphicon glyphicon-triangle-bottom" aria-hidden="true"><br/></span></button>');
                
                $('div[name=menuItems]')
                    .append(
                            '<div class="panel panel-default"><div class="panel-heading" role="tab" id="heading'+i+'"><h4 class="panel-title"><a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#menutype'+i+'"aria-expanded="false" aria-controls="menutype'+i+'">'+data.object.menuTypes[i].menuTypeName+'</a></h4></div><div id="menutype'+i+'" class="panel-collapse collapse" role="tabpanel"aria-labelledby="heading'+i+'"><div class="panel-body"><div class="row" name="menuMealBox"></div></div></div></div>');
            
                for(var j=0;j<data.object.menuTypes[i].menuItems.length;j++){
                    $('div[name=menuMealBox]')
                        .append(
                                '<div class="col-xs-4"><div class="mealBox"><a href="#" class="thumbnail"><img src=/menuItem/"'+data.object.menuTypes[i].menuItems[j].id+'"></a><h4 id="itemName">'+data.object.menuTypes[i].menuItems[j].itemName+'</h4><h5 class="text-muted">'+data.object.menuTypes[i].menuItems[j].description+'</h5><div class="row"><div class="col-xs-7"><h4>$<span id="itemPrice">'+data.object.menuTypes[i].menuItems[j].price+'</span></h4></div><div class="col-xs-5 text-right"><button class="btn btn-primary addbtn" id="addOrderBtn" item-name="'+data.object.menuTypes[i].menuItems[j].itemName+'" item-price="'+data.object.menuTypes[i].menuItems[j].price+'" onclick="addOrder(this)">添加</button></div></div></div></div>');
                }
            }
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
	};
    
    var getHGradeInfo = function (id) {
    	$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+id+'/highOrders',
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
            $('#high-praise').empty();
            for(var i=0;i<data.object.length;i++){
                $('#high-praise').append(
                                        '<div class="praise-content"><div>评分:<span>'+data.object[i].score+'</span></div><div>点评时间:<span>'+data.object[i].orderShowTime+'</span></div><div>评价内容:<span>'+data.object[i].mycomment+'</span></div></div><hr/>');
            }
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
    };
    
    var getMGradeInfo = function (id) {
    	$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+id+'/midOrders',
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
            $('#middle-praise').empty();
            for(var i=0;i<data.object.length;i++){
                $('#middle-praise').append(
                                        '<div class="praise-content"><div>评分:<span>'+data.object[i].score+'</span></div><div>点评时间:<span>'+data.object[i].orderShowTime+'</span></div><div>评价内容:<span>'+data.object[i].mycomment+'</span></div></div><hr/>');
            }
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
    };
    
    var getLGradeInfo = function (id) {
    	$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+id+'/lowOrders',
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
            $('#bad-praise').empty();
            for(var i=0;i<data.object.length;i++){
                $('#bad-praise').append(
                                        '<div class="praise-content"><div>评分:<span>'+data.object[i].score+'</span></div><div>点评时间:<span>'+data.object[i].orderShowTime+'</span></div><div>评价内容:<span>'+data.object[i].mycomment+'</span></div></div><hr/>');
            }
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
    };
	
	return {
		getRestInfo : getRestInfo,
		getHGradeInfo : getHGradeInfo,
        getMGradeInfo : getMGradeInfo,
        getLGradeInfo : getLGradeInfo
	};
	
})();


//order数据
var sum=0;
function addOrder(item){
    var itemName=$(item).attr('item-name');
    var itemPrice=$(item).attr('item-price');
    $('#orderList').append(
                        '<tr><td data-name="'+itemName+'">'+itemName+'</td><td><input type="number" value="1" class="form-control input-sm"></td><td data-price="'+itemPrice+'">'+itemPrice+'</td></tr>');
    sum=sum+parseFloat(itemPrice);
    
    $('#sumPrice').text(sum);
}

$(document).ready(function() {

    var url = window.location.search;
    var id = url.substring(url.lastIndexOf('=')+1, url.length);
	restInfoController.getRestInfo(id);
	restInfoController.getHGradeInfo(id);
    restInfoController.getMGradeInfo(id);
    restInfoController.getLGradeInfo(id);
    
    
    $('#delivery').on("click",function(){
        $('#orderList').empty();
        $('#sumPrice').text('');
        sum=0;
    });
    
    $('#submitMenuBtn').on("click",function(){
        
    });
    
});