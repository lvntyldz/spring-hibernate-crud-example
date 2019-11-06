<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<tiles:insertDefinition name="mainLayout">
    <tiles:putAttribute name="body">

        <h1>Person page !</h1>

        </br>
        <p>
            Person List..
        </p>
        </br>
        <hr/>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/person-add/Veli/YILDIZ/25/false">Add New
            Person</a>
        <hr/>

        <div class="panel panel-default">
            <div class="panel-heading"><b> First Record :</b> ${firstPerson}</div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading"><b> Record By Id Record :</b> ${personById}</div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading"><b> Last Record :</b> ${lastPerson}</div>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Age</th>
                <th>isStudent</th>
                <th>#</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${persons}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.lastName}</td>
                    <td>${p.age}</td>
                    <td>${p.student}</td>
                    <td>
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/delete-person/${p.id}">delete</a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/person-update/Ahmet/YILDIRIM/20/true/${p.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </tiles:putAttribute>
</tiles:insertDefinition>