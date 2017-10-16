$(document).ready(function() {
    /*修改密码部分的校验*/
    $.validator.setDefaults({
        submitHandler: function() {
        	var cname = $(".cname").val();
        	var cphone = $(".cphone").val();
        	var cemail = $(".cemail").val();
        	var message = $("textarea").val();
           /* ajax提交留言到后台*/
           $.ajax({
        	   type:"POST",
        	   dataType:"text",
        	   url:http_request+'/l/contactUs',
        	   data:{name:cname,phone:cphone,mail:cemail,text:message},
        	   error:function (XMLHttpRequest, textStatus, errorThrown) { },
        	   success:function(data){
        		   if(data=="true"){
        			   alert("您的留言已经成功提交，两个工作日内会尽快处理，如果成功处理您的留言，我们会通过短信或者邮箱给您回复！");
        			   /*将输入框的内容清空*/
        			 	$(".cname").val("");
        	        	$(".cphone").val("");
        	        	$(".cemail").val("");
        	        	$("textarea").val("");
        		   }else{
        			   alert("您的留言没有提交成功！请检查手机号和邮箱是否为空，然后再重新提交一次！");
        		   }
        	   }
           })
        }
    });
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $(".contactus-form").validate({
            rules: {
                cname: {
                    required: true,
                },
                cphone: {
                    required: true,
                    minlength:8,
                },
                cabout: {
                    required: true,
                },
            },
            messages: {
                cname: {
                    required: "请输入您的姓名",
                },
                cphone: {
                    required: "手机号不能为空",
                    minlength:"手机号最小长度6位",
                },
                cabout: {
                    required: "留言内容不能为空",
                },
            }
        });
    });
});

