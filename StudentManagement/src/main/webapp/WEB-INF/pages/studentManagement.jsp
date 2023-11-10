<%-- 
    Document   : studentManagement
    Created on : Sept 9, 2023, 1:08:12 a.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ SINH VIÊN</h1>
<c:url value="/student/studentManagement" var="action"/>
<form:form modelAttribute="student" method="post" action="${action}" enctype="multipart/form-data">
    <form:hidden path="id" />
    <form:hidden path="avata" />
    <form:errors path="*" element="div" cssClass="text-danger"/>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên sinh viên" name="name" />
        <label for="name">Tên sinh viên</label>
        <form:errors path="name" element="div" cssClass="text-danger"/>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="phone" id="phone" placeholder="Số điện thoại" name="phone" />
        <label for="phone">Số điện thoại</label>    
        <form:errors path="phone" element="div" cssClass="text-danger"/>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="address" id="address" placeholder="Địa chỉ" name="address" />
        <label for="address">Địa chỉ</label>
        <form:errors path="address" element="div" cssClass="text-danger"/>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control" path="birth" id="birth" placeholder="Ngày sinh" name="birth" />
        <label for="birth">Ngày sinh</label>
        <form:errors path="birth" element="div" cssClass="text-danger"/>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" name="email" />
        <label for="email">Email</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" placeholder="Ảnh giảng viên" name="file" />
        <label for="file">Ảnh sinh viên</label>
        <form:errors path="avata" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${student.id == null}">Thêm sinh viên</c:when>
                <c:otherwise>Cập nhật sinh viên</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>