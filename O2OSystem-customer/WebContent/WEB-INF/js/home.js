var getRestType = function () {
    alert("aaas");
    $.ajax({
        url: 'http://localhost:8888/O2OSystem-customer/restaurantType',
        type: 'get',
        dataType: 'json'
    }).done(function (data, status, xhr) {
        $('div[name=restType]').empty();
        for (var i = 0; i < data.length; i++) {
            $('div[name=restType]')
                .append(
                    '<div class="btn-group" role="group"><button type="button" class="btn btn-default">'+data[i].restType+'</button>
        </div>');
        }
    }).fail(function (xhr, status, error) {
        console.log('fail');
    });
};

$(function () {
    $(".restaurant").on("click", function () {
        location.href = "restaurant.html";
    });

    getRestType();

});