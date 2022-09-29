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
     <form id="modifyForm" name="modifyForm" action="<c:url value="/user/modify"/>" method="post" >
          <div>
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
             <input type="hidden" name="id" value="${user.id}">
             <input type="hidden" name="name" value="${user.name}">
           </div>
          <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" value="${user.email}" readonly>
          </div>
          <div>
            <label for="name">실명</label>
            <input type="text" id="username" name="username" value="${user.name}" required>
            </div>
          <div>
            <label for="username">별칭</label>
            <input type="text" id="username" name="username" value="${user.username}" required>
          </div>
          <div>
              <label for="password">비밀번호</label>
              <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
          </div>
          <div>
            <label for="passwordConfirm">비밀번호 확인</label>
            <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호를 입력하세요">
            <p id="confirmMsg" style="color: red;"></p>
          </div>
          <div>
            <label for="address">주소</label>
            <input type="text" id="address" name="address" value="${user.address}" placeholder="주소를 입력하세요.">
          </div>
          <div>
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" value="${user.phone}" placeholder="전화번호를 입력하세요.">
          </div>
          <div>
            <label for="website">웹사이트</label>
            <input type="text" id="website" name="website" value="${user.website}" placeholder="웹사이트 주소를 입력하세요.">
          </div>
          <div>
            <label for="company">회사</label>
            <input type="text" id="company" name="company" value="${user.company}" placeholder="회사명을 입력하세요.">
          </div>
          <div>
              <button type="button" onclick="pwConfirm()">회원정보수정</button>
          </div>
      </form>
  </div>
  <c:if test="${message != null}">
      <p style="color: red;">${message}</p>
   </c:if>
  <script type="text/javascript">
    function pwConfirm() {
            var modifyForm = document.modifyForm;
            var password = document.getElementById('password');
            var passwordConfirm = document.getElementById('passwordConfirm');

            if ((password.value == "") || (passwordConfirm.value == "")) {
                confirmMsg.innerHTML = " 비밀번호를 입력하세요";
                return false;
            } else if (password.value != passwordConfirm.value) {
                confirmMsg.innerHTML = " 비밀번호 불일치";
                return false;
            } else {
                modifyForm.submit();
            }
        }
  </script>
</body>
</html>