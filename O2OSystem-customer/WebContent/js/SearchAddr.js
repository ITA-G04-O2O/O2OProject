//  duankou:"address"
//	data:{addrList:[]}

$(function () {

	$("#searchBtn").on("click", function () {
		location.href = 'WEB-INF/html/home.html';
	});


	$("#searchInput").on("keyup", function () {
		var keyWord = $(this).val();
		$.post("address", {
			keyWord: keyWord
		}, function (data) {
			$("#resultTableDiv").text("");
			createTable(data);
		}, "json");
	});

	var createTable = function (data) {
		var menusTable = $("#addrTable");
		var body = menusTable.find("tbody");
		for (var i = 0; i < data.addrList.length; i++) {
			var tr = $("<tr></tr>");
			tr.appendTo(body);
			var addr = $('<td><a>' + data.addrList[i] + '</a></td>');
			addr.appendTo(tr);
		}
	};

	$("#loginUrl").on("click", function () {
		$("#loginModal").modal('show');
	});

	$("#registUrl").on("click", function () {
		$("#registModal").modal('show');
	});

	$("#helpUrl").on("click", function () {
		$("#helpModal").modal('show');
	});

});