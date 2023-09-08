<%-- 
    Document   : subjectManagement
    Created on : Sept 2, 2023, 2:15:07 p.m.
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-2">QUẢN LÝ MÔN HỌC</h1>
<c:url value="/subject/subjectManagement" var="action"/>
<form:form modelAttribute="subject" method="post" action="${action}">
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="name" placeholder="Tên môn học" name="name" path="name"/>
        <label for="name">Tên môn học</label>
        <form:errors path="name" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" id="credit" placeholder="Số tín chỉ" name="credit" path="credit"/>
        <label for="credit">Số tín chỉ</label>
        <form:errors path="credit" element="div" cssClass="text-danger"/>
    </div>
    <button class="btn btn-info" type="submit">
        <c:choose>
            <c:when test="${subject.id == null}">Thêm môn học</c:when>
            <c:otherwise>Cập nhật môn học</c:otherwise>
        </c:choose>
    </button>
</form:form>