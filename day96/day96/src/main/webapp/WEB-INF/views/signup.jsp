<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>회원가입 페이지</title>
   </head>
   <body>
      <form action="signup" method="post">
         ID <input type="text" name="memberId" placeholder="아이디 입력" required>
         PW <input type="password" name="memberPw" placeholer="비밀번호 입력" required>
         <input type="submit" value="회원가입">
      </form>
      <br><br>
      <a href="/">메인으로 돌아가기</a>
   </body>
</html>