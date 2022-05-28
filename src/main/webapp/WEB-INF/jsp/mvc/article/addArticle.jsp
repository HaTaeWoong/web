<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>글쓰기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
    <style>
        form input {
            width: 100%;
        }

        form textarea {
            width: 100%;
            height: 200px;
        }
    </style>
</head>

<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>


<body>
<div style="padding:10px;">
    <span style=" font-size:2em;  color: black;">글쓰기</span>
</div>

<form action="./mvc/article/addArticle" method="post">
    <div class="card mb-4">
        <div class="card-header">
            <p><input type="text" name="title" placeholder="제목" required autofocus/>
            </p>
        </div>
        <div class="card-body">
            <p><textarea name="content" required></textarea></p>
        </div>

        <div style="padding:10px;">
            <button type="submit">등록</button>
        </div>
    </div>
</form>
</body>
</html>