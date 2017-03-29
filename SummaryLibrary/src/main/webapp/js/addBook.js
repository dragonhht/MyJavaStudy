/**
 * Created by root on 17-3-28.
 */
//使用ajax提交信息
var xmlhttprequest;
function addBook() {
    var bookName = document.getElementById('bookName').value.trim();
    var author = document.getElementById('author').value.trim();
    var publish = document.getElementById('publish').value.trim();
    var price = document.getElementById('price').value.trim();
    var place = document.getElementById('place').value.trim();

    xmlhttprequest = new XMLHttpRequest();
    if (xmlhttprequest.overrideMimeType) {
        xmlhttprequest.overrideMimeType("text/xml");
    }
    xmlhttprequest.onreadystatechange = callback;
    //get请求
    xmlhttprequest.open("GET", "/admin/addBookMessage.action?bookName="+bookName+"&author="+author+"&publish="+publish+"&price="+price+
        "&place="+place, true);
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

                document.getElementById('bookName').value="";
                document.getElementById('author').value="";
                document.getElementById('publish').value="";
                document.getElementById('price').value="";
                document.getElementById('place').value="";
            }
        }
    }
}
