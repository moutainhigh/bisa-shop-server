$(document).ready(function() {
    //判断请求的是哪个链接，然后触发点击事件。
    switch(request_type){
    case "shoppingProcess":
    		$(".HTS-tips").hide();
            $(".HTS-tipsv1").show();
    	break;
    case "deliveryDetail":
		  $(".HTS-tips").hide();
		  $(".HTS-tipsv2").show();
		break;
    case "placeOrder":
            $(".HTS-tips").hide();
            $(".HTS-tipsv3").show();
    	break;
    case "deliveryTime":
            $(".HTS-tips").hide();
            $(".HTS-tipsv4").show();
    	break;
    case "paymentMethod":
            $(".HTS-tips").hide();
            $(".HTS-tipsv5").show();
    	break;
    case "afterSales":
            $(".HTS-tips").hide();
            $(".HTS-tipsv6").show();
    	break;
    default:
    		 $(this).parent().find(".col-active").removeClass("col-active");
    	     $(this).addClass("col-active");
    	break;
    }
    
    /*购物指南页js*/
    $(".HTS-list").click(function() {
        $(this).parent().find(".col-active").removeClass("col-active");
        $(this).addClass("col-active");
    }); 
    $(".HTS-listv1").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv1").show();
    }); 
    $(".HTS-listv2").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv2").show();
    });
    $(".HTS-listv3").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv3").show();
    });
    $(".HTS-listv4").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv4").show();
    });
    $(".HTS-listv5").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv5").show();
    });
    $(".HTS-listv6").click(function() {
        $(".HTS-tips").hide();
        $(".HTS-tipsv6").show();
    });
});