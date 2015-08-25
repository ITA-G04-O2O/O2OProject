$(function () {
    $("button:first").click(function () {
        
    });

    /*检查用户名是否重复*/
    $("#name").blur(function () {
        var uname = $("#name").val();
        if (uname == null) {
            return;
        }
        
        /*检查用户名*/
        $.post("checkName", {name: uname}, function (rs) {
            if (rs.result >= 1) {
                $("[data-target=tip]").show();
            } else {
                $("[data-target=tip]").text("可以使用");
            }
        });
    });/*名字输入框失去焦点事件结束*/
    
    /*检查密码是否一致*/
    $("#password2").blur(function(){
        var password=$("#password").val();
        var password2=$("#password2").val();
        if(password!=password2){
            $("[data-target=psd-tip]").show();
        }
    });
    
    
    $("button:first").click(function(){
        var uname=$("#unmae").val();
        var password=$("#password").val();
        var tel=$("#tel").val();
        var register=function(){
            this.uname=uname;
            this.password=password;
            this.tel=tel;
        }
        $.post("regist",register,function(rs){
            if(rs.result>=1){
                window.location.href="http://www.baidu.com";
            }else{
                $("h3:first").show();
            }
        });
    });
});