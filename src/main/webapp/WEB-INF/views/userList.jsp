<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
    margin-top: 60px;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 80px;
}
th, td {
    margin : 10px;
    padding: 10px;
    border: 1px solid black;

}
</style>
</head>
<body>
 <h2>사용자 목록 페이지</h2>
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
          <th>회원관리</th>
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
            <td><a href="<c:url value="/user/delete/${user.id}"/>">회원삭제</a></td>
        </tr>
      </c:forEach>
    </tbody>
</table>
</div>
<div>
<a href="<c:url value="/"/>">홈으로</a>
</div>
</body>
</html>