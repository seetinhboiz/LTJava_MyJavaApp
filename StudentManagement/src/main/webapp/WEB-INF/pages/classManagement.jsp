<%-- 
    Document   : classManagement
    Created on : Sept 9, 2023, 10:04:17 p.m.
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-2">QUẢN LÝ MÔN HỌC</h1>
<c:url value="/class/classManagement" var="action"/>
<form:form modelAttribute="_class" method="post" action="${action}">
    <form:hidden path="id" />
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="idLecture" name="idLecture" path="idLecture">
            <c:forEach items="${lectures}" var="lecture">
                <c:choose>
                    <c:when test="${_class.idLecture.id == lecture.id}">
                        <option value="lecture.id" selected>${lecture.id} - ${lecture.degree} - ${lecture.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${lecture.id}">${lecture.id} - ${lecture.degree} - ${lecture.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="idLecture" class="form-label">Gán giảng viên:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="idSubject" name="idSubject" path="idSubject">
            <c:forEach items="${subjects}" var="subject">
                <c:choose>
                    <c:when test="${_class.idSubject.id == subject.id}">
                        <option value="subject.id" selected>${subject.id} - ${subject.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${subject.id}">${subject.id} - ${subject.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="idSubject" class="form-label">Gán môn học:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="quantityStudent" placeholder="Số sinh viên" name="quantityStudent" path="quantityStudent"/>
        <label for="quantityStudent">Số sinh viên</label>
    </div>
    <button class="btn btn-info" type="submit">
        <c:choose>
            <c:when test="${_class.id == null}">Thêm lớp học</c:when>
            <c:otherwise>Cập nhật lớp học</c:otherwise>
        </c:choose>
    </button>
</form:form>