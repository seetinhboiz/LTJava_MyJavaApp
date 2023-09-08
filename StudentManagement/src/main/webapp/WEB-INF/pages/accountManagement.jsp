<%-- 
    Document   : accountManagement
    Created on : Sept 8, 2023, 6:05:27 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-2">QUẢN LÝ TÀI KHOẢN</h1>
<c:url value="/account/accountManagement" var="action"/>
<form:form modelAttribute="account" method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="username" placeholder="Tài khoản" name="username" path="username"/>
        <label for="username">Tài khoản</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="password" placeholder="Mật khẩu" name="password" path="password"/>
        <label for="password">Mật khẩu</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="role" name="role" path="role">
            <option value="0">Giáo vụ</option>
            <option value="1">Giảng viên</option>
            <option value="2">Sinh viên</option>
        </form:select>
        <label for="role" class="form-label">Chọn vai trò:</label>
    </div>
    <button class="btn btn-info mt-3" type="submit">
        <c:choose>
            <c:when test="${account.id == null}">Thêm tài khoản</c:when>
            <c:otherwise>Cập nhật tài khoản</c:otherwise>
        </c:choose>
    </button>
</form:form>