// pager-taglib.jar
 
/**
 * 更改分页的请求方式，使之支持POST提交方式，当有FORM标签时为FORM标签的提交方式，否则为GET提交方式
 * 使用时，只需在原来的每个标签上添加单击事件即可
 * 一般：onclick="return setOffset(this,${pageNumber })?pageSubmit(this):true;"
 * 跳转：onclick="return tj(this)?pageSubmit(this):false;"
 */
 
function getParentDOM(obj){
    var parent = obj.parentNode;
    if(parent.nodeName.toLowerCase()=="body"){
        return document;
    }
    var className = parent.getAttribute("class");
    if(className.indexOf("pager-taglib")==-1){
        return getParentDOM(parent);
    }
    return parent;
}
 
/**
 * 一、跳转
 * 二、设置submit提交时的pageOffset的值
 */
/*function tj(obj){
    var parent = getParentDOM(obj);
    var inputs = parent.getElementsByTagName('input');
    var len = inputs.length;
    var offsetInput = inputs[len-2];
    var pageUrl = obj.getAttribute("href");
    var pageInput = inputs[len-1];
    var pagesize = pageInput.getAttribute("pagesize");
    var pageCount = pageInput.getAttribute("pageCount");
    var oldOffsetValue = pageInput.getAttribute("pageOffset");
    var oldPageValue = pageInput.getAttribute("number");
    var newPageValue = pageInput.value;
    if(parseInt(newPageValue)<=0||parseInt(newPageValue)>pageCount){
        alert('索引超出范围！');
        pageInput.value = oldPageValue;
        pageInput.focus();
        return false;
    }
    var newoffsetValue = (newPageValue-1)*pagesize;
    var newPageUrl = pageUrl.replace("offset="+oldOffsetValue,"offset="+newoffsetValue);
    obj.setAttribute("href",newPageUrl);
    offsetInput.value=newoffsetValue;
    return true;
}*/

function tj(obj){
    var parent = getParentDOM(obj);
    var pageUrl = obj.getAttribute("href");
    var newPageUrl = pageUrl.replace("report_type="+oldOffsetValue,"offset="+newoffsetValue);
}
/**
 * 提交页面
 * @param obj 当前事件对象
 * @returns
 */
function pageSubmit(obj){
    var formDom = obj.parentNode;
    if(formDom.nodeName.toLowerCase()=='form'){
        formDom.submit();
    } else {
        if(formDom.nodeName.toLowerCase()=='body'){
            return true;
        }
        return pageSubmit(formDom);
    }
    return false;
}
/**
 * 设置submit提交时的pageOffset的值
 */
function setOffset(obj,pageNumber,reportType){
    var parent = getParentDOM(obj);
    var inputs = parent.getElementsByTagName('input');
    var len = inputs.length;
    var pageInput = inputs[len-1];
    var offsetInput = inputs[len-2];
     
    var pagesize = pageInput.getAttribute("pagesize");;
    var newoffsetValue = (pageNumber-1)*pagesize;
    
    offsetInput.value=newoffsetValue;
    
    return true;
}
