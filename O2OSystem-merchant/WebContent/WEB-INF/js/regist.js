$(document).ready(function() {
	$('#change').load('newOrder.html');
});
$('.list-group li').on('click', function() {
	var loadhtml = $(this).attr('id');
	if (loadhtml) {
		$('#change').load(loadhtml + '.html');
	}
});
$(document).ready(function() {
	$('#section2').hide();
	$('#section3').hide();
	var count = 1;
	$('.nextStep').click(function(index) {
		$('#section' + count).hide();
		count++;
		$('#section' + (count)).show();
	});
	$('.preStep').click(function(index) {
		$('#section' + count).hide();
		count--;
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
	alert("Hello");
	$.ajax({
		url : 'http://localhost:8888/O2OSystem-merchant/restaurant',
		type : 'POST',
		dataType : 'json',
		data : {
			mName : $('input[name=mName]').val(),
			type : $('input:radio:checked').val(),
			name : $('input[name=name]').val(),
			author : $('input[name=author]').val(),
			publisher : $('input[name=publisher]').val(),
			others : $('input[name=other]').val()
		}
	}).done(function(data, status, xhr) {
		getBook();
		$('#updateBook').modal('hide');
	}).fail(function(xhr, status, error) {
		console.log('fail');
	});
});
var addBook = function() {
	$.ajax({
		url : 'http://localhost:8888/O2OSystem-merchant/restaurant',
		type : 'POST',
		dataType : 'json',
		data : {
			mName : $('input[name=mName]').val(),
			type : $('input:radio:checked').val(),
			name : $('input[name=name]').val(),
			author : $('input[name=author]').val(),
			publisher : $('input[name=publisher]').val(),
			others : $('input[name=other]').val()
		}
	}).done(function(data, status, xhr) {
		getBook();
		$('#updateBook').modal('hide');
	}).fail(function(xhr, status, error) {
		console.log('fail');
	});
};