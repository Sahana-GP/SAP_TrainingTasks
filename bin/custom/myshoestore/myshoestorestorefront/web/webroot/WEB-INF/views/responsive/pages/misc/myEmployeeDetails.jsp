<%@ page trimDirectiveWhitespaces="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.lang.*" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<template:page pageTitle="${pageTitle}">
<c:if test="${not empty  myEmployeeData}">
<table>
<tr>
   <th><spring:theme code="myemployee.empid"/></th>
   <th><spring:theme code="myemployee.name"/></th>
   <th><spring:theme code="myemployee.salary"/></th>
   <th><spring:theme code="myemployee.employeeWorkType"/></th>
   <th><spring:theme code="myemployee.employee_company_age"/></th>
</tr>
<c:forEach items="${myEmployeeData}" var="myEmployeeData">
<tr>
<td>${myEmployeeData.empid}</td>
<td>${myEmployeeData.name}</td>
<td>${myEmployeeData.salary}</td>
<td>${myEmployeeData.employeeWorkType}</td>
<td>${myEmployeeData.employee_company_age}</td>
</tr>
</c:forEach>
</table>
</c:if>
</template:page>
