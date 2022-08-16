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
           <label for="userId">아이디</label>
           <input type="text" id="userId" name="userId" class="form-control"  placeholder="아이디를 입력하세요">
       </div>
       <div>
           <label for="userPw">비밀번호</label>
           <input type="password" id="userPw" name="userPw" placeholder="비밀번호를 입력하세요">
       </div>
       <div>
           <button type="submit" >로그인</button>
       </div>
    </form>
           <a href="<c:url value="/user/signup"/>">회원가입</a>
</body>
</html>