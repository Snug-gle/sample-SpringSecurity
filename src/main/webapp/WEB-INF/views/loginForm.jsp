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
 <h2>로그인 페이지</h2>
    <div>
        <form id="loginForm" action="<c:url value="/login"/>" method="post">
           <div>
               <label for="name">아이디</label>
               <input type="text" id="name" name="name" placeholder="아이디를 입력하세요">
           </div>
           <div>
               <label for="password">비밀번호</label>
               <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
           </div>
           <div>
               <button type="submit" >로그인</button>
           </div>
        </form>
    </div>
        <a href="<c:url value="/join"/>">회원가입</a>
    <c:if test="${message != null}">
        <p style="color: red;">${message}</p>
    </c:if>
</body>
</html>