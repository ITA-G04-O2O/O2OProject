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
            
            $('div[name=menutype]').empty();
            $('div[name=menuItems]').empty();
            for(var i=0;i<data.object.menuTypes.length;i++){
                $('div[name=menutype]')
                .append(
                        '<div class="btn-group" role="group"><button type="button" data-toggle="collapse" data-parent="#accordion" href="#menutype'+i+'" aria-expanded="false" aria-controls="menutype'+i+'" class="btn btn-default">'+data.object.menuTypes[i].menuTypeName+'<span class="sortable glyphicon glyphicon-triangle-bottom" aria-hidden="true"><br/></span></button>');
                
                $('div[name=menuItems]')
                    .append(
                            '<div class="panel panel-default"><div class="panel-heading" role="tab" id="heading'+i+'"><h4 class="panel-title"><a class="collapsed" role="button" data-toggle="collapse"data-parent="#accordion" href="menutype#'+i+'"aria-expanded="false" aria-controls="menutype'+i+'">'+data.object.menuTypes[i].menuTypeName+'</a></h4></div><div id="menutype'+i+'" class="panel-collapse collapse" role="tabpanel"aria-labelledby="heading'+i+'"><div class="panel-body"><div class="row"></div></div></div></div>');
            
            }
            
            for(var j=0;j<data.object.menus.length;j++){
                $('div[name=menuMealBox]')
                    .append(
                            '<div class="col-xs-4"><div class="menuMealBox" name="menuMealBox"><a href="#" class="thumbnail"><img src="img/1.jpg"></a><h4><span>'+data.object.menus[j].itemName+'</span></h4><h5 class="text-muted"><span>'+data.object.menus[j].description+'</span></h5><div class="row"><div class="col-xs-7"><h4><span>￥'+data.object.menus[j].price+'</span></h4></div><div class="col-xs-5 text-right"><button class="btn btn-primary addbtn">添加</button> </div></div></div></div>');
            }
            
            
            
            
            
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
	};
	
	return {
		getRestInfo : getRestInfo
	};
	
})();


$(document).ready(function() {

    var url = window.location.search;
    var id = url.substring(url.lastIndexOf('=')+1, url.length);
	restInfoController.getRestInfo(id);
    
});