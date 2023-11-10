<%-- 
    Document   : account
    Created on : Sept 8, 2023, 11:57:40 a.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center mt-2 text-info">TÀI KHOẢN</h1>
    <div>
        <a href="<c:url value="/account/accountManagement"/>" class="btn btn-info mt-2">Thêm tài khoản</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã tài khoản</th>
                <th>Username</th>
                <th>Vai trò</th>
                <th>Tình trạng tài khoản</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${account}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.username}</td>
                    <c:choose>
                        <c:when test="${account.role == 0}">
                            <td class="text-info">Giáo vụ</td>
                        </c:when>
                        <c:when test="${account.role == 1}">
                            <td>Giảng viên</td>
                        </c:when>
                        <c:otherwise>
                            <td>Sinh viên</td>  
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${account.available == 0}">
                            <td>Chưa được sử dụng</td>
                        </c:when>
                        <c:otherwise>
                            <td>Đang được sử dụng</td>  
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <c:url value="/account/accountManagement/${account.id}" var="update"/>
                        <c:url value="/api/account/accountManagement/${account.id}" var="api"/>
                        <a href="${update}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteLecture('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>