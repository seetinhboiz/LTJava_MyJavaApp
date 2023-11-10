<%-- 
    Document   : login
    Created on : Sept 7, 2023, 12:20:23 p.m.
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<h1 class="text-center mt-2 text-info">ĐĂNG NHẬP</h1>
<form method="post" action="${action}" >
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Tài khoản" name="username">
        <label for="username">Tài khoản</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password">
        <label for="password">Mật khẩu</label>
    </div>
    
    <div class="form-floating mt-3 mb-3 text-center">
        <input type="submit" value="Đăng nhập" class="btn btn-info" />
    </div>
    <div class="text-center">
        <a href="<c:url value="/register"/>" class="btn btn-info mt-2">Đăng ký</a>
    </div>
</form>