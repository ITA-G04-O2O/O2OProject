/**
 * Created by OUOK on 8/24/2015.
 */
$(function() {

	$
		.extend({
			a: function(t) {
				$
					.ajax({
						url: 'http://localhost:17236/O2OSystem-admin/AdminService/jms',
						type: 'get',
						dataType: 'json',
					}).done(function(data, status, xhr) {
						var size = $("#jmsMsg").text();
						$("#jmsMsg").text(size + data.length);
					});
			}
		});
	setInterval("$.a()", 2000);

	$(".detailUrl").on("click", function() {
		$("#detailModal").modal('show');
	});
	$("#acceptBtn").on("click", function() {
		$("#detailModal").modal('hide');
	});
	$("#refuseBtn").on("click", function() {
		$("#detailModal").modal('hide');
	});
});