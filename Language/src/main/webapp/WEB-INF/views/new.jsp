<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<h1>New Languages</h1>
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