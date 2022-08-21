<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
 <h2>HOME</h2>
  <c:choose>
    <c:when test="${user.id == null}">
        <a href="<c:url value="/login"/>">로그인 하러가기</a>
    </c:when>
    <c:when test="${user.id != null}">
        <a href="<c:url value="/logout"/>">로그아웃</a>
    </c:when>
  </c:choose>
  <c:if test="${user.grade eq 9}">
      <div>
        <a href="<c:url value="/userList"/>">회원 관리 페이지</a>
      </div>
  </c:if>
</body>
</html>