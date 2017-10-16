$(document).ready(function() {
	var path=$("base").attr("href");
    $(".add_shopcar").click(function() {
        var path = "";
    	path = $("base").attr("href");
    	var packId = $("input[name='packId']").val();
     //   var userId = $("input[name='userId']").val();
        var serviceId = $("input[name='serviceId']").val();
        var issingleorcombo = $("input[name='issingleorcombo']").val();
        var service_number = $("input[name='service_number']").val();
		$.ajax({
            url: path + "l/addCart",
            type: "post",
            dataType: "text",
            async: false,
            data: {
                "packId": packId,
               // "userId": userId,
                "serviceId": serviceId,
                "service_number": service_number,
                "issingleorcombo": issingleorcombo,
            },
            success: function(success) {
                var i = "l/Cart";
                window.location.href = path + i;
            }
        });

    });
    $(".user-appraise").click(function(){
    	var path = $("base").attr("href");
    	var productId=$("#productId").val();
    	window.location.href=path+"l/shopping/Uappraise?productId="+productId;
    });
});