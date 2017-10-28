
$(document).ready(function() {
	var path=$("base").attr("href");
	//点击服务加入购物车
	$(".car-del-fuwuid").click(function() {
		var cardelvalid = $(this).parent().parent().parent().find(".cart-serve-cid").val();
		console.log(cardelvalid);
		var service_number=cardelvalid;
		var cart_product=1;
		$.ajax({
			url : path + "user/addCart",
			type : "get",
			dataType : "text",
			async : false,
			data : {
				"add_service_number" : service_number,
				"add_cart_product":cart_product,
			},
			success : function(success) {
				window.location.href=path+"user/Cart";	
			},error:function(){
			}

		});
	});
	//删除商品
		$(".del-product").click(function() {
			var deleteId=$("input[name='deleteId']").val();	
			$.ajax({
				url : path + "user/delCart",
				type : "get",
				dataType : "text",
				async : false,
				data : {
					"deleteId" : deleteId,
				},
				success : function(result) {
					if(result=="success"){
						window.location.href=path+"user/Cart";
					}else{
						layer.alert('购物车已无商品,请勿重新删除', {
			                icon: 2,
			                title: '购物车已无商品,请勿重新删除',
			                yes:function(){
			                	window.location.href=path+"user/Cart";
			                 }
			            });
					}	
					
				},error:function(){
					/*if(result=="false"){
						layer.alert('购物车已无商品,请勿重新删除', {
			                icon: 2,
			                title: '购物车已无商品,请勿重新删除',
			                yes:function(){
			                	window.location.href=path+"user/Cart";
			                 }
			            });
					
					}*/
				}
				
			});
		});	
});



	

