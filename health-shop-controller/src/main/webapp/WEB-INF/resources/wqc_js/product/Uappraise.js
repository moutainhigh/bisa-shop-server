Date.prototype.Format = function (fmt) { //author: meizz 
	 var o = {
	     "M+": this.getMonth() + 1, //月份 
	     "d+": this.getDate(), //日 
	     "h+": this.getHours(), //小时 
	     "m+": this.getMinutes(), //分 
	     "s+": this.getSeconds(), //秒 
	     "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	     "S": this.getMilliseconds() //毫秒 
	 };
	 if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	 for (var k in o)
	 if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	 return fmt;
}
$(document).ready(function() {
	var path=$("base").attr("href");
	var url=null;
	var pageNum=2;
	var pageOffset=0;
	var productId=$("#productId").val();
	var htmls="";
	function request_value(request_value){
			url = request_value;
	}
	function request_pageNum(request_pageNum){
		pageNum=request_pageNum;
	}
	function request_pageOffset(request_pageOffset){
		pageOffset=request_pageOffset;
	}
	function request_htmls(request_htmls){
		htmls=htmls+request_htmls;
	}

	$(".appraise-more").click(function() {
		if(url==null){
			var dangpath =window.location.href;
			var o=dangpath.indexOf("pager.offset");
			if(o<0){
				pageOffset=2;
				pageNum=2;
				add(pageOffset,pageNum);
			}
		}else{
				var array=url.split("&");
				 for(var i=0;i<array.length;i++){
				 	name=array[i].split("=")[0];
				 	value=array[i].split("=")[1];
				 	if(name="pager.offset"){
				 		request_pageNum(value); 
				 	}else if(name="pageNum"){
				 		request_pageNum(value);
				 	}else{

				 	}

				}
				add(pageOffset,pageNum);
			}
		
		function add(pageOffset,pageNum){
			$.ajax({
				type : "GET", // 用GET方式传输
				dataType : 'json', // 数据格式:JSON
				url : path+"l/shopping/addUappraise?productId="+productId+"&pager.offset="+(pageOffset-1)*1+"&pageNum="+pageNum, // 目标地址
				success : function(data) {
					var path1=$("base").attr("href");
					console.log(path1);
					console.log(data);
					var datas = eval(data);
						for(var key in datas){
							url=key;
							request_value(url);
							var list=datas[key];
							if(list.length==0){ 
								$(".appraise-more").hide();
								$(".appraise-daodi").show();
							}else{
									for(var i=0;i<list.length;i++){
										console.log(list.length);
										request_htmls(pijie(list[i]));
										function pijie(str){
												var strVar="";
												if(str.appraise_degree==1){
													str.appraise_degree="失望";
												}else if(str.appraise_degree==2){
													str.appraise_degree="一般";
												}else if(str.appraise_degree==3){
													str.appraise_degree="满意";
												}else if(str.appraise_degree==4){
													str.appraise_degree="喜爱";
												}else{
													str.appraise_degree="超爱";
												}
												//console.log("path1:"+path1);
												strVar += "<div class=\"clear mt-20 full-w bg-white pt-40 pb-35 pr-15\">";
												strVar +="<div class=\"clear col-sm-2 pl-0 pr-0\">";
												strVar +="<img class=\"img-70 pull-right\" src=\"" ;
												strVar +=path1+"\/resources\/img\/user\/Appraise\/appraise-portraitv1.png\"";
												strVar +="  alt=\"\">";
												strVar += "<\/div>";
												strVar += "<div class=\"clear col-sm-10 pl-20 pr-20\">";
												strVar += "<p class=\"line-h-20 mb-20 clear\">";
												strVar += "<input type=\"hidden\" class=\"appraisesuccess-state\" value=\"0\">";
												strVar += "<span class=\"col-8d665a f-18 pull-left dis-ib\">" ;
												strVar += str.user_guid ;
												strVar += "<\/span>";
												strVar += "<span class=\"f-20 col-ffd600 dis-ib pull-right cur-d mr-10 appraisesuccess-statetext\">";
												strVar += str.appraise_degree;
												strVar += " <\/span>";
												strVar += "<span class=\"img-20 pull-right dis-ib mr-10 cur-d bg-faceauto appraisesuccess-stateface\">";
												strVar += " <\/span>";
												strVar += " <\/p>";
												strVar += "<p class=\"full-w mb-25\">";
												strVar += "<span class=\"f-14 col-b0b0b0\">" ;
												strVar += new Date(str.update_time).Format("yyyy-MM-dd");
												strVar += "<\/span>";
												strVar += " <\/p>";
												strVar += " <p class=\"f-14 col-333 line-h-20\">";
												strVar += str.appraise_one;
												strVar += " <\/p>";
												strVar += " <\/div>";
												strVar += " <\/div>";
												return strVar;
											}
											}
												$("#appraiseList").html(htmls);
							}
						}					
					
					}
				});

		}
			
	});
});