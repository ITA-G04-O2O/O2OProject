var getRestType = function() {
				$.ajax({
					url : 'http://localhost:8888/O2OSystem-customer/',
					type : 'get',
					dataType : 'json'
				}).done(function(data, status, xhr) {
					loadData(data.books);
				}).fail(function(xhr, status, error) {
					console.log('fail');
				});
			};

$(function () {
	$(".restaurant").on("click", function () {
		location.href = "restaurant.html";
	});
    
    
});