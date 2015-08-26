$(document).ready(function() {
	$('#section2').hide();
	$('#section3').hide();
	var count = 1;
	$.ajax({
		url : 'http://localhost:8888/o2osystem-merchant/address',
		type : 'GET',
	}).done(function(data, status, xhr) {
		var addrList = data.addrList;
		alert(addrList.length);
	}).fail(function(xhr, status, error) {
		console.log('fail');
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
	alert($('input[name=mName]').val());
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
