<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
 <h2>안녕하세요</h2>
    <security:authorize access="isAnonymous()">
    <div>
        <button onclick="location.href='<c:url value="/login"/>';">로그인</button>
    </div>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
    <div>
     <form action="/logout" method="post">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
         <input type="submit" value="로그아웃">
     </form>
    </security:authorize>
    </div>
</body>
</html>