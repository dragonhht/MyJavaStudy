<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-15
  Time: 下午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>

    <link href="../../css/messageBorad.css" rel="stylesheet">
    <script src="../../js/messageBorad.js" type="text/javascript"></script>
</head>
<body>
<div class="bg" >

    <jsp:include page="menu.jsp" />

    <jsp:include page="search_bar.jsp"></jsp:include>

        <div class="borad_center">

            <span class="center_title">留言板</span>


                <textarea class="message_text" id="message_text" type="text" placeholder="请留言"></textarea><br>
                <span class="submit_result" id="submit_result"></span>
                <input type="submit" value="提交" class="message_submit" onclick="addMessage()">
                <button class="message_button" onclick="messageReset()">重置</button>

        </div>


</div>
</body>
</html>