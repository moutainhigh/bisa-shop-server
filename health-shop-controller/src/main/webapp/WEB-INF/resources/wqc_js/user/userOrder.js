$(document).ready(function() {
	var path=$("base").attr("href");
		//tab选项卡切换
		var dangpath = window.location.href;
		//alert(dangpath);
		var i=dangpath.indexOf("userOrder1");
	        var m=dangpath.indexOf("userOrder2");
	        var u=dangpath.indexOf("userOrder3");
		if(i>0){	
	        $(".Order-tabtips").hide();
	        $(".Order-tabtipsv2").show();
	        $(".Order-control").removeClass("col-active");
	        $(".Order-controlv2").addClass("col-active");
		}
	        if(m>0){        
	        $(".Order-tabtips").hide();
	        $(".Order-tabtipsv3").show();
	        $(".Order-control").removeClass("col-active");
	        $(".Order-controlv3").addClass("col-active");
	        }
	        if(u>0){        
	        $(".Order-tabtips").hide();
	        $(".Order-tabtipsv4").show();
	        $(".Order-control").removeClass("col-active");
	        $(".Order-controlv4").addClass("col-active");
	        }
	       
	});
	

