$(document).ready(function() {
	$('#section2').hide();
	$('#section3').hide();
	var count = 1;
	$.ajax({
		url : 'http://localhost:8888/o2osystem-merchant/area',
		type : 'GET',
		dataType : 'json',
		success : function(data) {
			console.log(data);
			for ( var i in data) {
				alert(data[i]);
				var province = data[i];
				alert(province);
				$('#province').append("<li>" + 广州 + "</li>");
				var li = $("<li></li>");
				li.appendTo($("#tbody"));
				var td = $(province);
				td.appendTo(li);
			}
		}
	});
	$('.nextStep').click(function(index) {

		$('#section' + count).hide();
		count++;
		$('#section' + (count)).show();
	});
});
$('.list-group li').on('click', function() {
	var loadhtml = $(this).attr('id');
	if (loadhtml) {
		$('#change').load(loadhtml + '.html');
	}
});

$("#proBtn").click(function() {
	$.ajax({
		url : 'http://localhost:8888/o2osystem-merchant/restaurant',
		type : 'POST',
		dataType : 'json',
		data : {
			mName : $('input[name=mName]').val()
		}
	}).done(function(data, status, xhr) {

	}).fail(function(xhr, status, error) {
		console.log('fail');
	});
});
