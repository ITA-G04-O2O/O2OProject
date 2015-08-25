$(function () {
    $("button[type=submit]").click(function () {
        var uname = $("#name").val();
        var pwd = $("#password").val();
        console.log("user,psd" + uname + "," + pwd);
        var user = function () {
            this.username = uname;
            this.password = pwd;
        }
        $.post("login", user, function (rs) {
            if (rs.result >= 1) {
                window.location.href="http://www.baidu.com";
            } else {
               $("em").show();
            }
        });
    });
});