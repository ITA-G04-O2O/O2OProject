$(document).ready(
		function() {
			$('#section2').hide();
			$('#section3').hide();
			var count = 1;
			$.ajax({
				url : 'http://localhost:8888/o2osystem-merchant/area',
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					for ( var i in data) {
						var province = data[i];
						$('#province').append(
								"<li id=\"" + province + "\"><a href=\"#\">"
										+ province + "</a></li>");
						addClickEvent(province);
					}
				}
			});
			$('.nextStep').click(function(index) {

				$('#section' + count).hide();
				count++;
				$('#section' + (count)).show();
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
					url : "http://localhost:8888/o2osystem-merchant/city/"
							+ province,
					type : 'GET',
					dataType : 'json',
					success : function(data) {
						for ( var i in data) {
							var city = data[i];
							$('#city').append(
									"<li id=\"city" + city + "\"><a href=\"#\">"
											+ city + "</a></li>");
							addClickEvent2(city);
						}
					}
				});
			});
}

function addClickEvent2(city) {
	$("#city" + city).bind("click", function() {
		$('#cityBtn').text(city);
	});
}

$('.dropdown-menu li').on('click', function() {
	alert("hello");
	var loadhtml = $(this).attr('id');
	if (loadhtml) {
		$('#change').load(loadhtml + '.html');
	}
});

/*
 * $("#proBtn").click( function() { $.ajax({ url :
 * 'http://localhost:8888/o2osystem-merchant/area/', type : 'GET', dataType :
 * 'json', success : function(data) { $("#city li").empty(); for ( var i in
 * data) { var province = data[i]; $('#city').append( "<li><a href=\"#\">" +
 * province + "</a></li>"); } } }); });
 */