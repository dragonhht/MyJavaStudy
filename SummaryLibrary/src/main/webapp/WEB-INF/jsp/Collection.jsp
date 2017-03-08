<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-6
  Time: 下午7:30
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-27
  Time: 下午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>收藏信息</title>
    <link href="../../css/collection.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg" >

    <%--顶部菜单--%>
    <jsp:include page="menu.jsp" />

    <%--搜索框--%>
    <jsp:include page="search_bar.jsp"></jsp:include>

    <%--图书信息显示区--%>
    <div class="center_message" >


        <%--图书名--%>
        <div class="book_title" align="center">${collectionResult.bookName}</div>

        <div class="book_one">
            <%--图书图片--%>
            <div class="book_img">
                <img src="${collectionResult.img}">
            </div>
            <%--图书简介--%>
            <div class="book_message">[简介]:
                ${collectionResult.bookSketch}
            </div>
        </div>
        <%--图书借阅统计表--%>
        <div class="book_table">统计报表</div>

        <%--收藏信息--%>
        <div class="book_collect">
            <%--收藏信息--%>
            <div class="collect_message">
                <span class="book_Id">${collectionResult.bookId}</span>
                <span class="book_place">${collectionResult.place}</span>
                <span class="book_status">${collectionResult.lend}</span>
            </div>



        </div>

    </div>

</div>
</body>
</html>

