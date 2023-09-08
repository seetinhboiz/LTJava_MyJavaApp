<%-- 
    Document   : index
    Created on : Jul 13, 2023, 2:56:06 p.m.
    Author     : Nghianek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center mt-2 text-info">GIẢNG VIÊN</h1>
    <div>
        <a href="<c:url value="/lectures"/>" class="btn btn-info mt-2">Thêm giảng viên</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Mã giảng viên</th>
                <th>Bằng cấp</th>
                <th>Tên giảng viên</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lecture}" var="lecture">
                <tr>
                    <td>
                        <img src="${lecture.avata}" alt="Ảnh" width="120"/>
                    </td>
                    <td>${lecture.id}</td>
                    <td>${lecture.degree}</td>
                    <td>${lecture.name}</td>
                    <td>
                        <c:url value="/lectures/${lecture.id}" var="update"/>
                        <c:url value="/api/lectures/${lecture.id}" var="api"/>
                        <a href="${update}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteLecture('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>