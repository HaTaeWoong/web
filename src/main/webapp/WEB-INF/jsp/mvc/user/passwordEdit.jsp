<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>비밀번호 변경</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>


<form action="./mvc/user/updatePassword" method="post">
    <div class="row text-center" style="width: 100%">
        <div style="width: 30%; float:none; margin:0 auto">
            <div style="padding:10px;">
                <div class="card-header">
                    <div class="navbar-brand" ;>비밀번호 변경</div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <p><input type="password" name="currentPassword" placeholder="현재 비밀번호"
                                      required autofocus/></p>
                            <p><input type="password" name="newPassword" placeholder="새 비밀번호"
                                      required/>
                            </p>
                            <p>
                                <button type="submit">저장</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>