<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-6
  Time: 下午7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .center_search{
    //border: 1px solid green;
        margin-top: 80px;
        width: 1200px;
    }

    .center_select{
        height: 35px;
        width: 100px;
    }

    .center_search_message{
        height: 35px;
        width: 500px;
    }

    .center_search_button{
        height: 35px;
        width: 70px;
        background-color: #3B77CD;
        border: none;
    }

</style>

<!--中部搜索-->
<div class="center_search" align="center">
    <form action="/search/searchBook.action" method="post">

        <select class="center_select" name="selectWay">
            <option value="0">按书名</option>
            <option value="1">按作者</option>
            <option value="2">按出版社</option>
        </select>

        <input type="text" name="bookMessage" class="center_search_message" placeholder="请输入要搜索的信息" />
        <input type="submit" class="center_search_button" value="查询" />
    </form>
</div>
