$(document).ready(function() {
    /*头部导航下划线*/
    $(".mainnav").find("a").mouseenter(function() {
        $(this).addClass("navbor");
    });
    $(".mainnav").find("a").mouseleave(function() {
        $(this).removeClass("navbor");
    });
    /*头部输入框变化*/
    $(".mainsearch").click(function() {
        event.stopPropagation();
        $(".mainsearchinput").fadeIn();
    });
    $(document).click(function() {
        $('.mainsearchinput').fadeOut();
    });
    /*健康咨询页js*/
    wh169();
    function wh169(){
        var wh169h = $(".wh16-9").width()*9/16;
        $(".wh16-9").css("height",wh169h);
    };
    
    var last = $("#last-news").text();
    console.log("last-news>>>>>>"+last);
    if(last=="无"){
    	$("#last-news").attr("href","#");
    	$("#last-news").text("没有了");
    }
    var next = $("#next-news").text();
    if(next=="无"){
    	$("#next-news").attr("href","#");
    	$("#next-news").text("没有了");
    }
});