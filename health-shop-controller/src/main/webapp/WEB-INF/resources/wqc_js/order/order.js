$(document).ready(function(){
	var path=$("base").attr("href");
/*     $("#addAddress").click(function(){
    	var str={"name":$("#name").val(),"address":$("#address").val(),"tel":$("#tel").val(),"email":$("#email").val(),"guid":$("#guid").val()};
    	 var i=JSON.stringify(str);	
    	 $.ajax({
 			url : path + "/l/addAddress",
 			type : "post",
 			dataType : "json",
 			async : false,
 			data : {
 				"str":i,
 				"sss":1,
 			},
 			success : function(str) {
 				//console.log(str);
 			   $(".show-add-shippingaddress").fadeOut();
               document.documentElement.style.overflow = "scroll";
 				 html_str=pinjie(str);
 				$(".conanorder-main").prepend(html_str);
 				window.location.reload();
 			},error:function(){
 			}

 		});
    	 });
     */
  /*   function pinjie(str){
			var strVar ="";
				strVar += "<div class=\"clear col-sm-3 pd-15-5-ipad conanorder-block\">";
				strVar += "                            <div class=\"clear pd-15-5-ipad bor bor-col-7A7A7A bor-col-activate min-h-190-160-ipad conanorder-tips\">";
				strVar += "                                <p class=\"line-h-30-20-ipad f-18 family-h\">";
				strVar += "<input type=\"hidden\" class=\"conanorder-tips-addr_number \" value=\"" ;
				strVar +=		"\/>";
				strVar += "                                    <span class=\"col-252525 conanorder-tips-name\">";
				strVar +=str[0].name;
				strVar +=										"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <p class=\"line-h-20 mt-15-0-ipad f-14 family-h\">";
				strVar += "                                    <span class=\"col-555 conanorder-tips-phone\">";
				strVar += str[0].tel;
				strVar += 									"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <p class=\"line-h-25 f-14 family-h text-line-4\">";
				strVar += "                                    <span class=\"col-555 conanorder-tips-address\">";
				strVar +=str[0].address;
				strVar +=		"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <input type=\"hidden\" class=\"conanorder-tips-emal\" value=\"";
				strVar +=str[0].email;
				strVar +=		"\">";
				strVar += "                                <input type=\"hidden\" class=\"conanorder-tips-about\" value=\"" ;
				strVar +=str[0].guid;	
				strVar +=		"\">";
				strVar += "                                <p class=\"clear ptb-10-5-ipad f-14 family-h line-h-20\">";
				strVar += "                                    <span class=\"pull-right col-309DE2 cur-p t-nonehove conanorder-tips-alter dis-n\">修改<\/span>";
				strVar += "                                <\/p>";
				strVar += "                            <\/div>";
				strVar += "                        <\/div>";
				return strVar;
		}
		function pinjie2(str){
			var strVar ="";
				strVar += "<div class=\"clear col-sm-3 pd-15-5-ipad conanorder-block\">";
				strVar += "                            <div class=\"clear pd-15-5-ipad bor bor-col-7A7A7A bor-col-activate min-h-190-160-ipad conanorder-tips\">";
				strVar += "                                <p class=\"line-h-30-20-ipad f-18 family-h\">";
				strVar += "<input type=\"hidden\" class=\"conanorder-tips-addr_number \" value=\"" ;
				strVar +=str[0].addr_num;
				strVar +=		"\/>";
				strVar += "                                    <span class=\"col-252525 conanorder-tips-name\">";
				strVar +=str[0].name;
				strVar +=										"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <p class=\"line-h-20 mt-15-0-ipad f-14 family-h\">";
				strVar += "                                    <span class=\"col-555 conanorder-tips-phone\">";
				strVar += str[0].tel;
				strVar += 									"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <p class=\"line-h-25 f-14 family-h text-line-4\">";
				strVar += "                                    <span class=\"col-555 conanorder-tips-address\">";
				strVar +=str[0].address;
				strVar +=		"<\/span>";
				strVar += "                                <\/p>";
				strVar += "                                <input type=\"hidden\" class=\"conanorder-tips-emal\" value=\"";
				strVar +=str[0].email;
				strVar +=		"\">";
				strVar += "                                <input type=\"hidden\" class=\"conanorder-tips-about\" value=\"" ;
				strVar +=str[0].guid;	
				strVar +=		"\">";
				strVar += "                                <p class=\"clear ptb-10-5-ipad f-14 family-h line-h-20\">";
				strVar += "                                    <span class=\"pull-right col-309DE2 cur-p t-nonehove conanorder-tips-alter dis-n\">修改<\/span>";
				strVar += "                                <\/p>";
				strVar += "                            <\/div>";
				strVar += "                        <\/div>";
				return strVar;
		}*/
		
		/*$("#updateAddresspost").click(function(){
			
			var str={"name":$("#shname").val(),"address":$("#shaddress").val(),"tel":$("#shphone").val(),"email":$("#shemail").val(),"guid":$("#shguid").val(),"addr_num":$("#shaddrnum").val()};
	    	 var i=JSON.stringify(str);	
	    	 $.ajax({
	 			url : path + "l/updateAddress",
	 			type : "post",
	 			dataType : "json",
	 			async : false,
	 			data : {
	 				"str":i,
	 			},
	 			success : function(str) {
	 				//console.log(str);
	 			   $(".show-revise-shippingaddress").fadeOut();
	               document.documentElement.style.overflow = "scroll";
	 				 html_str=pinjie2(str);
	 				$(".conanorder-main").prepend(html_str);
	 				window.location.reload();
	 			},error:function(){
	 			}

	 		});
	    	
		});	*/
		
	});
	