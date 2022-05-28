package kr.mjc.kwanghyun.web.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class OpenbankingApi2 {
	
	private static final String INC_CP_CLIENTKEY = "";
	
	private final static String PROXY_IP = "175.123.253.51";
	private final static int PROXY_PORT = 5112;
	private final static String USER_AGENT = "Mozilla/5.0";
	
	
	/**
	 * 오픈뱅킹 사용자 인증
	 * @param code
	 * @return
	 * @throws Exception
	 */
    public static String getOpenbankingToken(String code) throws Exception{

    	
		String client_id = "cdd6e8d7-e513-43ee-b450-0748736259b6";
		String client_secret = "3dd36fb2-f589-4a37-bd3f-4582f7e585f8";
//		String redirect_uri = "http://intopia.pacific9.co.kr/openbanking_token_default.do";
		String redirect_uri = "http://localhost:8080/openbanking_token_default.do";
		String grant_type = "authorization_code";

    	/* 변수들 입력 */
    	String params = "";
//    	params+="?code="+code;
//    	params+="&client_id="+client_id;
//    	params+="&client_secret="+client_secret;
//    	params+="&redirect_uri="+redirect_uri;
//    	params+="&grant_type="+grant_type;
    	
    	
    	String author_url = "https://testapi.openbanking.or.kr/v2.0/token";
    	params = "code="+code+"&client_id="+client_id+"&client_secret="+client_secret+"&redirect_uri="+redirect_uri+"&grant_type="+grant_type;
    	String strResult = getJSONData2(author_url, params);
        System.out.println(author_url);
        System.out.println(params);
        System.out.println(strResult);
        
        return strResult;
    }

    
    /**
	 * HTTP 프록시 생성
	 * 
	 * @param ip
	 * @param port
	 * @return
	 */
	public static Proxy initProxy(String ip, int port) {
		return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
	}

	
	/**
     * 사용자 인증(토큰받기)
     * @param apiUrl
     * @param params
     * @return
     * @throws Exception
     */
    public static String getJSONData2(String apiUrl, String params) throws Exception {
    	
        String jsonString = new String();

		URL url = new URL(apiUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("POST"); // optional default is GET
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("X-Requested-With", "curl");
		con.setDoOutput(true); // POST 파라미터 전달을 위한 설정

		// Send post request
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(params);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }

    /**
     * 은행 계좌 리스트 가져오기
     * @param apiUrl
     * @param arg1
     * @return
     * @throws Exception
     */
    public static String getJSONDataAccountList(String apiUrl, String arg1) throws Exception {
    	
        String jsonString = new String();
        String header = "Bearer " + arg1;
        
		URL url = new URL(apiUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
		con.setRequestProperty("Authorization", header);
//		con.setRequestProperty("X-Requested-With", "curl");
		
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Authorization : " + header);
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }
    
    
    /**
     * 잔액조회
     * @param apiUrl
     * @param arg1
     * @return
     * @throws Exception
     */
    public static String getJSONDataBalance(String apiUrl, String arg1) throws Exception {
    	
        String jsonString = new String();
        String header = "Bearer " + arg1;
        
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
		con.setRequestProperty("Authorization", header);
//		con.setRequestProperty("X-Requested-With", "curl");
		
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Authorization : " + header);
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }

    
    /**
     * 계좌 거래 리스트 가져오기
     * @param apiUrl
     * @param arg1
     * @return
     * @throws Exception
     */
    public static String getJSONDataTransaction(String apiUrl, String arg1) throws Exception {
    	
        String jsonString = new String();
        String header = "Bearer " + arg1;
        
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
		con.setRequestProperty("Authorization", header);
//		con.setRequestProperty("X-Requested-With", "curl");
		
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Authorization : " + header);
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }

    
    /**
     * 계좌 거래 리스트 가져오기
     * @param apiUrl
     * @param arg1
     * @return
     * @throws Exception
     */
    public static String getJSONDataProxyTransaction(String apiUrl, String arg1) throws Exception {
    	
        String jsonString = new String();
        String header = "Bearer " + arg1;
        
        Proxy proxy = initProxy(PROXY_IP, PROXY_PORT);
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection(proxy);

		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
		con.setRequestProperty("Authorization", header);
//		con.setRequestProperty("X-Requested-With", "curl");
		
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Authorization : " + header);
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }

    
    /**
     * 계좌 해지
     * @param apiUrl
     * @param arg1
     * @return
     * @throws Exception
     */
    public static String getJSONDataCancel(String apiUrl, String arg1) throws Exception {
    	
        String jsonString = new String();
        String header = "Bearer " + arg1;
        
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Charset", "UTF-8"); // add request header
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header
		con.setRequestProperty("Authorization", header);
//		con.setRequestProperty("X-Requested-With", "curl");
		
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Authorization : " + header);
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
		
		jsonString = response.toString();
				
        return jsonString;
        
    }

    
    /**
     * 일반적인 RestfulAPI JSON Data 가져오기
     * @param apiUrl
     * @return
     * @throws Exception
     */
    public String getJSONData(String apiUrl) throws Exception {
    	
        String jsonString = new String();
        String buf;
        URL url = new URL(apiUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        String header = INC_CP_CLIENTKEY;
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-Requested-With", "curl");
        conn.setRequestProperty("INC_CP_CLIENTKEY", INC_CP_CLIENTKEY);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        while ((buf = br.readLine()) != null) {
            jsonString += buf;
        }
        System.out.println(jsonString);
        return jsonString;
    }
    

    
    public static void NaverPost(String code) throws Exception {

		String client_id = "cdd6e8d7-e513-43ee-b450-0748736259b6";
		String client_secret = "3dd36fb2-f589-4a37-bd3f-4582f7e585f8";
		String redirect_uri = "http://localhost:8080/openbanking_token_default.do";
		String grant_type = "authorization_code";
    	
        String apiURL = "https://testapi.openbanking.or.kr/v2.0/token";
        
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        
        // post request
    	String postParams = "code="+code+"&client_id="+client_id+"&client_secret="+client_secret+"&redirect_uri="+redirect_uri+"&grant_type="+grant_type;
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        BufferedReader br;
        if(responseCode==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();
        System.out.println(response.toString());
    }    

}
