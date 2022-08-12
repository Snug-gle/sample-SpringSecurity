<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
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
          <C:forEach var="user" items="${userList}">
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
          </C:forEach>
        </tbody>
    </table>
  </div>
</body>
</html>