<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>비밀번호변경</title>
   </head>
   <body>
      <form action="updatePw" method="post">
         ID <input type="text" name="memberId" value="${ sessionMemberId }" readonly> <br>
         PW <input type="password" name="memberPw" placeholer="변경할 비밀번호 입력" required>
         <input type="submit" value="비밀번호 변경">
      </form>
      <form action="deleteMember" method="post">
         <input type="hidden" name="memberId" value="${ sessionMemberId }"> <br>
         <input type="submit" value="회원탈퇴">
      </form>
      <br><br>
      <a href="/">메인으로 돌아가기</a>
   </body>
</html>