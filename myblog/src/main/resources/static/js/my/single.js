/**
 * Created by root on 17-4-24.
 */

//使用ajax提交信息
var xmlhttprequest;
var s;
function supportItem() {
    var article_id = document.getElementById("article_id").value;
    xmlhttprequest = new XMLHttpRequest();
    s = document.getElementById('supportcount').innerHTML;
    s = '被赞 ' +s.substr(2,3)+ ' 次';
    if (xmlhttprequest.overrideMimeType) {
        xmlhttprequest.overrideMimeType("text/xml");
    }
    xmlhttprequest.onreadystatechange = callback;
    //get请求
    xmlhttprequest.open("GET", "../user/supportItem/"+article_id, true);
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
                if (text == 0) {
                    alert("您已经点过赞了");
                    document.getElementById('supportcount').innerHTML = s;
                } else {
                    document.getElementById('supportcount').innerHTML = '被赞 ' +text+ ' 次';
                }

            }
        }
    }
}


