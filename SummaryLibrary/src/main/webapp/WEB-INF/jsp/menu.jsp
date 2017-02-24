<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-24
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .top_menu{
    //border: 1px solid gray;
        width: 1200px;
        height: 40px;
    }

    .top_menu li{
        float: right;
        height: 40px;
        margin-right: 20px;

    }

    .top_menu li a{
        color: rgb(204, 204, 204);
        font-size: 15px;
    }
</style>

<!--顶部菜单-->
<div class="top_menu">
    <ul>
        <li><a href="#"> 留言 </a></li>
        <li><a href="/index.action"> 查找 </a></li>
        <li><a href="#"> 分类目录 </a></li>
        <li><a href="/login.action"> 登录 </a> </li>
    </ul>
</div>
