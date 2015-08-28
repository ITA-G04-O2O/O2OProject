var loadRestInfo = function() {
	$.ajax({
		url : "http://localhost:17236/o2osystem-merchant/restaurant/" + 2,
		type : 'GET',
		dataType : 'json',
		success : function(data) {
			$("#name").val(data.name);
			$("#tel").val(data.tel);
			$("#detail").val(data.detail);
			$("#proBtn").val(data.pro);
			$("#cityBtn").val(data.city);
		}
	});

	$("#restInfoEditBtn").live("click", function() {
		alert($("#detail").val());
		$.ajax({
			type : "post",
			url : "http://localhost:17236/o2osystem-merchant/restaurant/" + 2,
			dataType : 'json',
			data : {
				name : $("#name").val(),
				tel : $("#tel").val(),
				pro : $("#proBtn").text(),
				city : $("#cityBtn").text(),
				detail : $("#detail").val()
			}

		}).done(function(data, status, xhr) {
		}).fail(function(xhr, status, error) {
			console.log('fail');
		});
	});

	$("#proBtn").live(
			"click",
			function() {
				$.ajax({
					url : 'http://localhost:17236/o2osystem-merchant/area',
					type : 'GET',
					dataType : 'json',
					success : function(data) {
						$("#province li").empty();
						for ( var i in data) {
							var province = data[i];
							$('#province').append(
									"<li id=\"" + province
											+ "\"><a href=\"#\">" + province
											+ "</a></li>");
							addClickEvent(province);
						}
					}
				});
			});

	function addClickEvent(province) {
		$("#" + province).live(
				"click",
				function() {
					$("#proBtn").text(province);
					$("#city li").empty();
					$('#cityBtn').text("城市");
					$.ajax({
						url : "http://localhost:17236/o2osystem-merchant/city/"
								+ province,
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							for ( var i in data) {
								var city = data[i];
								$('#city').append(
										"<li id=\"" + province + city
												+ "\"><a href=\"#\">" + city
												+ "</a></li>");
								$("#" + province + city)
										.live(
												"click",
												function() {
													$('#cityBtn').text(
															$(this).text());
													var province = $("#proBtn")
															.text();
													$("#provinceInput").val(
															province);
													$("#cityInput").val(
															$(this).text());
												});
							}
						}
					});
				});
	}

};
