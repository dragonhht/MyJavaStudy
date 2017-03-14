
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
    <link href="../../css/readerLend.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

    <div class="reader_center">

        <span class="message_title">当前借阅信息</span>

        <table class="reader_center_message">
            <tr>
                <td >图书编号</td><td>图书名</td><td >借阅日期</td><td>应还日期</td>
            </tr>

            <c:forEach items="${borrowCord}" var="borrow">
                <tr>
                    <td>${borrow.bookId}</td><td>${borrow.bookName}</td><td>${borrow.borrowDate}</td><td>${borrow.returnDate}</td>
                </tr>
            </c:forEach>

        </table>

        <%--标签选择--%>
        <div class="select_label">

            <span  class="reader_basic_message"><a href="/reader/reader.action?readerId=${sessionScope.readerId}"> 基本信息 </a></span>
            <span  class="reader_update_password"> <a href="#">修改密码 </a></span>
            <span  class="reader_lend_book"><a href="/reader/readerLend.action?readerId=${sessionScope.readerId}">当前借阅记录 </a></span>
            <span  class="reader_histoty_book"><a href="#">历史借阅记录 </a></span>

        </div>

    </div>



</div>
</body>
</html>
