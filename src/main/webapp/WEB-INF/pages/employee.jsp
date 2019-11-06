<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<tiles:insertDefinition name="mainLayout">
    <tiles:putAttribute name="body">

        <h1>Employee page !</h1>

        </br>
        <p>
            Employee List..
        </p>
        </br>
        <hr/>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/employee-add/Ali/YILDIRIM/25">Add New
            Employee(Ali)</a>

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/employee-add/Veli/YILDIZ/35">Add New
            Employee(Veli)</a>

        <a class="btn btn-info" href="${pageContext.request.contextPath}/employee-add/Ahmet/YILMAZ/45">Add New
            Employee(Ahmet)</a>
        <hr/>

        <div class="panel panel-default">
            <div class="panel-heading"><b> First Record :</b> ${firstEmployee}</div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading"><b> Record By Id Record :</b> ${employeeById}</div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading"><b> Last Record :</b> ${lastEmployee}</div>
        </div>




        <hr/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Age</th>
                <th>#</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${likeEmployees}" var="employe">
                <tr>
                    <td>${employe.id}</td>
                    <td>${employe.name}</td>
                    <td>${employe.lastName}</td>
                    <td>${employe.age}</td>
                    <td>
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/delete-employee/${employe.id}">delete</a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/employee-update/Ahmet/YILDIRIM/20/true/${employe.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <hr/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Age</th>
                <th>#</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.lastName}</td>
                    <td>${p.age}</td>
                    <td>
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/delete-employee/${p.id}">delete</a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/employee-update/Ahmet/YILDIRIM/20/true/${p.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </tiles:putAttribute>
</tiles:insertDefinition>
