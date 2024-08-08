<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>
<h1>Todo Register</h1>
<form action="/todo/register" method="post">
    <div>
        <input type="text" name="title" placeholder="제목을 입력하세요">
    </div>
    <div>
        <label>
            날짜 : <input type="date" name="dueDate">
        </label>
    </div>
    <button type="submit">초기화</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
