var showAccount = function() {
	var id = 2;
	$.ajax({
		url : 'http://localhost:17236/o2osystem-merchant/merchant/' + id,
		type : 'get',
		dataType : 'json'
	}).done(function(data, status, xhr) {
		$("#realName").val(data.realName);
		$("#tel").val(data.tel);
		$("#idCard").val(data.idCard);
		
	}).fail(function(xhr, status, error) {
		console.log('fail');
	});

	$("#infoEditBtn").live("click", function() {
		alert("edit" + $("#realName").val());
		$.ajax({
			url : 'http://localhost:17236/o2osystem-merchant/merchant/vo',
			type : 'post',
			dataType : 'json',
			data : {
				realName : $("#realName").val(),
				tel : $("#tel").val(),
				idCard : $("#idCard").val(),
				id : id
			}

		}).done(function(data, status, xhr) {
			console.log("更新成功")
		}).fail(function(xhr, status, error) {
			console.log("更新失败")
		});
	});

};
