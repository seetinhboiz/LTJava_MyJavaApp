<%-- 
    Document   : subject
    Created on : Sept 1, 2023, 9:53:39 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center mt-2 text-info">MÔN HỌC</h1>
    <div>
        <a href="<c:url value="/subject/subjectManagement" />" class="btn btn-info mt-2">Thêm môn học</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã môn học</th>
                <th>Tên môn học</th>
                <th>Số tín chỉ</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${subject}" var="subject">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td>${subject.credit}</td>
                    <td>
                        <c:url value="/subject/subjectManagement/${subject.id}" var="update"/>
                        <c:url value="/api/subject/subjectManagement/${subject.id}" var="api"/>
                        <a href="${update}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteLecture('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>