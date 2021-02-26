<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<h1>All Languages</h1>
<table>
    <thead>
        <tr>
        	<th>Id</th>
            <th>Name</th>
            <th>Creator</th>
            <th>CurrentVersion</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lang}" var="language">
        <tr>
        
        
        	 <td><c:out value="${language.creator}"/></td>
            <td><a href="languages/${language.id}" > <c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
        
            <td><a href="/languages/${language.id}/edit">Edit</a></td>
            <td><a href="/languages/${language.id}/delete">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/languages/new">New Language</a>


<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">CurrentVersion</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>  