<%-- 
    Document   : classDetail
    Created on : Sept 10, 2023, 8:36:43 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center mt-2 text-info">CHI TIẾT LỚP HỌC</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã lớp học</th>
                <th>Tên môn học</th>
                <th>Tên giảng viên</th>
                <th>Số sinh viên</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${_class.id}</td>
                <td>${_class.idSubject.name}</td>
                <td>${_class.idLecture.name}</td>
                <td>${_class.quantityStudent}</td>
            </tr>
        </tbody>
    </table>

    <h2 class="text-center mt-3 text-info">Danh sách sinh viên</h2>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã sinh viên</th>
                <th>Tên sinh viên</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${scoreSheets}" var="scoreSheet">
                <tr>
                    <td>${scoreSheet.idStudent.id}</td>
                    <td>${scoreSheet.idStudent.name}</td>
                    <td><a href="#" class="btn btn-success">Chi tiết bảng điểm</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>