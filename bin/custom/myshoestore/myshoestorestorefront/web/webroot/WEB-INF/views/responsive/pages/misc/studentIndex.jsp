<%@ page trimDirectiveWhitespaces="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ page import="java.lang.*" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Create Student</title>
</head>
<body>
    <div style="padding-left:50px;font-family:monospace;">
            CRUD Operations</br></br>
        <a href="${pageContext.request.contextPath}/create.jsp"><div
                                style="color:saffron">Create Student</div></a></br></br>
        <a href="${pageContext.request.contextPath}/rest/userInfo"><div
                                style="color:saffron">Get Student details</div></a></br></br>
        <a href="${pageContext.request.contextPath}/update.jsp"><div
                                style="color:saffron">Update Student</div></a></br></br>
        <a href="${pageContext.request.contextPath}/delete.jsp"><div
                                style="color:saffron">Delete Student</div></a></br></br>
    </div>
</body>
</html>