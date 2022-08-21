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
 <h2>사용자 수정 페이지</h2>
 <div>
     <form id="signForm" action="<c:url value="/user"/>" method="post">
          <div>
            <label for="username">사용자이름(닉네임)</label>
            <input type="text" id="username" name="username">
          </div>
          <div>
              <label for="password">비밀번호</label>
              <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
          </div>
          <div>
            <label for="passwordConfirm">비밀번호 확인</label>
            <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호를 입력하세요">
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
              <button type="submit">회원정보수정</button>
          </div>
      </form>
  </div>
</body>
</html>