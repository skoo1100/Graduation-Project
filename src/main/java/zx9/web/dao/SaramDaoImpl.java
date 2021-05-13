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
public class SaramDaoImpl implements SaramDao{
	@Autowired
	private SqlSession sqlSession;



	@Override
	public ArrayList<jobVO> getSearchResult(String baseurl) {
		// TODO Auto-generated method stub
		jobVO jvo=null;
		Connection conn = Jsoup.connect(baseurl);
		
		try {
			Document html = conn.get();
			Elements items=html.select("#recruit_info_list");
			
			items=items.select(".content");
			items=items.select(".item_recruit");
			String title;
			String corpname;
			String url;
			String burl="https://www.saramin.co.kr";
			ArrayList<jobVO> result=new ArrayList<jobVO>();
			
			for(Element k:items) {
				title=k.select(".area_job").select("a").attr("title");
				url=k.select(".area_job").select("a").attr("href");
				k.select(".area_corp");
				corpname=k.select(".area_corp").select("a").attr("title");
				System.out.println(title+","+corpname+","+url);
				jvo=new jobVO();
				jvo.setCorp(corpname);
				jvo.setUrl(burl+url);
				jvo.setTitle(title);
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
