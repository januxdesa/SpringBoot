<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<a href="/languages">DashBoard</a>
<h1><c:out value="${languages.name}"/></h1>
<p>Creator: <c:out value="${languages.creator}"/></p>
<p>CurrentVersion: <c:out value="${languages.currentVersion}"/></p>

<a href="/languages/${languages.id}/edit">Edit Languages</a>
<form action="/languages/${languages.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>