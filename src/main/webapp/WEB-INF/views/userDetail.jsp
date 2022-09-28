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
    margin: 60px auto 80px;
}
th, td {
    margin : 10px;
    padding: 10px;
    border: 1px solid black;
}
</style>
    <title></title>
</head>
<body>
 <h2>사용자 상세 페이지</h2>
 <div>
     <c:choose>
        <c:when test="${empty(user) }">
            <div>
            <h3>회원 정보를 불러올수 없습니다.</h3>
            </div>
        </c:when>
        <c:otherwise>
            <div>
              <table>
                  <thead>
                      <tr>
                        <th>이메일</th>
                        <th>별칭</th>
                        <th>주소</th>
                        <th>휴대폰</th>
                        <th>웹사이트</th>
                        <th>회사</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>${user.email}</td>
                          <td>${user.username}</td>
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
<div>
  <a href="<c:url value="/logout"/>">로그아웃</a>
</div>
</body>
</html>