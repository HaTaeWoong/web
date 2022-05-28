<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>
<div style="padding:10px;">
    <span style=" font-size:2em;  color: black;">게시글</span>
</div>
<c:set var="now_userId" scope="session" value="${sessionScope.ME.userId}"/><%--변수설정--%>

<div class="card mb-4">
    <div class="card-header">
        <a>${article.title}</a>
        <c:if test="${now_userId == article.userId}">

            <div style="float: right">
                    <%--수정버튼--%>
                <a href="./mvc/article/articleEdit?articleId=${article.articleId}"
                   class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                    <span class="text">수정</span>
                </a>

                    <%--삭제버튼--%>
                <a id="btnDel" href="./mvc/article/deleteArticle?articleId=${article.articleId}"
                   class="btn btn-danger btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-trash"></i>
                                        </span>
                    <span class="text">삭제</span>
                </a>
            </div>
        </c:if>
    </div>
    <div class="card-body">
        <p>${article.content}</p>
    </div>


    <div style="padding:10px;">
        <p><a href="./mvc/user/userInfo?userId=${article.userId}">${article.name}</a>
            | ${article.udate}</p>
    </div>
</div>

<script>
    document.querySelector("#btnDel").onclick = function () {
        return confirm("삭제하시겠습니까?");
    };
</script>
</body>
</html>