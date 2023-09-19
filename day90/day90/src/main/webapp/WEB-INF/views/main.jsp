<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>메인페이지</title>
   </head>
   <body>
      <c:if test="${ empty sessionMemberId }">
         <form action="login" method="post">
            ID <input type="text" name="memberId" placeholder="아이디 입력" required> &nbsp;
            PW <input type="password" name="memberPw" placeholer="비밀번호 입력" required>
            <input type="submit" value="로그인">
         </form><br>
         <a href="signup">회원가입</a>
      </c:if>

      <c:if test="${ not empty sessionMemberId }">
         <p>${ sessionMemberId }님 환영합니다:D</p>
         <a href="mypage">마이페이지</a> &nbsp;
         <a href="logout">로그아웃</a><br><br>
         <form action="insertBoard" method="post">
            <input type="hidden" name="memberId" value="${ sessionMemberId }">
            글 내용 <input type="text" name="content" placeholder="글 내용 작성">
            <input type="submit" value="글 작성">
         </form>
      </c:if>
      
      <br><hr><br>

      <table border="1px">
         <tr>
            <th>글 번호</th>
            <th>작성자</th>
         </tr>
         <c:forEach var="board" items="${ boardDatas }">
            <tr>
               <td>
                  <a href="board?boardId=${ board.boardId }">${ board.boardId }</a>
               </td>
               <td>${ board.memberId }</td>
            </tr>
         </c:forEach>
      </table>
        
   </body>
</html>