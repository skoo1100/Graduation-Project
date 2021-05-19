package zx9.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensorflow.Graph;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import com.github.scribejava.core.model.OAuth2AccessToken;

import pwchange.bouncy_change;
import zx9.web.dao.IndeedDao;
import zx9.web.dao.JobkoDao;
import zx9.web.dao.SaramDao;
import zx9.web.dao.UserDao;
import zx9.web.vo.UserVO;
import zx9.web.vo.jobVO;
@Controller
public class HomeController {

	
	
	@Autowired
	UserDao udao;	
	@Autowired
	JobkoDao jkdao;
	@Autowired
	SaramDao sdao;
	@Autowired
	IndeedDao idao;
	
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/index.do")
	public String home(Model m) {
		ArrayList<ArrayList<String>> ranking;

		ranking=jkdao.getRank();
		ArrayList<ArrayList<String>> news;
		news=jkdao.getNews();
	

		
		m.addAttribute("ranking",ranking);
		
		m.addAttribute("news",news);

		return "/template/index";
	}

	@RequestMapping("/search.do")
	public String search(Model m,String searchvalue,String sitetype,String location,String jobtype,String pay) {
		//searchvalue/sitetype/location/jobtype/pay

		ArrayList<jobVO> jvo = null;
		String baseurl;
		
		switch(sitetype) {
		case "Job-korea":
		
			switch(location) {
			case "서울":
				location="&local=I000";
				break;
			case "인천":
				location="&local=K000";
				break;
			case "경기":
				location="&local=B000";
				break;
			case "부산":
				location="&local=H000";
				break;
			case "대구":
				location="&local=F000";
				break;
			case "광주":
				location="&local=E000";
				break;
			case "대전":
				location="&local=G000";
				break;
			case "울산":
				location="&local=J000";
				break;
			case "세종":
				location="&local=1000";
				break;
			case "강원":
				location="&local=A000";
				break;
			case "경남":
				location="&local=C000";
				break;
			case "경북":
				location="&local=D000";
				break;
			case "전남":
				location="&local=L000";
				break;
			case "전북":
				location="&local=M000";
				break;
			case "충남":
				location="&local=O000";
				break;
			case "충북":
				location="&local=P000";
				break;
			case "제주":
				location="&local=N000";
				break;
			default: 
				location="";
			break;
			}
			
			switch(jobtype) {
			case "정규직":
				jobtype = "&jobtype=1";
				break;
			case "계약직":
				jobtype = "&jobtype=2";
				break;
			case "인턴":
				jobtype = "&jobtype=3";
				break;
			case "아르바이트":
				jobtype = "&jobtype=7";
				break;
			case "병역특례":
				jobtype = "&jobtype=9";
				break;
			default: 
				jobtype = "";
				break;
			}
			
			switch(pay) {
			case "2000만원 이상":
				pay = "&payType=1&payMin=2000";
				break;
			case "3000만원 이상":
				pay = "&payType=1&payMin=3000";
				break;
			case "4000만원 이상":
				pay = "&payType=1&payMin=4000";
				break;
			case "5000만원 이상":
				pay = "&payType=1&payMin=5000";
				break;
			default: 
				pay = "";
				break;
			}
			System.out.println(searchvalue+sitetype+location+jobtype);
			baseurl="https://www.jobkorea.co.kr/Search/?stext=";
			baseurl+=searchvalue;
			baseurl+=location;
			baseurl+=jobtype;
			baseurl+=pay;
			baseurl+="&Page_No=1";
			
			System.out.println(baseurl);
			jvo=jkdao.getSearchResult(baseurl);
			break;
		case "Saram-in":
			switch(location) {

			case "서울":
				location="101000";
				break;


			case "인천":
				location="108000";
				break;
			case "경기":
				location="102000";
				break;
			case "부산":
				location="106000";
				break;
			case "대구":
				location="104000";
				break;
			case "광주":
				location="103000";
				break;
			case "대전":
				location="105000";
				break;
			case "울산":
				location="107000";
				break;
			case "세종":
				location="118000";
				break;
			case "강원":
				location="109000";
				break;
			case "경남":
				location="110000";
				break;
			case "경북":
				location="111000";
				break;
			case "전남":
				location="112000";
				break;
			case "전북":
				location="113000";
				break;
			case "충남":
				location="115000";
				break;
			case "충북":
				location="114000";
				break;
			case "제주":
				location="116000";
				break;

			default: 
				location="101000";
			break;
			}
			
			switch(jobtype) {
			case "정규직":
				jobtype = "1";
				break;
			case "계약직":
				jobtype = "2";
				break;
			case "인턴":
				jobtype = "4";
				break;
			case "아르바이트":
				jobtype = "5";
				break;
			case "병역특례":
				jobtype = "3";
				break;
			default: 
				jobtype = "";
				break;
			}
			
			switch(pay) {
			case "2000만원 이상":
				pay = "&sal_min=6";
				break;
			case "3000만원 이상":
				pay = "";
				break;
			case "4000만원 이상":
				pay = "";
				break;
			case "5000만원 이상":
				pay = "";
				break;
			default: 
				pay = "";
				break;
			}
			baseurl="https://www.saramin.co.kr/zf_user/search/recruit?searchType=search&searchword=";
			baseurl+=searchvalue;
			baseurl+="&recruitPage=";
			baseurl+="1";
			baseurl+=("&loc_mcd="+location);
			baseurl+="&recruitPageCount=20";
			System.out.println(baseurl);
			jvo=sdao.getSearchResult(baseurl);
			         	break;

		
		default:
			baseurl="https://kr.indeed.com/jobs?q=";
			baseurl+=searchvalue;
			baseurl+=("&l="+location);
			baseurl+="&start=20";
			System.out.println(baseurl);

			jvo=idao.getSearchResult(baseurl);
			
			
			break;
			
		}

		
		m.addAttribute("result",jvo);
		

		
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&local=I000
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&local=I000&jobtype=3
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&jobtype=3
		
		return "/jobsearch";
	}
	
