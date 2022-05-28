<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Vector"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import ="org.json.simple.JSONArray" %>
<%@ page import ="org.json.simple.JSONObject" %>
<%@ page import ="org.json.simple.JSONValue" %>
<%@ page import ="org.json.simple.parser.JSONParser" %>

<%@ page import="kr.mjc.kwanghyun.web.common.*"%>
<%@ page import="kr.mjc.kwanghyun.web.dao.*"%>
<%@ page import="kr.mjc.kwanghyun.web.common.LocalValue" %>
<%@ page import="kr.mjc.kwanghyun.web.common.CommonUtil" %>

<% if (session.getAttribute("admin_id") == null || session.getAttribute("admin_id").equals("")) { %>

	<script language="javascript">
		alert("로그아웃 되었습니다. \n 로그인해 주시기 바랍니다.");
		location.href = "/";
	</script>

<% } %>

<%
	
LocalValue lv = new LocalValue();
CommonUtil CU = new CommonUtil();


String code = request.getParameter("code");
String client_id = "cdd6e8d7-e513-43ee-b450-0748736259b6";
String client_secret = "3dd36fb2-f589-4a37-bd3f-4582f7e585f8";
String redirect_uri = "http://localhost:8080/openbanking_token_default.do";
String grant_type = "authorization_code";

String params="code="+code+"&client_id="+client_id+"&client_secret="+client_secret+"&redirect_uri="+redirect_uri+"&grant_type="+grant_type+"";
String apiUrl = "https://testapi.openbanking.or.kr/oauth/2.0/token";
OpenbankingApi2 OA = new OpenbankingApi2();

JSONObject data_temp = new JSONObject();
String response_temp = OA.getJSONData2(apiUrl, params);
System.out.println(response_temp); 


JSONParser parser =  new JSONParser();
Object obj = parser.parse(response_temp);
data_temp = (JSONObject) obj;

String AF103_ACCESS_TOKEN  = (String)data_temp.get("access_token");
String AF103_REFRESH_TOKEN = (String)data_temp.get("refresh_token");
String AF103_TYPE          = (String)data_temp.get("token_type");
long AF103_EXPIRES          = (long)data_temp.get("expires_in");
String AF103_SCOPE         = (String)data_temp.get("scope");
String AF103_USER_SEQ      = (String)data_temp.get("user_seq_no");


//int AF100_IDX = (Integer)session.getAttribute("AF100_IDX");
//String AF103_AF100_IDX = String.valueOf(AF100_IDX);

//OpenbankingTokenDAO2 OTD = new OpenbankingTokenDAO2();

//HashMap<String, String>params2 = new HashMap<String, String>();
//params2.put("AF103_AF100_IDX", AF103_AF100_IDX);
//params2.put("AF103_ACCESS_TOKEN", AF103_ACCESS_TOKEN);
//params2.put("AF103_REFRESH_TOKEN", AF103_REFRESH_TOKEN);
//params2.put("AF103_TYPE", AF103_TYPE);
//params2.put("AF103_EXPIRES", String.valueOf(AF103_EXPIRES));
//params2.put("AF103_SCOPE", AF103_SCOPE);
//params2.put("AF103_USER_SEQ", AF103_USER_SEQ);

boolean flag = true;
//boolean flag = OTD.TokenInsert(params2);

%>

<%if(flag){ %>
	<script language="javascript">
		window.close();
	</script>
<%} %>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="/admin/scripts/sb_admin/vendor/jquery-easing/jquery.easing.min.js"></script>
		
<form name="tokenForm" id="tokenForm" method="post">
	<input type="hidden" name="code" id="code" value="<%=code%>">
	<input type="hidden" name="client_id" id="client_id" value="<%=client_id%>">
	<input type="hidden" name="client_secret" id="client_secret" value="<%=client_secret%>">
	<input type="hidden" name="redirect_uri" id="redirect_uri" value="<%=redirect_uri%>">
	<input type="hidden" name="grant_type" id="grant_type" value="<%=grant_type%>">
</form>


<script type="text/javascript"> 
	
	$(document).ready(function() {
		//send_token();

/*		
		var code = $("#code").val();
		var client_id = $("#client_id").val();
		var client_secret = $("#client_secret").val();
		var redirect_uri = $("#redirect_uri").val();
		var grant_type = $("#grant_type").val();
		var params = {code:code, client_id:client_id, client_secret:client_secret, redirect_uri:redirect_uri, grant_type:grant_type};
		
		$.post("https://testapi.openbanking.or.kr/oauth/2.0/token", params, function(data){
			console.log(data);
		})
*/


	});

	function send_token() {
		
		var params = jQuery("#tokenForm").serialize();

		$.ajax({
			url : "https://testapi.openbanking.or.kr/oauth/2.0/token",
			type : "post",
			timeout : 30000,
			cache : false,
			data : params,
			datatype : 'json',
			contentType: "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				console.log(JSON.stringify(data));
				alert("성공 값 : " + JSON.stringify(data));
			},
			error : function(data, status, error) {
				console.log(JSON.stringify(data));
				alert("통신데이터 값 : " + JSON.stringify(data));
			}
			
		});

	}

	function send_token2() {
		this.document.getElementById("tokenForm").action="https://testapi.openbanking.or.kr/oauth/2.0/token";
		this.document.getElementById("tokenForm").submit();		

	}

</script>

