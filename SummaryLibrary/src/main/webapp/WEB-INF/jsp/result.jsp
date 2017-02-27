<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-27
  Time: 下午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
    <link href="../../css/result.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <!--中部搜索-->
    <div class="center_search" align="center">
        <form action="/search/searchBook.action" method="post">

            <select class="center_select" name="selectWay">
                <option value="0">按书名</option>
                <option value="1">按作者</option>
                <option value="2">按出版社</option>
            </select>

            <input type="text" name="bookMessage" class="center_search_message" placeholder="请输入要搜索的信息" />
            <input type="submit" class="center_search_button" value="查询" />
        </form>
    </div>

    <%--查询结果显示区--%>
    <div class="center_result" >

        <%--左侧分类区--%>
        <div class="result_left_category">

        </div>

        <%--右侧结果显示区--%>
        <div class="center_result_book">

            <%--单条信息显示--%>
            <div class="result_one_book">

            </div>

        </div>

    </div>

</div>
</body>
</html>
