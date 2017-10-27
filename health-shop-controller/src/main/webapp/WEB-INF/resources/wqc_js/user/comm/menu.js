
$(document).ready(function() {
	//判断请求的是哪个链接，然后触发点击事件。
	var path=$("base").attr("href");
	
	$(".user-munu").click(function() {
        $(this).parent().find(".col-active").removeClass("col-active");
        $(this).addClass("col-active");
    }); 
    $(".user-order").click(function() {

        window.location.href=path+"user/userOrder";
    }); 
    $(".user-appraise").click(function() {

        window.location.href=path+"user/userAppraise";
    });
    $(".user-center").click(function() {

    	 window.location.href=path+"user/userCenter";
    });
    $(".user-active").click(function() {
    	window.location.href=path+"a/active_list";
    });
    $(".user-address").click(function() {
    	window.location.href=path+"user/userAddress";
    });
    $(".user-password").click(function() {
        //$(".user-munu").hide();
        //$(".user-password").show();
    });
});