<jsp:useBean id="dto" scope="request" type="kroryi.w3.todo.dto.TodoDTO"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<h1>Todo Read</h1>
번호 : ${dto.tno} <br>
제목 : ${dto.title} <br>
작성 일자 : ${dto.dueDate} <br>
종료 여부 : ${dto.finished} <br>

<div>
    <a href="/todo/modify?tno=${dto.tno}">수정/삭제</a>
    <a href="/todo/list">목록보기</a>
</div>
</body>
</html>
