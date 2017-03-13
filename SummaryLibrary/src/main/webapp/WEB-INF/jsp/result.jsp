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
    <title>查询结果</title>
    <link href="../../css/result.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

   <jsp:include page="search_bar.jsp"></jsp:include>

    <%--查询结果显示区--%>
    <div class="center_result" >

        <%--左侧分类区--%>
        <div class="result_left_category">

        </div>

        <%--右侧结果显示区--%>
        <div class="center_result_book">

            <c:forEach items="${resultBooks}" var="resultBook">

                <%--单条信息显示--%>
                <div class="result_one_book">
                        <%--图书图片--%>
                    <div class="book_img">
                        <img src="${resultBook.img}" >
                    </div>
                        <%--图书基本信息--%>
                    <div class="book_message">
                            <%--图书类别--%>
                        <span class="book_type"><a href="/search/searchByType.action?typeId=${resultBook.typeId}"> [ ${resultBook.typeName} ] </a></span>
                            <%--图书名称--%>
                        <span class="book_title"><a href="/search/collection.action?bookId=${resultBook.bookId}"> ${resultBook.bookName} </a></span><br>
                        <span class="book_sketch">[简述]:${resultBook.bookSketch}</span>
                        <span class="book_collection"><a href="/search/collection.action?bookId=${resultBook.bookId}"> [收藏信息] </a></span>
                    </div>
                </div>

            </c:forEach>


        </div>

            <div class="select_page" align="right">

                <ul>

                    <c:forEach var="item" varStatus="status" begin="1" end="${pageCount}">
                        <li><a href="/search/searchBook.action?pageCount=${ status.index}&bookMessage=${bookMessage}&selectWay=${selectWay}"> ${ status.index} </a> </li>
                    </c:forEach>

                </ul>

            </div>

    </div>

</div>
</body>
</html>
