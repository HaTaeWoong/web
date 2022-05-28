<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/mvc/top.jsp" %>

<%--부트스트랩 사용하기 위한 구문--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>샘플 홈페이지</title>

<div style="padding:10px;">
  <span style=" font-size:2em;  color: black;">구독목록(sample)</span>
</div>

<div class="row">

  <div class="col-xl-3 col-md-6 mb-4">
    <div class="card border-left-primary shadow h-100 py-2">
      <div class="card-body">
        <div class="row no-gutters align-items-center">
          <div class="col mr-2">
            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
              Netflix.com
            </div>
            <div class="h5 mb-0 font-weight-bold text-gray-800">₩9,500</div>
            <div class="small font-weight-bold">결제예정일</div>
            <div class="small font-weight-bold">2022년 5월 28일</div>
            <div class=""></div>
          </div>
          <div class="col-auto">
            <img src="넷플릭스.png" alt="My Image" width="100">
            <i class="fas fa-calendar fa-2x text-gray-300"></i>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-xl-3 col-md-6 mb-4">
    <div class="card border-left-primary shadow h-100 py-2">
      <div class="card-body">
        <div class="row no-gutters align-items-center">
          <div class="col mr-2">
            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
              Disneyplus.com
            </div>
            <div class="h5 mb-0 font-weight-bold text-gray-800">₩9,900</div>
            <div class="small font-weight-bold">결제예정일</div>
            <div class="small font-weight-bold">2022년 5월 15일</div>
          </div>
          <div class="col-auto">
            <img src="디즈니플러스.jpg" alt="My Image" width="100">
            <i class="fas fa-calendar fa-2x text-gray-300"></i>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-xl-3 col-md-6 mb-4">
    <div class="card border-left-primary shadow h-100 py-2">
      <div class="card-body">
        <div class="row no-gutters align-items-center">
          <div class="col mr-2">
            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
              watcha.com
            </div>
            <div class="h5 mb-0 font-weight-bold text-gray-800">₩7,900</div>
            <div class="small font-weight-bold">결제예정일</div>
            <div class="small font-weight-bold">2022년 5월 18일</div>
          </div>
          <div class="col-auto">
            <img src="왓챠.png" alt="My Image" width="100">
            <i class="fas fa-calendar fa-2x text-gray-300"></i>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-xl-3 col-md-6 mb-4">
    <div class="card border-left-primary shadow h-100 py-2">
      <div class="card-body">
        <div class="row no-gutters align-items-center">
          <div class="col mr-2">
            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
              tving.com
            </div>
            <div class="h5 mb-0 font-weight-bold text-gray-800">₩7,900</div>
            <div class="small font-weight-bold">결제예정일</div>
            <div class="small font-weight-bold">2022년 6월 7일</div>
          </div>
          <div class="col-auto">
            <img src="티빙.png" alt="My Image" width="100">
            <i class="fas fa-calendar fa-2x text-gray-300"></i>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-xl-3 col-md-6 mb-4">
    <div class="card border-left-primary shadow h-100 py-2">
      <div class="card-body">
        <div class="row no-gutters align-items-center">
          <div class="col mr-2">
            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
              coupangplay.com
            </div>
            <div class="h5 mb-0 font-weight-bold text-gray-800">₩4,990</div>
            <div class="small font-weight-bold">결제예정일</div>
            <div class="small font-weight-bold">2022년 6월 1일</div>
          </div>
          <div class="col-auto">
            <img src="쿠팡플레이.png" alt="My Image" width="100">
            <i class="fas fa-calendar fa-2x text-gray-300"></i>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>


<div style="padding:10px;">
  <span style=" font-size:2em;  color: black;">5월 총 결제금액</span>
</div>

<div style="padding:10px;">
  <nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
            <span class="navbar-text">
                <span style=" font-size:2em;  color: black;">₩27,300</span>
            </span>
    </div>
  </nav>
</div>