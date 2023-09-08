<%-- 
    Document   : header
    Created on : Aug 30, 2023, 6:23:54 p.m.
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/" />">Scores Managemnt</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/subject" />">Môn học</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/account" />">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Lớp</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sinh viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Điểm</a>
                </li>

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                        </li>
                            <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa..." >
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>