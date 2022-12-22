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
<h2>Compare Products</h2>
<c:if test="${not empty productList }">
<c:forEach var = "product" items = "${productList}">
<c:if test="${not (product.code eq compProd.code)}">
<c:url value="/compare/product/details?ID=${product.code}" var="productCompUrl"/>
<div>
<a href = "${productCompUrl}">
<div class ="carousel__item--name">${fn:escapeXml(product.name)}</div>
</a>
</div>
<br><br>
</c:if>
</c:forEach>
</c:if>
</body>
</html>
