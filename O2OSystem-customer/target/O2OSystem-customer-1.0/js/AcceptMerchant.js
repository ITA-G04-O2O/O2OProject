/**
 * Created by OUOK on 8/24/2015.
 */
$(function(){
    $(".detailUrl").on("click",function(){
        console.log("haha");
        $("#detailModal").modal('show');
    });
    $("#acceptBtn").on("click",function(){
        $("#detailModal").modal('hide');
    });
    $("#refuseBtn").on("click",function(){
        $("#detailModal").modal('hide');
    });
});