var controller = (function () {
    var getMenuTypes = function (restId) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuTypes/" + restId,
            type: 'GET',
            dataType: 'json'
        }).done(function (data, status, xhr) {
            renderMenuType(data.object);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var addMenuType = function (restId, data) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuTypes/" + restId,
            type: 'POST',
            dataType: 'json',
            data: data
        }).done(function (data, status, xhr) {
            getMenuTypes(restId);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var getMenuItems = function (menuTypeId) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuItems/" + menuTypeId,
            type: 'GET',
            dataType: 'json'
        }).done(function (data, status, xhr) {
            renderMenuItems(data.object);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var addMenuItem = function (menuTypeId, data) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuTypes" + id,
            type: 'POST',
            dataType: 'json',
            data: data
        }).done(function (data, status, xhr) {
            getMenuItems(id);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var updateMenuItem = function (menuTypeId, data) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuItems" + menuTypeId,
            type: 'POST',
            dataType: 'json',
            data: data
        }).done(function (data, status, xhr) {
            getMenuItems(menuTypeId);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var deleteMenuItem = function (menuItemsId, menuTypeId) {
        $.ajax({
            url: "http://localhost:17236/o2osystem-merchant/menuItems/" + menuItemsId,
            type: 'DELETE',
            dataType: 'json',
            data: data
        }).done(function (data, status, xhr) {
            getMenuItems(menuTypeId);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    var renderMenuType = function (data) {
        for (var i = 0; i < data.length; i++) {
            $("#menuType").append('<label class="label-info">' + data[i].menuTypeName + '</label>  ');
            $('#change').append('<div class="panel panel-primary"><div class="panel-heading"><div class="row"><div class="col-xs-2"><span>' + data[i].menuTypeName + '</span></div><div class="col-xs-10">'
                + '<Button class="btn btn-primary pull-right" name="">Add</Button>'
                + '</div></div></div><div class="panel-body" id="menuItem' + data[i].id + '"></div></div>');
            getMenuItems(data[i].id);
        }
    };
    var renderMenuItems = function (data) {
        for (var i = 0; i < data.length; i++) {
            $('#menuItem' + data[i].typeId).append(
                '<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="..." alt="..."><div class="caption"><h3>' + data[i].itemName
                + '</h3> <p><a href="#" class="btn btn-info" role="button">Update</a> <a href="#" class="btn btn-danger" role="button">delete</a></p>' +
                ' </div></div></div>');
        }
    };
    return {
        getMenuTypes: getMenuTypes,
        addMenuType: addMenuType,
        addMenuItem: addMenuItem,
        updateMenuItem: updateMenuItem,
        deleteMenuItem: deleteMenuItem
    };
})();

$(function () {
    controller.getMenuTypes(2);
    $('#addType').live('click', function () {
        var data = {menuType:$('#type').val()};
        controller.addMenuType(2,data);
    });
});