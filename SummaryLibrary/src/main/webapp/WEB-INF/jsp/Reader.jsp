
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

        <form action="/reader/updateMessage.action" method="post">
        <table class="reader_center_message">

            <c:choose>
                <c:when test="${updateFlage == 1}">
                    <tr>
                        <td class="table_one">姓名:</td>
                        <td class="table_two"><input value="${readerMessage.readerName}" name="readerName" class="reader_message_input"></td>
                        <td class="table_one">编号:</td>
                        <td class="table_two">${readerMessage.readerId}</td>
                        <td rowspan="3" style="width:130px;"><img src="${readerMessage.readerName}"></td>
                    </tr>

                    <tr>
                        <td >电子邮件:</td>
                        <td><input value="${readerMessage.email}" name="email" class="reader_message_input"></td>
                        <td>联系方式:</td>
                        <td><input value="${readerMessage.phone}" name="phone" class="reader_message_input"></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height: 100px;"><textarea name="motto" placeholder="个人格言:"></textarea></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td class="table_one">姓名:</td><td class="table_two">${readerMessage.readerName}</td>
                        <td class="table_one">编号:</td><td class="table_two">${readerMessage.readerId}</td>
                        <td rowspan="3" style="width:130px;"><img src="${readerMessage.readerName}"></td>
                    </tr>

                    <tr>
                        <td >电子邮件:</td><td>${readerMessage.email}</td><td>联系方式:</td><td>${readerMessage.phone}</td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height: 100px;"><textarea name="motto" placeholder="个人格言:"></textarea></td>
                    </tr>
                </c:otherwise>
            </c:choose>


        </table>

        <div class="center_button">
            <button type="button" class="update_button" onclick="window.location.href='/reader/reader.action?readerId=${sessionScope.readerId}&flag=update'">修改</button>

            <c:if test="${updateFlage == 1}">
                <button class="save_button" type="submit">保存</button>
            </c:if>
        </div>
            <c:if test="${updateResult == false}">
                <span class="update_reuslt">修改失败!</span>
            </c:if>

        </form>
        <%--标签选择--%>
        <div class="select_label">

            <span  class="reader_basic_message"><a href="/reader/reader.action?readerId=${sessionScope.readerId}"> 基本信息 </a></span>
            <span  class="reader_update_password"> <a href="#">修改密码 </a></span>
            <span  class="reader_lend_book"><a href="/reader/readerLend.action?readerId=${sessionScope.readerId}">当前借阅记录 </a></span>

        </div>

    </div>



</div>
</body>
</html>
