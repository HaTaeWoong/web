<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--부트스트랩 사용하기 위한 구문--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand"; href="./index.jsp">홈</a>
    <a class="navbar-brand"; href="./mvc/subscribe/subscribeList?count=20&page=1">구독목록</a>
    <a class="navbar-brand"; href="./mvc/article/articleList?count=20&page=1">공지사항</a>
    <c:if test="${empty sessionScope.ME}">
        <a class="navbar-brand"; href="./mvc/user/signinForm">로그인</a>
        <a class="navbar-brand"; href="./mvc/user/signupForm">회원가입</a>
        <a class="navbar-brand"; href="./mvc/Openbanking/openbanking_token_default">오픈뱅킹</a>
    </c:if>
    <c:if test="${!empty sessionScope.ME}">
        <a class="navbar-brand"; href="./mvc/user/myInfo">${sessionScope.ME.name}님</a>
        <a class="navbar-brand"; href="./mvc/user/signout">로그아웃</a>
    </c:if>
    <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>

<script language="javascript">

    function send_menu(strUrl){
        var allParams = {};

        $.ajax({
            type : "post",
            url : strUrl,
            timeout : 30000,
            cache : false,
            data : allParams,
            datatype : 'html',
            success : function(data) {
                $("#main_contents").html(data);
            },
            error : function(data, status, error) {
                alert("통신데이터 값 : " + data);
                $("#main_contents").html(data);
            }
        });
    }
    //오픈뱅킹 사용자 인증
    function send_token() {

        var tmpWindow = window.open('about:blank')
        tmpWindow.location = "https://openapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num" +
            "response_type=code&" +
            "client_id=def6ca0c-0bb7-4fd4-adb8-ce1663976fae" + //
            "redirect_uri=http://localhost:8080/openbanking_token_default.do&" +
            //"redirect_uri=http://localhost:8080/openbanking_token_default.do&"+
            "scope=login inquiry transfer&" +
            "client_info=kkh&" +
            "state=12345678901234567890123456789012&" +
            "auth_type=0"
    }
</script>