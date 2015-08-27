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
                            '<div class="panel panel-default"><div class="panel-heading" role="tab" id="heading'+i+'"><h4 class="panel-title"><a class="collapsed" role="button" data-toggle="collapse"data-parent="#accordion" href="menutype#'+i+'"aria-expanded="false" aria-controls="menutype'+i+'">'+data.object.menuTypes[i].menuTypeName+'</a></h4></div><div id="menutype'+i+'" class="panel-collapse collapse" role="tabpanel"aria-labelledby="heading'+i+'"><div class="panel-body"><div class="row" name="menuMealBox"></div></div></div></div>');
            
            }
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
	};
    
    var getGradeInfo = function (id) {
    	$.ajax({
			url: 'http://localhost:8888/O2OSystem-customer/restaurant/'+id,
			type: 'get',
			dataType: 'json'
		}).done(function (data, status, xhr) {
			
    
		}).fail(function (xhr, status, error) {
			console.log('fail');
		});
    };
	
	return {
		getRestInfo : getRestInfo,
		getGradeInfo : getGradeInfo
	};
	
})();


$(document).ready(function() {

    var url = window.location.search;
    var id = url.substring(url.lastIndexOf('=')+1, url.length);
	restInfoController.getRestInfo(id);
    
});