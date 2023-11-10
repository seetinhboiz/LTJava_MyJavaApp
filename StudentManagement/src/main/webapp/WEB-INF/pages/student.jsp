<%-- 
    Document   : student
    Created on : Sept 8, 2023, 10:43:00 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center mt-2 text-info">SINH VIÊN</h1>
    <div>
        <a href="<c:url value="/student/studentManagement"/>" class="btn btn-info mt-2">Thêm sinh viên</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Mã sinh viên</th>
                <th>Tên giảng viên</th>
                <th>Ngày sinh</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${student}" var="student">
                <tr>
                    <td>
                        <img src="${student.avata}" alt="Ảnh" width="120"/>
                    </td>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.birth}</td>
                    <td>${student.email}</td>
                    <td>
                        <c:url value="/student/studentManagement/${student.id}" var="update"/>
                        <c:url value="/api/student/studentManagement/${student.id}" var="api"/>
                        <a href="#" class="btn btn-success">Chi tiết</a>
                        <a href="${update}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteLecture('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>    
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>