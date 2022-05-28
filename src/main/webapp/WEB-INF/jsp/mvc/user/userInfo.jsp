<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>회원정보</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>

<div style="padding:10px;">
    <span style=" font-size:2em;  color: black;">회원정보</span>
</div>


<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">가입된 이용자</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>회원번호</th>
                    <th>이메일</th>
                    <th>이름</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>