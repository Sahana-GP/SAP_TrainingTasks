<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>

<html>
<body>
<h2>Product Details</h2>

<div>
<p>${initialproduct.code}</p>
<p>${initialproduct.name}</p>
<p>${initialproduct.manufacturerName}</p>

<c:if test="${not empty initialproduct.comments}">
<p>${initialproduct.comments}</p>
</c:if>

<c:if test="${not empty initialproduct.averageRating}">
<p>${initialproduct.averagerating}</p>
</c:if>

</div>

<div style="color:#FF7F50">
<p>${compProd.code}</p>
<p>${compProd.name}</p>
<p>${compProd.manufacturerName}</p>

<c:if test="${not empty compProd.comments}">
<p>${compProd.comments}</p>
</c:if>

<c:if test="${not empty compProd.averageRating}">
<p>${compProd.averageRating}</p>
</c:if>

</div>

<form id="prodCompForm" action="">
<button type="submit" style="margin:20px; background-color:#FF8C00; font-size:20px; color; white">Back to Home</button>
</form>

</body></html>