<%--
  Created by IntelliJ IDEA.
  User: Dragon_hht
  Date: 17-2-24
  Time: 上午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>请登录</title>

    <link href="../../css/login.css" rel="stylesheet" type="text/css">

</head>
<body>

<!--背景-->
<div class="bg">
    <jsp:include page="menu.jsp" />
</div>

<!--登录框-->
<div class="login_div">

    <form action="" method="post">
        <!--账号-->
        <input class="login_input login_accout" type="text" placeholder="请输入用户名" >

        <!--密码-->
        <input class="login_input login_pwd" type="text" placeholder="请输入密码" >

        <div  class="login_bottom" align="left">

            <!--忘记密码-->
            <span class="login_bottom_pwd"><a href="#" class="login_bottom_font"> 忘记密码? </a></span>

            <!--注册按钮-->
            <span class="login_bottom_regists"><a href="#" class="login_bottom_font"> 去注册 </a></span>

            <!--登录-->
            <input type="submit" value="登录" class="login_bottom_button" />
        </div>
    </form>

</div>

</body>
</html>