<%-- 
    Document   : lectures
    Created on : Aug 31, 2023, 12:01:36 a.m.
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ GIẢNG VIÊN</h1>
<c:url value="/lectures" var="action"/>
<form:form modelAttribute="lecture" method="post" action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id" />
    <form:hidden path="avata" />
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên giảng viên" name="name" />
        <label for="name">Tên giảng viên</label>
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
        <form:input type="text" class="form-control" path="degree" id="degree" placeholder="Bằng cấp" name="degree" />
        <label for="degree">Bằng cấp</label>
        <form:errors path="degree" element="div" cssClass="text-danger"/>
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
        <form:input type="text" class="form-control" path="idAccount" id="idAccount" placeholder="Gán tài khoản" name="idAccount" />
        <label for="idAccount">Gán tài khoản</label>
        <form:errors path="idAccount" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" placeholder="Ảnh giảng viên" name="file" />
        <label for="file">Ảnh giảng viên</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${lecture.id == null}">Thêm giảng viên</c:when>
                <c:otherwise>Cập nhật giảng viên</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>