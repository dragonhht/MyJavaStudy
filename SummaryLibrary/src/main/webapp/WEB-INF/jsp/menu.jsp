<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-2-24
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <c:if test="${sessionScope.readerName != null}">
            <li><a href="/reader/login_out.action"> 退出 </a> </li>
        </c:if>

        <li><a href="/messageBorad.action"> 留言 </a></li>
        <li><a href="/index.action"> 查找 </a></li>
        <li><a href="#"> 分类目录 </a></li>

        <c:choose>
            <c:when test="${sessionScope.readerName != null}">
                <li><a href="/reader/reader.action?readerId=${sessionScope.readerId}"> ${sessionScope.readerName} </a> </li>
            </c:when>

            <c:otherwise>
                <li><a href="/login.action"> 登录 </a> </li>
            </c:otherwise>
        </c:choose>

    </ul>
</div>
