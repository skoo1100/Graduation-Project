package zx9.web.dao;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zx9.web.vo.jobVO;

@Repository
public class JobkoDaoImpl implements JobkoDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<ArrayList<String>> getNews() {
		String URL="https://www.jobkorea.co.kr/goodjob/tip/120001?schCtgr=120001&TipKwrdArray=%EC%A0%84%EA%B3%B5&TipKwrdArray=%EC%B7%A8%EC%A4%80%EC%83%9D&TipKwrdArray=%EC%95%8C%EB%B0%94%EC%83%9D&TipKwrdArray=%EC%8A%A4%ED%8E%99&TipKwrdArray=%EC%A4%91%EC%86%8C%EA%B8%B0%EC%97%85&TipKwrdArray=%EC%9D%B4%EC%8A%88&TipKwrdArray=%EB%82%98%EC%9D%B4&TipKwrdArray=%EC%A7%81%EC%9E%A5%EC%9D%B8&TipKwrdArray=%EA%B5%AC%EC%A7%81%ED%99%9C%EB%8F%99&TipKwrdArray=%EC%95%8C%EB%B0%94%EB%AA%AC&Page=";
		String page="1";
		Connection conn = Jsoup.connect(URL+page);
		try {
			Document html = conn.get();
			Elements items=html.select("#container");
			items=items.select(".joodJobList");
			items=items.select("li");
			int i=0;
			
			ArrayList<ArrayList<String>> news=new ArrayList<ArrayList<String>>();
           ArrayList<String> url=new ArrayList<String>();           
            	for(Element k:items) {
            		i++;
            		url.clear();
            		//url.
            		//System.out.println(k.select("a").attr("href"));
            		url.add(k.select("a").attr("href"));
            		
            		//System.out.println(k.text());
            		String result=k.select("strong").text().trim();
            		if (result.contains("\r\n")) {
            			result=result.split("\r\n")[0];
            			
            		}

            		System.out.println(k.select("a").attr("href")+result);
            		url.add(result);
            		news.add((ArrayList<String>) url.clone());
            		System.out.println(news);
            		//System.out.println(result);
            		if (i==10)
            			break;
            	}
            	
            	return news;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}

	@Override
	public ArrayList<ArrayList<String>> getRank() {
		String URL="https://www.jobkorea.co.kr/";
		Connection conn = Jsoup.connect(URL);
		try {
			Document html = conn.get();
			Elements items=html.select("#ranking_carousel");
			items=items.select(".carousel-wrapper");
			items=items.select("li");
			int i=0;
			ArrayList<ArrayList<String>> ranking=new ArrayList<ArrayList<String>>();
			ArrayList<String> url=new ArrayList<String>();
           
            	Elements c=items.first().select("a");
            	for(Element k:c) {
            		url.clear();
            		i++;
            		System.out.println(k.text());
            		url.add(k.attr("href"));
            		url.add(k.text());
            		ranking.add((ArrayList<String>) url.clone());
            		if (i==10)
            			break;
            	}
            	
            	return ranking;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<jobVO> getSearchResult(String baseurl) {
		// TODO Auto-generated method stub
		jobVO jvo=null;
		Connection conn = Jsoup.connect(baseurl);
		
		try {
			Document html = conn.get();
			Elements items=html.select(".article");
			items=items.select(".cnt-list-wrap");
			items=items.select(".list-wrap");
			items=items.select(".recruit-info");
			items=items.select(".lists");
			items=items.select(".list-default");
			items=items.select(".clear");
			
			items=items.select("li");
			int i=0;
			ArrayList<ArrayList<String>> ranking=new ArrayList<ArrayList<String>>();

			ArrayList<jobVO> result=new ArrayList<jobVO>();
			String burl="https://www.jobkorea.co.kr";
	
		
			
           
            	for(Element k:items) {
            		jvo=new jobVO();
            		Elements corp=k.select(".post-list-corp");
            		Elements info=k.select(".post-list-info");
            		corp=corp.select("a");
            		jvo.setUrl(burl+corp.attr("href"));
            		jvo.setCorp(corp.text());
            		jvo.setTitle(info.select("a").attr("title"));
            		result.add(jvo);
            		
            	}
            	

            	return result;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
