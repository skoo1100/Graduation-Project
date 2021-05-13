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
public class IndeedDaoImpl implements IndeedDao{
	@Autowired
	private SqlSession sqlSession;



	@Override
	public ArrayList<jobVO> getSearchResult(String baseurl) {
		// TODO Auto-generated method stub
		jobVO jvo=null;
		Connection conn = Jsoup.connect(baseurl);
		
		try {
			Document html = conn.get();
			Elements items=html.select("#resultsCol");
			System.out.println(items.text());
			Elements titles=items.select(".title");
			Elements corps=items.select(".sjcl");
			
			
			System.out.println(items.text());
			System.out.println("들어오긴 한거지?");
			String title;
			String corpname;
			String url;
			String burl="https://kr.indeed.com";

			ArrayList<jobVO> result=new ArrayList<jobVO>();
			for(Element k:titles) {
				title=k.select("a").attr("title");
				url=k.select("a").attr("href");
				jvo=new jobVO();
				jvo.setTitle(title);
				jvo.setUrl(burl+url);
				result.add(jvo);
			}
			int i=0;
			for (Element k:corps) {
				corpname=k.select(".company").text();
				System.out.println(corpname);
				result.get(i).setCorp(corpname);
				i++;
			}

			
			

			
			

			


            	return result;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	
}
