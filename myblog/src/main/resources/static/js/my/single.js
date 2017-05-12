/**
 * Created by root on 17-4-24.
 */

//使用ajax提交信息
var xmlhttprequest;
var s;
function supportItem() {
    var articleId = document.getElementById("articleId").value;
    xmlhttprequest = new XMLHttpRequest();
    s = document.getElementById('supportcount').innerHTML;
    s = '被赞 ' +s.substr(2,3)+ ' 次';
    if (xmlhttprequest.overrideMimeType) {
        xmlhttprequest.overrideMimeType("text/xml");
    }
    xmlhttprequest.onreadystatechange = callback;
    //get请求
    xmlhttprequest.open("GET", "../user/supportItem/"+articleId, true);
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

//控制评论的显示的数量
//当前页数
var nowPage = 1;
//每页显示数量
var pageSize = 10;

var s = document.getElementsByClassName("thread-even");
var len = s.length;
if (len < pageSize) {
	pageSize = len;
}
for (var i = 0; i<pageSize; i++) {
	s[i].style.display = "block";
}

function showComment() {
	var i = nowPage * pageSize;
	var last = i + pageSize;
	if (last > len) {
		last = len
		document.getElementById("showcommentbtn").innerHTML = "已到最后...";
	}
	for (; i < last; i++) {
		s[i].style.display = "block";
	}
	nowPage++;
}

var child = document.getElementsByClassName("children");
var childLen = child.length;
for (var i=0; i < childLen; i++) {
	var node = child[i].getElementsByTagName("li");
	var nodeLen = node.length;
	if (nodeLen > 0) {
		child[i].getElementsByClassName("showchile")[0].style.display = "block";
		child[i].getElementsByClassName("commentpagenum")[0].innerHTML = 5;
		for (var j = 0; j < 5; j++) {
			node[j].style.display = "block";
		}
	}
}

function showChild(e) {
	var parent = e.parentNode;
	var lis = parent.getElementsByTagName("li");
	var pagenum= parent.getElementsByClassName("commentpagenum")[0];
	var nowpage = parseInt(pagenum.innerHTML);
	var last = nowpage + 5;
	var lisLen = lis.length;
	if (last > lisLen) {
		e.innerHTML = "没有更多的回复了..."
		last = lisLen;
	}
	pagenum.innerHTML = last;
	if (nowpage < lisLen) {
		for (var i = nowpage; i < last; i++) {
			lis[i].style.display = "block";
		}
	}
}

//提交博客
function saveArticle() {
	var title = $('#articleTitle').val();
	var text = $('#comment').val();
	var s = 0;
	var size = 0;
	var textLen = text.length;
	if (textLen % 400 != 0) {
		s = 1;
	}
	size = parseInt(textLen / 400) + s;
	var start = 0;
	var textStr = [];
	var len = 400;
	for (var i = 0; i < size; i++) {
		if (start + len > textLen) {
			len = textLen - start;
		}
		textStr[i] = text.substr(start, len);
		console.log(textStr[i]);
		start = start + len;
	}

	$.get("../user/saveblog?text=" + textStr + "&articleTitle=" + title,null,saveBlogCallback);
}

//回调函数
function saveBlogCallback(data){
		console.log(data);
}
