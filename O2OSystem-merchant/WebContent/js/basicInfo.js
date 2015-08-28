var loadBasicInfo = function() {
	var id = 2;
	$.ajax({
		url : 'http://localhost:17236/o2osystem-merchant/restaurant/' + id,
		type : 'get',
		dataType : 'json'
	}).done(function(data, status, xhr) {
		$("#notice").val(data.notice);
		$("#playPrice").val(data.playPrice);
		$("#disCharge").val(data.disCharge);
		$("#openTime").val(data.openTime);

	}).fail(function(xhr, status, error) {
		console.log('fail');
	});
};