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
 <h2>사용자 상세 페이지</h2>
 <div>
     <c:choose>
        <c:when test="${empty(user) }">
            <div align="center">
            <h3>회원 정보를 불러올수 없습니다.<h3>
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
                  </tbody>
              </table>
            </div>
        </c:otherwise>
     </c:choose>
 </div>
<div>
  <a href="<c:url value="/user/modify"/>">회원정보수정</a>
</div>
</body>
</html>