<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-23
  Time: 下午6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员授权</title>
    <link href="../../css/adminGrant.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/adminGrant.js"></script>
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

    <div class="reader_center">

        <span class="message_title">管理员管理</span>

        <table class="reader_center_message">
            <tr>
                <td class="croOne">要授权的读者编号</td><td class="croTwo">授权操作</td>
            </tr>

            <tr>
                <td><input type="text" name="readerId" class="borrow_input" id="readerId"> </td>
                <td><button type="button" class="grant_submit" onclick="grantReader()">授权</button></td>
            </tr>

        </table>

        <%--已授权的管理员--%>
        <div class="admin_table_div">
            <table class="admin_table">
                <tr>
                    <td>管理员编号</td>
                    <td>管理员姓名</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${admins}" var="admin">
                    <tr>
                        <td>${admin.readerId}</td>
                        <td>${admin.readerName}</td>
                        <td><a href="/admin/delAdmin.action?readerId=${admin.readerId}">撤销管理员</a></td>
                    </tr>
                </c:forEach>


            </table>
        </div>


        <span class="submit_result" id="submit_result"></span>

        <jsp:include page="adminLabel.jsp"></jsp:include>

    </div>



</div>
</body>
</html>
