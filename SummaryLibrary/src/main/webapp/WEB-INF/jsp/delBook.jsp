<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-23
  Time: 下午6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <link href="../../css/delBook.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/delBook.js"></script>
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

    <div class="reader_center">

        <span class="message_title">新增图书</span>

        <table class="reader_center_message">
            <tr>
               <td>要删除的图书编号</td>
                <td><input type="text" name="bookId" id="bookId" class="del_bookId"></td>
            </tr>
        </table>


        <button type="button" class="borrow_submit" onclick="delBook()">提交</button>

        <span class="submit_result" id="submit_result"></span>

        <jsp:include page="adminLabel.jsp"></jsp:include>

    </div>



</div>
</body>
</html>
