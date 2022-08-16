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
 <form id="signForm" action="<c:url value="/user"/>" method="post">
      <div>
          <label for="userId">아이디</label>
          <input type="text" id="userId" name="userId" class="form-control"  placeholder="아이디를 입력하세요">
      </div>
      <div>
        <label for="id">이름</label>
        <input type="text" id="id" name="id">
      </div>
      <div>
        <label for="username">사용자이름(닉네임)</label>
        <input type="text" id="username" name="username">
      </div>
      <div>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" placeholder="이메일을 입력하세요.">
      </div>
      <div>
          <label for="password">비밀번호</label>
          <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
      </div>
      <div>
        <label for="passwordConfirm">비밀번호 확인</label>
        <input type="password" id="passwordConfirm" name="password" placeholder="비밀번호를 입력하세요">
      </div>
      <div>
        <label for="address">주소</label>
        <input type="text" id="address" name="address" placeholder="주소를 입력하세요.">
      </div>
      <div>
        <label for="phone">전화번호</label>
        <input type="text" id="phone" name="phone" placeholder="전화번호를 입력하세요.">
      </div>
      <div>
        <label for="website">웹사이트</label>
        <input type="text" id="website" name="website" placeholder="웹사이트 주소를 입력하세요.">
      </div>
      <div>
        <label for="company">회사</label>
        <input type="text" id="company" name="company" placeholder="회사명을 입력하세요.">
      </div>
      <div>
          <button type="submit">회원가입</button>
      </div>
  </form>
</body>
</html>