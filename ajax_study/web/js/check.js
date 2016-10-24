/**
 * Created by 游戏2 on 2016/10/24.
 */

//定义用户名校验
function check(){

    //1，获取文本框内容
        //使用jquery
        var obj=$('#username');
        var username=obj.val();

    //2，将数据发送至服务器端
        //使用jquery
        $.get("AJAXServlet?name="+username,null,callback);



}

//回调函数
function callback(data){
    //3，接受服务器端数据
        //服务器端返回的数据会被放入参数data中
        //alert("点用了:"+data);

    //4，将数据显示在页面
        //获取节点
        var resultObj=$('#result');
        //改变节点内容
        resultObj.html(data);

}