<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>구독물 추가</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>

<div class="row text-center" style="width: 100%">
    <div style="width: 30%; float:none; margin:0 auto">
        <div style="padding:10px;">
            <div class="card-header">
                <div class="navbar-brand" ;>회원가입</div>
                <div class="card mb-4">
                    <div class="card-body">
                        <p><input type="text" name="subId" placeholder="구독명" required autofocus/>
                        </p>
                        <p><input type="text" name="price" placeholder="금액" required/>
                        </p>
                        <p><input type="date" name="pdate" placeholder="결제 예정일자" required/></p>
                        <p>
                            <button type="submit">등록</button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</div>

</body>
</html>
