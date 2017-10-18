$(document).ready(function() {
	$(".user-munu").click(function() {
        $(this).parent().find(".col-active").removeClass("col-active");
        $(this).addClass("col-active");
    }); 
    $(".user-order").click(function() {
        $(".user-munu").hide();
        $(".user-order").show();
    }); 
    $(".user-appraise").click(function() {
        $(".user-munu").hide();
        $(".user-appraise").show();
    });
    $(".user-center").click(function() {
        $(".user-munu").hide();
        $(".user-center").show();
    });
    $(".user-active").click(function() {
        $(".user-munu").hide();
        $(".user-active").show();
    });
    $(".user-address").click(function() {
        $(".user-munu").hide();
        $(".user-address").show();
    });
    $(".user-password").click(function() {
        $(".user-munu").hide();
        $(".user-password").show();
    });
});