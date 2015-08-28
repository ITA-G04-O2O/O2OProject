$(function () {
    console.log('Menu Manager');
    var controller = (function () {
        var getMenuTypes = function (id) {
            $.ajax({
                url: "http://localhost:17236/o2osystem-merchant/menuTypes" + id,
                type: 'GET',
                dataType: 'json'
            }).done(function (data) {

            }).fail(function (data) {

            });
        };
        var renderMenuType = function (data) {
            $("#menuTypeJsonData").text(data.object[0]);
        }
        var getMenuByType = function () {

        };

        return {
            getMenuTypes: getMenuTypes
        }
    })();
});