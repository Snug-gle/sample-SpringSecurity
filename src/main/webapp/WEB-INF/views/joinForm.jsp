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
 <h2>회원 가입 페이지</h2>
 <c:if test="${message != null}">
    <p style="color: red;">${message}</p>
 </c:if>
 <form id="signForm" action="<c:url value="/join"/>" method="post">
  <fieldset>
     <legend>필수입력</legend>
      <div>
        <label for="name">아이디</label>
        <input type="text" id="name" name="name" required placeholder="아이디를 입력하세요.">
      </div>
      <div>
        <label for="username">사용자이름(닉네임)</label>
        <input type="text" id="username" required name="username">
       </div>
      <div>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" required placeholder="이메일을 입력하세요.">
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required placeholder="비밀번호를 입력하세요">
      </div>
      <div>
        <label for="passwordConfirm">비밀번호 확인</label>
        <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호를 입력하세요">
        <p id="confirmMsg" style="color: red;"></p>
        <button type="button" id="confirmBtn" onclick="pwConfirm()">비빌번호 확인</button>
      </div>
      </fieldset>
      <fieldset>
        <legend>선택입력</legend>
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
      </div>
    </fieldset>
    <button type="submit">회원가입</button>
  </form>

  <script type="text/javascript">
    function pwConfirm() {
        var password = document.getElementById('password');
        var passwordConfirm = document.getElementById('passwordConfirm');
        var confirmMsg = document.getElementById('confirmMsg');

        if(password.value == passwordConfirm.value) {
            confirmMsg.innerHTML = " 비밀번호 일치";
        } else {
            confirmMsg.innerHTML = " 비밀번호 불일치";
        }
    }
  </script>
</body>
</html>