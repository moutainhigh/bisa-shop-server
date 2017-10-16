$(document).ready(function() {
	var path=$("base").attr("href");
		//tab选项卡切换
		var dangpath = window.location.href;
		//alert(dangpath);
			var o=dangpath.indexOf("userAppraise");
			var i=dangpath.indexOf("userAppraise1");
	        var m=dangpath.indexOf("userAppraise2");
	        //console.log(i);
	        if(0>0){	
		        $(".Appraise-tabtips").hide();
		        $(".Appraise-tabtipsv1").show();
		        $(".Appraise-control").removeClass("col-active");
		        $(".Appraise-tabtipsv1").addClass("col-active");
			}
			if(i>0){	
		        $(".Appraise-tabtips").hide();
		        $(".Appraise-tabtipsv2").show();
		        $(".Appraise-control").removeClass("col-active");
		        $(".Appraise-tabtipsv2").addClass("col-active");
			}
	        if(m>0){        
		        $(".Appraise-tabtips").hide();
		        $(".Appraise-tabtipsv3").show();
		        $(".Appraise-control").removeClass("col-active");
		        $(".Appraise-tabtipsv3").addClass("col-active");
	        }
	       
	});
	

