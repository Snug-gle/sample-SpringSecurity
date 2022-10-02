<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<body>
 <h2>환영합니다</h2>
    <div>
        <a href="<c:url value="/user/userDetail"/>">내 정보 보기</a>
    </div>
    <div>
        <a href="<c:url value="/admin/userList"/>">전체 회원 정보 보기</a>
    </div>
    <div>
        <a href="#" onclick="document.getElementById('logout').submit();">로그 아웃</a>
    </div>
    <form id="logout" action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>
</html>