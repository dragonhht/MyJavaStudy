/**
 * Created by root on 17-3-23.
 */

//使用ajax提交信息
var xmlhttprequest;
function borrowBook() {
    var bookId = document.getElementById('bookId').value.trim();
    var readerId = document.getElementById('readerId').value.trim();

    xmlhttprequest = new XMLHttpRequest();
    if (xmlhttprequest.overrideMimeType) {
        xmlhttprequest.overrideMimeType("text/xml");
    }
    xmlhttprequest.onreadystatechange = callback;
    //get请求
    xmlhttprequest.open("GET", "/admin/readerReturnBook.action?readId="+readerId+"&bookId="+bookId, true);
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
/**
 * Created by root on 17-3-23.
 */
