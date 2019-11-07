<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<tiles:insertDefinition name="mainLayout">
    <tiles:putAttribute name="body">

        <h1>Post page !</h1>

        </br>
        <p>
            Post List..
        </p>
        </br>
        <hr/>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/post-add">Add New
            Post</a>

        <hr/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>title</th>
                <th>comment</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.title}</td>
                    <td>${p.comments}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </tiles:putAttribute>
</tiles:insertDefinition>
