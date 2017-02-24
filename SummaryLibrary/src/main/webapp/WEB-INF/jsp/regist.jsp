<%--
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
    <link href="../../css/regist.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="bg">

    <jsp:include page="menu.jsp" />

    <div class="regist_center">

        <div class="center_form">

            <form action="" method="post">

                <div class="form_div first_div">
                    <span>姓名:</span>
                    <input type="text" class="form_text form_text_first" placeholder="请输入姓名">
                </div>

                <div class="form_div">
                    <span>手机号码:</span>
                    <input type="text" class="form_text" placeholder="请输入手机号码">
                </div>

                <div class="form_div">
                    <span>电子邮箱:</span>
                    <input type="text" class="form_text" placeholder="请输入电子邮箱">
                </div>

                <div class="form_div">
                    <span>登录密码:</span>
                    <input type="text" class="form_text" placeholder="输入密码">
                </div>

                <div class="form_div">
                    <span>确认密码:</span>
                    <input type="text" class="form_text" placeholder="确定密码">
                </div>

                <div class="form_bottom">
                    <input type="submit" class="form_button" value="注册" />
                    <input type="reset" class="form_button" value="重置" />
                </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>
