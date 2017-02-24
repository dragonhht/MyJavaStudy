<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-24
  Time: 上午10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图案书管理系统主页</title>

    <link href="../../css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="bg" >

        <jsp:include page="menu.jsp" />

    <!--中部搜索-->
    <div class="center_search" align="center">

        <form action="" method="post">

            <select class="center_select" >
                <option value="0">按书名</option>
                <option value="1">按作者</option>
                <option value="2">按出版社</option>
            </select>

            <input type="text" class="center_search_message" placeholder="请输入要搜索的信息" />
            <input type="submit" class="center_search_button" value="查询" />
        </form>
    </div>
</div>
</body>
</html>
