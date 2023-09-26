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
      <a href="deleteMembercheck">회원탈퇴</a>
   </body>
</html>