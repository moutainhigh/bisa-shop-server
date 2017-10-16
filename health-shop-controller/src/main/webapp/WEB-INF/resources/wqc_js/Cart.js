
$(document).ready(function() {
	var path=$("base").attr("href");
	//点击服务加入购物车
	$(".car-del-fuwuid").click(function() {
		var cardelvalid = $(this).parent().parent().parent().find(".cart-serve-cid").val();
		console.log(cardelvalid);
		var service_number=cardelvalid;
		var cart_product=1;
		$.ajax({
			url : path + "/l/addCart",
			type : "post",
			dataType : "text",
			async : false,
			data : {
				"service_number" : service_number,
				"cart_product":cart_product,
			},
			success : function(success) {
				window.location.href=path+"/l/Cart";	
			},error:function(){
			}

		});
	});
	//删除商品
		$(".del-product").click(function() {
			var deleteId=$("input[name='deleteId']").val();	
			$.ajax({
				url : path + "/l/delCart",
				type : "post",
				dataType : "text",
				async : false,
				data : {
					"deleteId" : deleteId,
					
				},
				success : function(result) {
					if(result=="success"){
						window.location.href=path+"/l/Cart";
					}	
					
				},error:function(){
					
				}
				
			});
		});	
});



	

