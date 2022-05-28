<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--부트스트랩 사용하기 위한 구문--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
    <style>
        input[name=redirectUrl] {
            width: 600px;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="navbar-brand" ;>로그인</div>
</nav>


<form action="./mvc/user/signin" method="post">
    <div class="row text-center" style="width: 100%">
        <div style="width: 30%; float:none; margin:0 auto">
            <div style="padding:10px;">
                <div class="card-header">
                    <div class="navbar-brand" ;>로그인</div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <p><input type="email" name="email" placeholder="이메일" required autofocus/>
                            </p>
                            <p><input type="password" name="password" placeholder="비밀번호" required/></p>
                            <p>
                                <button type="submit">로그인</button>
                            </p>
                        </div>
                    </div>
                </div>


                <c:choose>
                    <c:when test="${!empty param.redirectUrl}">
                        <input type="hidden" name="redirectUrl" value="${param.redirectUrl}"/>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="redirectUrl" value="${header.referer}" readonly/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</form>
</body>
</html>