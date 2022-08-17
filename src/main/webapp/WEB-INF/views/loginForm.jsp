<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <form id="loginForm" action="<c:url value="/user"/>" method="post">
       <div>
           <label for="name">아이디</label>
           <input type="text" id="name" name="name" placeholder="아이디를 입력하세요">
       </div>
       <div>
           <label for="password">비밀번호</label>
           <input type="password" id="userPw" name="password" placeholder="비밀번호를 입력하세요">
       </div>
       <div>
           <button type="submit" >로그인</button>
       </div>
    </form>
           <a href="<c:url value="/signup"/>">회원가입</a>
</body>
</html>