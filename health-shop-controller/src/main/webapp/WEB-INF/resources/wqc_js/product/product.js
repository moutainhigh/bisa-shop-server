$(document).ready(function() {
	var path=$("base").attr("href");
    /*$(".add_shopcar").click(function() {
        var path = "";
    	path = $("base").attr("href");
    	var packId = $("input[name='packId']").val();
     //   var userId = $("input[name='userId']").val();
        var serviceId = $("input[name='serviceId']").val();
        var issingleorcombo = $("input[name='issingleorcombo']").val();
        var service_number = $("input[name='service_number']").val();
		$.ajax({
            url: path + "a/addCart",
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
                var i = "a/Cart";
                window.location.href = path + i;
            }
        });

    });*/
	$(".add_shopcar").click(function() {
		var packId = $("input[name='packId']").val();
		var serviceId = $("input[name='serviceId']").val();
		var issingleorcombo = $("input[name='issingleorcombo']").val();
		var service_number = $("input[name='service_number']").val();
		$(".add-PackId").val(packId);
		$(".add-serviceId").val(serviceId);
		$(".add-issingleorcombo").val(issingleorcombo);
		$(".add-service_number").val(service_number);
	});
    $(".user-appraise").click(function(){
    	var path = $("base").attr("href");
    	var productId=$("#productId").val();
    	window.location.href=path+"l/shopping/Uappraise?productId="+productId;
    });
});