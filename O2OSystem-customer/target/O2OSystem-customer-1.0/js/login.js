$(function () {
    $("button[type=submit]").click(function () {
        var uname = $("#name").val();
        var pwd = $("#password").val();
        
        var obj = function () {
            this.username = uname;
            this.password = pwd;
        };
    });
    
    var User=(function(){
    	var verifyInput=function(uname,pwd){
    		var ure = new RegExp("/^1\d{10}$/");
    		var pre= new RegExp("/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/");
    		/*1 可以全数字
    		2 可以全字母
    		3 可以全特殊字符(~!@#$%^&*.)
    		4 三种的组合
    		5 可以是任意两种的组合
    		6 长度6-22*/
    		if(ure.test(uname)==true&&pre.test(pwd)==true){
    			return true;
    		}else{
    			return false;
    		}
    	};
      var login=function(user){
    	  $.post("login", obj, function (rs) {
              if (rs.result >= 1) {
                  window.location.href="http://www.baidu.com";
              } else {
                 $("em").show();
              }
          });
    	  
    	  $.ajax({
				url : 'http://localhost:8888/O2OSystem-customer/login',
				type : 'delete',
				dataType : 'json'
			}).done(function(data, status, xhr) {
				getBook();
			}).fail(function(xhr, status, error) {
				console.log('fail');
			});
      };
    	return {
    		verifyInput:verifyInput
    	};
    })();
});