	@RequestMapping("/crawl.do")
	public String crawl() {
        try {
            // 1. 수집 대상 URL
            String URL = "https://www.jobkorea.co.kr/Search/?stext=%EC%BD%94%EB%94%A9&local=I000&jobtype=1&tabType=recruit";

            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL+"&Page_No=3");
 //https://www.jobkorea.co.kr/Recruit/GI_Read/34262870?Oem_Code=C1&logpath=1
            // 3. HTML 파싱.
            Document html = conn.get(); // conn.post();
            Elements items=html.select(".list-default");
            items=items.select(".post");
            
            int i=0;
            for (Element k:items) {
            	Elements c=k.select(".post-list-corp");
            	System.out.println(i+k.toString());
            	i++;
            	if (i==20) {break;}
            }
            System.out.println(i);

            //Elements items = doc.select(".test");// 클래스 test명인거 가져오기
            //Elements items = doc.select("#test");//id명이 test인 항목을 가져오는 방법
            //Elements tags = doc.select(".test a");//class명이 test인 항목 안의 a태그만 가져오는 방법
            // 4. HTML 출력
            //System.out.println( items.toString() ); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
    @RequestMapping(value="/serialize", method=RequestMethod.POST)
    @ResponseBody
    public String serialize(UserVO jamong) {
        //필요한 로직 처리   
    	System.out.println("?");

        return jamong.getSid();
    }

    
	@RequestMapping("/naverToAnd.do")
	public @ResponseBody String naverToAnd(String name,String id,HttpServletRequest request ) {
		System.out.println("ntoand");
		System.out.println(id);
		System.out.println(name);
		HttpSession session=request.getSession();
		session.setAttribute("bid", id);
		session.setAttribute("bname", name);
	//	Object result= session.getAttribute("result");
		
	//	String rid=((OAuth2AccessToken) result).getParameter("name");
	//	System.out.println("rerid : "+ rid);
				
		
			 JSONObject jsonMain = new JSONObject(); // json 
			
			 jsonMain.put("Bpw", name);
			 jsonMain.put("Bid",id);
			// System.out.println(pwd);		
	  
				
				return jsonMain.toJSONString();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/androidtest.do")// 由ъ뒪�듃瑜� 蹂대궡湲�   @ResponseBody String
	public  ResponseEntity<String> andr(String id,String pw) {
		System.out.println("�삤�삤�뀠�삤�삤�삤�삤�뀠�삤�삤");
		System.out.println(id+","+pw);
        // json-simple �씪�씠釉뚮윭由� 異붽� �븘�슂(JSON 媛앹껜 �깮�꽦)
        JSONObject jsonMain = new JSONObject(); // json 媛앹껜
        // {蹂��닔紐�:媛�, 蹂��닔紐�:媛�}
        // {sendData:[{蹂��닔紐�:媛�},{蹂��닔紐�:媛�},...]}
        List<UserVO> items = new ArrayList<>();
        JSONArray jArray = new JSONArray(); // json諛곗뿴
        	for(int i=0;i<10;i++) {
    		UserVO vo=new UserVO();
			vo.setSid(""+i);
			vo.setSname("sejong");
			items.add(vo);
		}    	
        for(int i=0; i<items.size(); i++){
        	UserVO dto = items.get(i);
            JSONObject row = new JSONObject();
            // json媛앹껜.put("蹂��닔紐�",媛�)
            row.put("f", dto.getSid());
            row.put("l", dto.getSname());
            // 諛곗뿴�뿉 異붽�
            // json諛곗뿴.add(�씤�뜳�뒪,json媛앹껜)
            jArray.add(i,row);
        }
        // json媛앹껜�뿉 諛곗뿴�쓣 �꽔�쓬
        jsonMain.put("sendData", jArray);
        //return jsonMain.toJSONString();
        	return new  ResponseEntity<String>(jsonMain.toJSONString(),HttpStatus.OK);
	}
	@RequestMapping("/andtest.do")// �떒�씪 媛믩뱾 蹂대궡湲�
	//@ResponseBody String   원래 리턴타입
	public  ResponseEntity<String> andtest(String id,String pw, HttpServletResponse response,HttpServletRequest request ) throws IOException {
		System.out.println("andtest");
		HttpSession session=request.getSession();
		String bid= (String)session.getAttribute("bid");
		String name= (String)session.getAttribute("bname");
		
		System.out.println(bid);
		System.out.println(name);
			 JSONObject jsonMain = new JSONObject(); // json 
		//	 String pwd="Abdeok odielswo dj244 d";
			 jsonMain.put("Bpw", name);
			 jsonMain.put("Bid",bid);
			 jsonMain.put("test","test");
			// System.out.println(pwd);		
				//return jsonMain.toJSONString();   원래 리턴 ... 근데 결과는 같네..?
				return new ResponseEntity<String>(jsonMain.toJSONString(),HttpStatus.OK);
		//	return jsonMain;
	}
	
	
	
//	@RequestMapping("/tense.do")
//	public String tense() throws UnsupportedEncodingException {
//		
//	    try (SavedModelBundle b=SavedModelBundle.load("C:/Users/bohee/Desktop", "saved_model.pb")){
//	    	Session sess=b.session();
//	    	Tensor x=Tensor.create(2);
//	    	float[][]y=sess.runner()
//	    			.feed("�삩�룄", x)
//	    			.fetch("�뙋留ㅻ웾")
//	    			.run()
//	    			.get(0)
//	    			.copyTo(new float[2][1]);
//	    	
//	    	for(int i=0;i<y.length;i++) {
//	    		System.out.println(y[i][0]);
//	    	}
//	    	
//	    	
//	    }catch(Exception e) {
//	    	
//	    }
//		//C:\Users\bohee\Desktop
//		return "";
//	}
	
	
	
}
