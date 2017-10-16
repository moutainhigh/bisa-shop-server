$(document).ready(function() {
	//userAppraiseInfo();
	var path=$("base").attr("href");
	$(".submit-sh").click(function() {
		//var userId=$("input[name='userId']").val();
	    var appraise_one=$("#appraises-one").val();
	    var appraise_degree=$(".record-face").val();
	    var order_detail_guid=$(".text-orderguid").val();
		$.ajax({
			url : path + "l/addAppraise",
			type : "post",
			dataType : "text",
			async : false,
			data : {
				"appraise_one" : appraise_one,
				"appraise_degree":appraise_degree,
				"order_detail_guid":order_detail_guid,
			},
			success : function(success) {
				window.location.href=path+"l/AppraiseSuccess?order_detail_guid="+order_detail_guid;	
			},error:function(){
			}

		});
	    
	});
});