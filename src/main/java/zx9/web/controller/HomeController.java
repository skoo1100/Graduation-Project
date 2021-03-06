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
	public String search(Model m,String searchvalue,String sitetype,String location,String jobtype,String pay,String page) {
		//searchvalue/sitetype/location/jobtype/pay
		m.addAttribute("searchvalue",searchvalue);
		m.addAttribute("sitetype",sitetype);
		m.addAttribute("location",location);
		m.addAttribute("jobtype",jobtype);
		m.addAttribute("pay",pay);
		m.addAttribute("page",page);
		if (page==null) {
			page="1";
		}
		
		

		ArrayList<jobVO> jvo = null;
		String baseurl;
		
		switch(sitetype) {
		case "Job-korea":
		
			switch(location) {
			case "??????":
				location="&local=I000";
				break;
			case "??????":
				location="&local=K000";
				break;
			case "??????":
				location="&local=B000";
				break;
			case "??????":
				location="&local=H000";
				break;
			case "??????":
				location="&local=F000";
				break;
			case "??????":
				location="&local=E000";
				break;
			case "??????":
				location="&local=G000";
				break;
			case "??????":
				location="&local=J000";
				break;
			case "??????":
				location="&local=1000";
				break;
			case "??????":
				location="&local=A000";
				break;
			case "??????":
				location="&local=C000";
				break;
			case "??????":
				location="&local=D000";
				break;
			case "??????":
				location="&local=L000";
				break;
			case "??????":
				location="&local=M000";
				break;
			case "??????":
				location="&local=O000";
				break;
			case "??????":
				location="&local=P000";
				break;
			case "??????":
				location="&local=N000";
				break;
			default :
				location="";
			break;
			}
			
			switch(jobtype) {
			case "?????????":
				jobtype = "&jobtype=1";
				break;
			case "?????????":
				jobtype = "&jobtype=2";
				break;
			case "??????":
				jobtype = "&jobtype=3";
				break;
			case "???????????????":
				jobtype = "&jobtype=7";
				break;
			case "????????????":
				jobtype = "&jobtype=9";
				break;
			default: 
				jobtype = "";
				break;
			}
			
			switch(pay) {
			case "2000?????? ??????":
				pay = "&payType=1&payMin=2000";
				break;
			case "3000?????? ??????":
				pay = "&payType=1&payMin=3000";
				break;
			case "4000?????? ??????":
				pay = "&payType=1&payMin=4000";
				break;
			case "5000?????? ??????":
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
			
			baseurl+=("&Page_No="+page);
			
			
			System.out.println(baseurl);
			jvo=jkdao.getSearchResult(baseurl);
			break;
		case "Saram-in":
			switch(location) {

			case "??????":
				location="101000";
				break;
			case "??????":
				location="108000";
				break;
			case "??????":
				location="102000";
				break;
			case "??????":
				location="106000";
				break;
			case "??????":
				location="104000";
				break;
			case "??????":
				location="103000";
				break;
			case "??????":
				location="105000";
				break;
			case "??????":
				location="107000";
				break;
			case "??????":
				location="118000";
				break;
			case "??????":
				location="109000";
				break;
			case "??????":
				location="110000";
				break;
			case "??????":
				location="111000";
				break;
			case "??????":
				location="112000";
				break;
			case "??????":
				location="113000";
				break;
			case "??????":
				location="115000";
				break;
			case "??????":
				location="114000";
				break;
			case "??????":
				location="116000";
				break;
			default: 
				location="101000";
			break;
			}
			
			switch(jobtype) {
			case "?????????":
				jobtype = "1";
				break;
			case "?????????":
				jobtype = "2";
				break;
			case "??????":
				jobtype = "4";
				break;
			case "???????????????":
				jobtype = "5";
				break;
			case "????????????":
				jobtype = "3";
				break;
			default: 
				jobtype = "";
				break;
			}
			
			switch(pay) {
			case "2000?????? ??????":
				pay = "&sal_min=6";
				break;
			case "3000?????? ??????":
				pay = "&sal_min=11";
				break;
			case "4000?????? ??????":
				pay = "&sal_min=16";
				break;
			case "5000?????? ??????":
				pay = "&sal_min=17";
				break;
			default: 
				pay = "";
				break;
			}
			baseurl="https://www.saramin.co.kr/zf_user/search/recruit?searchType=search&searchword=";
			baseurl+=searchvalue;
			baseurl+="&recruitPage=";
			baseurl+=page;
			baseurl+="&jobtype=";
			baseurl+=jobtype;
			
			
			baseurl+=("&loc_mcd="+location);
			baseurl+="&recruitPageCount=20";
			System.out.println(baseurl);
			jvo=sdao.getSearchResult(baseurl);
			         	break;

		
		default:
			
			switch(jobtype) {
			case "?????????":
				jobtype = "&jt=fulltime";
				break;
			case "?????????":
				jobtype = "&jt=contract";
				break;
			case "??????":
				jobtype = "&jt=internship";
				break;
			case "???????????????":
				jobtype = "&jt=parttime";
				break;
			case "????????????":
				jobtype = "&jt=new_grad";
				break;
			default: 
				jobtype = "";
				break;
			}
			
			switch(pay) {
			case "2000?????? ??????":
				pay = "20000000";
				break;
			case "3000?????? ??????":
				pay = "30000000";
				break;
			case "4000?????? ??????":
				pay = "40000000";
				break;
			case "5000?????? ??????":
				pay = "50000000";
				break;
			default: 
				pay = "";
				break;
			}
			baseurl="https://kr.indeed.com/jobs?q=";
			baseurl+=(searchvalue+" ???"+pay);
			baseurl+=("&l="+location);
			int pn=Integer.parseInt(page);
			pn*=10;
			pn-=10;
			
			baseurl+="&start=";
			baseurl+=pn;
			System.out.println(baseurl);

			jvo=idao.getSearchResult(baseurl);
			
			
			break;
			
		}

		
		m.addAttribute("result",jvo);
		m.addAttribute("count",jvo.size());
		

		
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&local=I000
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&local=I000&jobtype=3
		//https://www.jobkorea.co.kr/Search/?stext=%EC%9E%90%EB%B0%94&jobtype=3
		
		return "/jobsearch";
	}
	
	@RequestMapping("/crawl.do")
	public String crawl() {
        try {
            // 1. ?????? ?????? URL
            String URL = "https://www.jobkorea.co.kr/Search/?stext=%EC%BD%94%EB%94%A9&local=I000&jobtype=1&tabType=recruit";

            // 2. Connection ??????
            Connection conn = Jsoup.connect(URL+"&Page_No=3");
 //https://www.jobkorea.co.kr/Recruit/GI_Read/34262870?Oem_Code=C1&logpath=1
            // 3. HTML ??????.
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

            //Elements items = doc.select(".test");// ????????? test????????? ????????????
            //Elements items = doc.select("#test");//id?????? test??? ????????? ???????????? ??????
            //Elements tags = doc.select(".test a");//class?????? test??? ?????? ?????? a????????? ???????????? ??????
            // 4. HTML ??????
            //System.out.println( items.toString() ); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
    @RequestMapping(value="/serialize", method=RequestMethod.POST)
    @ResponseBody
    public String serialize(UserVO jamong) {
        //????????? ?????? ??????   
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/androidtest.do")// ???????????????????? ???????????????   @ResponseBody String
	public  ResponseEntity<String> andr(String id,String pw) {
		System.out.println("????????????????????????????????????????????????????????????");
		System.out.println(id+","+pw);
        // json-simple ??????????????????????????? ????????? ????????????(JSON ????????? ????????????)
        JSONObject jsonMain = new JSONObject(); // json ?????????
        // {??????????????????:??????, ??????????????????:??????}
        // {sendData:[{??????????????????:??????},{??????????????????:??????},...]}
        List<UserVO> items = new ArrayList<>();
        JSONArray jArray = new JSONArray(); // json?????????
        	for(int i=0;i<10;i++) {
    		UserVO vo=new UserVO();
			vo.setSid(""+i);
			vo.setSname("sejong");
			items.add(vo);
		}    	
        for(int i=0; i<items.size(); i++){
        	UserVO dto = items.get(i);
            JSONObject row = new JSONObject();
            // json?????????.put("??????????????????",??????)
            row.put("f", dto.getSid());
            row.put("l", dto.getSname());
            // ??????????????? ?????????
            // json?????????.add(??????????????????,json?????????)
            jArray.add(i,row);
        }
        // json??????????????? ??????????????? ????????????
        jsonMain.put("sendData", jArray);
        //return jsonMain.toJSONString();
        	return new  ResponseEntity<String>(jsonMain.toJSONString(),HttpStatus.OK);
	}
	@RequestMapping("/andtest.do")// ???????????? ????????? ???????????????
	//@ResponseBody String   ?????? ????????????
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
				//return jsonMain.toJSONString();   ?????? ?????? ... ?????? ????????? ??????..?
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
//	    			.feed("????????????", x)
//	    			.fetch("???????????????")
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
