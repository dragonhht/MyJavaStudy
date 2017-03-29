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
    <link href="../../css/addBook.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/addBook.js"></script>
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

    <div class="reader_center">

        <span class="message_title">新增图书</span>

        <table class="reader_center_message">
            <tr>
                <td class="croOne">图书名称</td><td class="croTwo"><input type="text" name="bookName"id="bookName"></td>
                <td class="croOne">作者</td><td class="croTwo"><input type="text" name="author"id="author"></td>
            </tr>
            <tr>
                <td >出版社</td><td><input type="text" name="publish"id="publish"></td>
                <td>价格</td><td><input type="text" name="price"id="price"></td>
            </tr>
            <tr>
                <td>收藏地点</td><td><input type="text" name="place"id="place"></td>
            </tr>


        </table>


        <button type="button" class="borrow_submit" onclick="addBook()">提交</button>

        <span class="submit_result" id="submit_result"></span>

        <jsp:include page="adminLabel.jsp"></jsp:include>

    </div>



</div>
</body>
</html>
