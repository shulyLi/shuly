function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function setOwner(data){
    $("#goodOwner .img-circle").attr("src",data.pic);
    $("#goodOwner .username a").html(data.username);
    $("#goodOwner .username a").attr("href","/html/user.jsp?userId="+data.id);

}
function setGood(data){

}
function goodDetailInit(){
    var Request = new Object();
    Request = GetRequest()

    var goodId = Request['goodId'];
    if(goodId == null ) return ;
    $.ajax({
        url: "/key/good/showGoodDetail",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: { "goodId": goodId },    //参数值
        type: "post",   //请求方式
        beforeSend: function() {
            //请求前的处理
            // alert("start");
        },
        success: function(data) {
            var flag = 0;
            if(data.msg!=""){
                alert(data.msg);
                flag = 1;
            }
            if(data.goto!=""){
                window.location.href=data.goto;
                flag =1 ;
            }
            if(flag ==1) return null;
            setOwner(data.data.owner)
            setGood(data.data.good);
        },
        complete: function() {
            //请求完成的处理
            //alert("over");
        },
        error: function() {
            //请求出错处理
            alert("here is somethine Wrong !Sorry!");
        }
    });
    $("#goodOwner");
}