<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-25
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-24
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link href="../../css/msg.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="bg">

    <jsp:include page="menu.jsp" />

    <div class="msg_center">


        <div class="center_form">

            <div class="right_image"></div>

            <span class="center_message">注册成功,您的账号为: ${registSuccess}  </span>
            <span class="center_to_login"><a href="/login.action"> 前去登录</a></span>

        </div>

    </div>

</div>

</body>
</html>

