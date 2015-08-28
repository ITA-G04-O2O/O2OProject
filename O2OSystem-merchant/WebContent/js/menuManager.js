$(function () {
    var controller = (function () {
        var getMenuTypes = function (id) {
            $.ajax({
                url: "http://localhost:17236/o2osystem-merchant/menuTypes" + id,
                type: 'GET',
                dataType: 'json'
            }).done(function (data, status, xhr) {
                if (data.result) renderMenuType(data.object);
            }).fail(function (xhr, status, error) {
                console.log('fail');
            });
        };
        var getMenuItems = function (id) {
            $.ajax({
                url: "http://localhost:17236/o2osystem-merchant/menuTypes" + id,
                type: 'GET',
                dataType: 'json'
            }).done(function (data, status, xhr) {
                if (data.result) renderMenuType(data.object);
            }).fail(function (xhr, status, error) {
                console.log('fail');
            });
        };
        var renderMenuType = function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#menuType").append('<label class="label-info">' + data[i] + '</label>');
                getMenuItems(id);
            }
        };
        var renderMenuItems = function (data) {
            for (var i = 0; i < data.length; i++) {
                $('#change').append('<div class="panel panel-primary"><div class="panel-heading"><div class="row"><div class="col-xs-2"><span>' + data[id].name+'</span></div><div class="col-xs-10">'
                    +'<Button class="btn btn-primary pull-right">Add</Button>'
                    +'</div></div></div><div class="panel-body" id="menuType" >' +
                    '<div class="row"><div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="..." alt="..."><div class="caption"><h3>' + data[i].name
                    +'</h3> <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>'+
                    ' </div></div></div></div>' +
                    '</div></div>');
            }
        };
        return {
            getMenuTypes: getMenuTypes
        }
    })();
});