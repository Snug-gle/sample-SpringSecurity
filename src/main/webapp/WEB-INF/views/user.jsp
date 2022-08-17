<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
 <c:choose>
    <c:when test="${empty(user) }">
        <div align="center">
        <h3>로그인이 필요합니다<h3>
        </div>
    </c:when>
    <c:otherwise>
        <div>
          <table>
              <thead>
                  <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>username</th>
                    <th>email</th>
                    <th>password</th>
                    <th>address</th>
                    <th>phone</th>
                    <th>website</th>
                    <th>company</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach var="user" items="${user}">
                  <tr>
                      <td>${user.id}</td>
                      <td>${user.name}</td>
                      <td>${user.username}</td>
                      <td>${user.email}</td>
                      <td>${user.password}</td>
                      <td>${user.address}</td>
                      <td>${user.phone}</td>
                      <td>${user.website}</td>
                      <td>${user.company}</td>
                  </tr>
                </c:forEach>
              </tbody>
          </table>
        </div>
    </c:otherwise>
 </c:choose>
    <div>
      <a href="<c:url value="/user/modify"/>">회원정보수정</a>
    </div>
    <div>
        <a href="<c:url value="/user/delete/${user.id}"/>">회원삭제</a>
    </div>
</body>
</html>