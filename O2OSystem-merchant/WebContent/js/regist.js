$(document).ready(
	function() {
		$.ajax({
			url: 'http://localhost:17236/o2osystem-merchant/area',
			type: 'GET',
			dataType: 'json',
			success: function(data) {
				for (var i in data) {
					var province = data[i];
					$('#province').append(
						"<li id=\"" + province + "\"><a href=\"#\">" + province + "</a></li>");
					addClickEvent(province);
				}
			}
		});
	});

function addClickEvent(province) {
	$("#" + province).bind(
		"click",
		function() {
			$("#proBtn").text(province);
			$("#city li").empty();
			$('#cityBtn').text("城市");
			$.ajax({
				url: "http://localhost:17236/o2osystem-merchant/city/" + province,
				type: 'GET',
				dataType: 'json',
				success: function(data) {
					for (var i in data) {
						var city = data[i];
						$('#city').append(
							"<li id=\"" + province + city + "\"><a href=\"#\">" + city + "</a></li>");
						$("#" + province + city).on("click", function() {
							$('#cityBtn').text($(this).text());
							var province = $("#proBtn").text();
							$("#provinceInput").val(province);
							$("#cityInput").val($(this).text());
						});
					}
				}
			});
		});
}

$('.dropdown-menu li').on('click', function() {
	alert("hello");
	var loadhtml = $(this).attr('id');
	if (loadhtml) {
		$('#change').load(loadhtml + '.html');
	}
});

$("#restSubmit").on('click', function() {
	var mName = $("#mName").val();
	var type = $('#radio-group input[name="type"]:checked').val();
	var province = $("#proBtn").text();
	var city = $("#cityBtn").text();
	var detail = $("#detail").val();
	alert(mName + type + province + city + detail);
});

function check_value() {
	if ($("#mName").val().length >= 1 && $("#detail").val().length >= 4) {}
	var detail = $("#detail").val();
	$("#detailInput").val(detail);
}

/*
 * $("#proBtn").click( function() { $.ajax({ url :
 * 'http://localhost:8888/o2osystem-merchant/area/', type : 'GET', dataType :
 * 'json', success : function(data) { $("#city li").empty(); for ( var i in
 * data) { var province = data[i]; $('#city').append( "<li><a href=\"#\">" +
 * province + "</a></li>"); } } }); });
 */