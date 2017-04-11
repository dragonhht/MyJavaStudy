<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-3-23
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--标签选择--%>

<style>
    .select_label{
        position: absolute;
    //border:1px solid red;
        width: 300px;
        height: 200px;
        right:30px;
        top: 80px;
        padding-top: 40px;
    }

    .reader_basic_message{
        margin: 0 auto;
        width: 200px;
        height: 30px;
        background-color: #EEEEEE;
        display: block;
        padding-left: 30px;
        line-height: 30px;
        border: 1px solid black;
    }

    .reader_update_password{
        margin: 5px auto;
        width: 200px;
        height: 30px;
        background-color: #EEEEEE;
        display: block;
        padding-left: 30px;
        line-height: 30px;
        border: 1px solid black;
    }

    .reader_lend_book{
        margin: 0 auto;
        width: 200px;
        height: 30px;
        background-color: #EEEEEE;
        display: block;
        padding-left: 30px;
        line-height: 30px;
        border: 1px solid black;
    }

    .admin_function{
        margin: 5px auto;
        width: 200px;
        height: 30px;
        background-color: #EEEEEE;
        display: block;
        padding-left: 30px;
        line-height: 30px;
        border: 1px solid black;
    }
</style>

<div class="select_label">

    <span  class="reader_basic_message"><a href="/admin/admin.action"> 图书借阅 </a></span>
    <span  class="reader_update_password"> <a href="/admin/returnbook.action">图书归还 </a></span>
    <span  class="reader_lend_book"><a href="/admin/grant.action">管理员授权 </a></span>
    <span  class="admin_function"> <a href="/admin/addBook.action">新增图书 </a></span>
    <span  class="admin_function"> <a href="#">修改图书 </a></span>
    <span  class="admin_function"> <a href="/admin/delBookPage.action">删除图书 </a></span>
</div>
