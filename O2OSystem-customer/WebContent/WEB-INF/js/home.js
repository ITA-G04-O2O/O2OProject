var restController = (function () {
    var loadRestType = function loadRestType(data) {
        $('div[name=restType]').empty();
        for (var i = 0; i < data.length; i++) {
            $('div[name=restType]').append('<div class="btn-group" role="group">
            <button type="button" class="btn btn-default">data</button>
        </div>');
        }
    };
    var getRestType = function () {
        $.ajax({
            url: 'http://localhost:8888/O2OSystem-customer/restaurantType',
            type: 'get',
            dataType: 'json'
        }).done(function (data, status, xhr) {
            loadRestType(data.restTypes);
        }).fail(function (xhr, status, error) {
            console.log('fail');
        });
    };
    return {
        loadData: loadData,
        addBook: addBook,
        updateBook: updateBook,
        getBook: getBook,
        getBookDetail: getBookDetail,
        deleteBook: deleteBook
    };
})();
$(function () {
    $(".restaurant").on("click", function () {
        location.href = "restaurant.html";
    });


});