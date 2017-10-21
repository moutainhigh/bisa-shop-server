
$(document).ready(function() {
	//判断请求的是哪个链接，然后触发点击事件。
	var path=$("base").attr("href");
/*    switch(request_type){
    case "userOrder":
    	 $(".user-munu").hide();
         $(".user-order").show();
    	break;
    case "userAppraise":
        $(".user-munu").hide();
        $(".user-appraise").show();
		break;
  
    default:
    		 $(this).parent().find(".col-active").removeClass("col-active");
    	     $(this).addClass("col-active");
    	break;
    }*/
	
	
	$(".user-munu").click(function() {
        $(this).parent().find(".col-active").removeClass("col-active");
        $(this).addClass("col-active");
    }); 
    $(".user-order").click(function() {
       // $(".user-munu").hide();
        //$(".user-order").show();
        window.location.href=path+"/user/userOrder";
    }); 
    $(".user-appraise").click(function() {
       // $(".user-munu").hide();
       // $(".user-appraise").show();
        window.location.href=path+"/user/userAppraise";
    });
    $(".user-center").click(function() {
        //$(".user-munu").hide();
        //$(".user-center").show();
    });
    $(".user-active").click(function() {
        //$(".user-munu").hide();
        //$(".user-active").show();
    });
    $(".user-address").click(function() {
        //$(".user-munu").hide();
        //$(".user-address").show();
    });
    $(".user-password").click(function() {
        //$(".user-munu").hide();
        //$(".user-password").show();
    });
});