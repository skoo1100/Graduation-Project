package zx9.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;

import naver.NaverLoginBO;



@Controller
public class LoginController {
 
//kakao
 
    private final static String id = "bd58f9efb5e4c0637a9ddfa8c81a3920"; //kakao
    private final static String url ="http://192.168.56.1:8052/web/kakaoLogin.do"; //kakao
    
    @RequestMapping(value = "/login.do")//kakao
    public String loginview(Model model, HttpSession session) {
        String kakaoUrl ="https://kauth.kakao.com/oauth/authorize?"
        +"client_id="+id + "&redirect_uri="+url+"&response_type=code";
        model.addAttribute("kakaoUrl",kakaoUrl);
        return "redirect:/kakaoLogin.do";
    }
  
 
    public static JsonNode getAccessToken(String autorize_code){ //kakao
        final String RequestUrl = "https://kauth.kakao.com/oauth/token";
        final List<BasicNameValuePair> postParams = new ArrayList<BasicNameValuePair>();
        postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
        postParams.add(new BasicNameValuePair("client_id", id));    // REST API KEY
        postParams.add(new BasicNameValuePair("redirect_uri", url));    // 리다이렉트 URI
        postParams.add(new BasicNameValuePair("code", autorize_code));    // 로그인 과정중 얻은 code 값
        final HttpClient client = HttpClientBuilder.create().build();
        final HttpPost post = new HttpPost(RequestUrl);
        JsonNode returnNode = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(postParams));
            final HttpResponse response = client.execute(post);
            final int responseCode = response.getStatusLine().getStatusCode();
            System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
            System.out.println("Post parameters : " + postParams);
            System.out.println("Response Code : " + responseCode);
            
            //JSON 형태 반환값 처리
            ObjectMapper mapper = new ObjectMapper();
            returnNode = mapper.readTree(response.getEntity().getContent());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return returnNode;
    }
    
    public static JsonNode getKakaoUserInfo(String access_token) {//kakao
        final String RequestUrl = "https://kapi.kakao.com/v2/user/me";
        final HttpClient client = HttpClientBuilder.create().build();
        final HttpPost post = new HttpPost(RequestUrl);
         String accessToken = access_token;
         
        // add header
        post.addHeader("Authorization", "Bearer " + accessToken);
        JsonNode returnNode = null;
        try {
            final HttpResponse response = client.execute(post);
            final int responseCode = response.getStatusLine().getStatusCode();
            System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
            System.out.println("Response Code : " + responseCode);
 
            //JSON 형태 반환값 처리
            ObjectMapper mapper = new ObjectMapper();
            returnNode = mapper.readTree(response.getEntity().getContent());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
        }
        return returnNode;
 
    }
    @RequestMapping(value="/kakaoLogin.do",method=RequestMethod.GET)
    public String kakaologin( String code,HttpSession session)throws Exception{//kakao
        JsonNode jsonToken = getAccessToken(code);
        String access_token = jsonToken.get("access_token").toString();
        JsonNode userInfo = getKakaoUserInfo(access_token);
        String id = userInfo.get("id").toString();
        String nickName = userInfo.get("properties").get("nickname").toString();
        session.setAttribute("userid", nickName);
        System.out.println(id+nickName);
        return "redirect:index.do";
    }
    
    
    

    // 여기부터 네이버
    /* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/nlogin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(String id,Model model, HttpSession session) {
		
		System.out.println(id);
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		//session.invalidate();
		System.out.println("네이버:" + naverAuthUrl);
		//naverAuthUrl=naverAuthUrl.replaceAll("https", "http");
		//System.out.println(naverAuthUrl);
		//네이버 
		model.addAttribute("url", naverAuthUrl);
	
		/* 생성한 인증 URL을 View로 전달 */
		//return "redirect:"+naverAuthUrl;
		return "/register/login_naver";
	}
	@RequestMapping(value = "/nlogout.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(String id,Model model, HttpSession session,HttpServletRequest request) {
		
		session.invalidate();
	
		return "/register/logout_naver";
	}


	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session,HttpServletRequest request)
			throws IOException {
	//	 HttpSession sess=request.getSession();
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		System.out.println(code);
		System.out.println(state);

        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
	 //   System.out.println(apiResult.);
	    
	  //  sess.setAttribute("result", apiResult);
		model.addAttribute("result", apiResult);

        /* 네이버 로그인 성공 페이지 View 호출 */
		return "/register/naverSuccess";
	}

    
    
    
}