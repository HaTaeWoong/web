<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>구독목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>

<div style="padding:10px;">
    <span style=" font-size:2em;  color: black;">구독목록</span>
</div>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            <c:if test="${empty sessionScope.ME}">
                <div><a href="./mvc/user/signinForm?redirectUrl=/demo/mvc/subscribe/addSubscribe">추가</a></div>
            </c:if>
            <c:if test="${!empty sessionScope.ME}">
                <div><a href="./mvc/subscribe/addSubscribe">추가</a></div>
            </c:if>
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>구독명</th>
                    <th>금액</th>
                    <th>결제 예정일자</th>
                </tr>
                </thead>
                <%--<tfoot>
                <tr>
                    <th>구독명</th>
                    <th>금액</th>
                    <th>결제 예정일자</th>
                </tr>
                </tfoot>--%>
                <tbody>
                <c:forEach var="subscribe" items="${subscribeList}">
                    <tr>
                        <td>${subscribe.name}</td>
                        <td>${subscribe.price}원</td>
                        <td>${subscribe.pdate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>