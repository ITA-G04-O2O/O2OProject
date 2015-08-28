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
    	console.log("login");
    	if(name=="admin" && psd == "admin"){
    		location.href = "http://localhost:17236/O2OSystem-admin/index";
    	}else{
    		alert("賬號或密碼錯誤")
    		location.href = "http://localhost:17236/O2OSystem-admin/login";
    	}
//      $.post("ls", {
//              username: name,
//              password: psd
//          },
//          function (data) {
//              var result = data.result;
//              if (result) {
//                  $.cookie("uname", name);
//                  location.href = "WEB-INF/html/manage.html";
//              } else {
//                  location.href = "fail.html";
//              }
//          }, "json");
    }
});