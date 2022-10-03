<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 <h2>로그인</h2>
    <div>
        <form id="loginForm" action="/loginProcess" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
           <div>
               <label for="email">이메일</label>
               <input type="text" id="name" name="email" placeholder="이메일을 입력하세요">
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
    <div>
        <button onclick="location.href='<c:url value="/join"/>';">회원가입</button>
    </div>
    <c:if test="${message != null}">
        <p style="color: red;">${message}</p>
    </c:if>
</body>
</html>