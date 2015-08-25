/**
 * Created by OUOK on 8/15/2015.
 */
$(function () {
	$("#loginBtn").on("click", function () {
		location.href = "WEB-INF/html/manage.html";
		console.log("loginbtn click");
		var name = $("#username").val();
		var psd = $("#password").val();
		checkUser(name, psd);
	});

	var checkUser = function (name, psd) {
		$.post("ls", {
				username: name,
				password: psd
			},
			function (data) {
				var result = data.result;
				if (result) {
					$.cookie("uname", name);
					//					location.href = "mms";
					location.href = "WEB-INF/html/manage.html";
				} else {
					//					$.cookie("event", "login");
					location.href = "fail.html";
					//					$("loginBtn").prepend("<div><a>Login Fail</a>< /div>");
				}
			}, "json");
	}
});