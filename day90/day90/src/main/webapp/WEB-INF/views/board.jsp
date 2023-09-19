<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>글 상세 페이지</title>
   </head>
   <body>
      <c:if test="${ sessionMemberId eq boardData.memberId }">
         <form action="updateBoard" method="post">
            <input type="hidden" name="boardId" value="${ boardData.boardId }">
            작성자 <input type="text" name="memberId" value="${ boardData.memberId }" readonly><br>
            글내용 <input type="text" name="content" value="${ boardData.content }" required>
            <input type="submit" value="글 수정">
         </form>
         <form action="deleteBoard" method="post">
            <input type="hidden" name="boardId" value="${ boardData.boardId }"><br>
            <input type="submit" value="글 삭제">
         </form>
      </c:if>
      <c:if test="${ sessionMemberId ne boardData.memberId }">
         작성자 <input type="text" name="memberId" value="${ boardData.memberId }" readonly><br>
         글내용 <input type="text" name="content" value="${ boardData.content }" required>
      </c:if>
      <br><br>
      <a href="/">메인으로 돌아가기</a>
   </body>
</html>