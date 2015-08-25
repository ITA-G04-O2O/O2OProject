$('#myNav a').click(function(e) {
	e.preventDefault()
	$(this).tab('show')
})

$('.addbtn').click(function() {
	$('tbody').append("<tr><td>XX鸡肉卷</td><td><input type=\"number\" value=\"1\" class=\"form-control input-sm\"></td><td>8</td></tr>");
});