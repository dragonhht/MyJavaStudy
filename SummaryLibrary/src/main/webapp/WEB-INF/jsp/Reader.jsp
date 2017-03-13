
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
    <link href="../../css/reader.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

    <div class="reader_center">

        <span class="message_title">基本信息</span>

        <table class="reader_center_message">
            <tr>
                <td class="table_one">姓名:</td><td class="table_two">${readerMessage.readerName}</td>
                <td class="table_one">编号:</td><td class="table_two">${readerMessage.readerId}</td>
                <td rowspan="3" style="width:130px;"><img src="${readerMessage.readerName}"></td>
            </tr>

            <tr>
                <td >电子邮件:</td><td>${readerMessage.email}</td><td>联系方式:</td><td>${readerMessage.phone}</td>
            </tr>
            <tr>
                <td colspan="4" style="height: 100px;"><textarea placeholder="个人格言:"></textarea></td>
            </tr>
        </table>

        <%--标签选择--%>
        <div class="select_label">

            <span  class="reader_basic_message">基本信息</span>
            <span  class="reader_update_password">修改密码</span>
            <span  class="reader_lend_book">当前借阅记录</span>
            <span  class="reader_histoty_book">历史借阅记录</span>

        </div>

    </div>



</div>
</body>
</html>
