/**
 * Created by root on 17-3-17.
 */

//使用ajax提交信息
var xmlhttprequest;
function addMessage() {
    var message = document.getElementById('message_text');
    var messageText = message.value;

    if (messageText.length > 255) {
        document.getElementById('submit_result').innerHTML = "留言过长!";
        return;
    }

    xmlhttprequest = new XMLHttpRequest();
    if (xmlhttprequest.overrideMimeType) {
        xmlhttprequest.overrideMimeType("text/xml");
    }
    xmlhttprequest.onreadystatechange = callback;
    //get请求
    xmlhttprequest.open("GET", "/reader/addMessage.action?message="+messageText, true);
    xmlhttprequest.send(null);
}


//回调函数
function callback() {


    //判断对象是否交互完成
    if (xmlhttprequest.readyState == 4) {
        //判断http的交互是否完成
        if (xmlhttprequest.status == 200) {
            //3，接受服务器端数据
            var text = xmlhttprequest.responseText;
            //4，将数据显示在页面
            if (text != null && text != undefined && text != "") {
                document.getElementById('submit_result').innerHTML = text;
            }
        }
    }
}

//重置
function messageReset() {
    var message = document.getElementById('message_text');
    message.value = "";
    document.getElementById('submit_result').innerHTML = "";
}