<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertAttribute name="header"/>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/static/css/sticky-footer-navbar.css" rel="stylesheet">

<tiles:insertAttribute name="menu"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footer"/>