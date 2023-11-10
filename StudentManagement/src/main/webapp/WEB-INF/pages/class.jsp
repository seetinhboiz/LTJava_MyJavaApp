<%-- 
    Document   : class
    Created on : Sept 9, 2023, 9:35:25 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center mt-2 text-info">LỚP HỌC</h1>
    <div>
        <a href="<c:url value="/class/classManagement" />" class="btn btn-info mt-2">Thêm môn học</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã lớp học</th>
                <th>Tên môn học</th>
                <th>Tên giảng viên</th>
                <th>Số sinh viên</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${_class}" var="classes">
                <tr>
                    <td>${classes.id}</td>
                    <td>${classes.idSubject.name}</td>
                    <td>${classes.idLecture.name}</td>
                    <td>${classes.quantityStudent}</td>
                    <td>
                        <c:url value="/class/classManagement/${classes.id}" var="update"/>
                        <c:url value="/class/classDetail/${classes.id}" var="detail"/>
                        <c:url value="/api/class/classManagement/${classes.id}" var="api"/>
                        <a href="${detail}" class="btn btn-success">Chi tiết</a>
                        <a href="${update}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteLecture('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>