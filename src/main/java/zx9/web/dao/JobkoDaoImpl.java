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

@Repository
public class JobkoDaoImpl implements JobkoDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void getNews() {

		 
	}

	@Override
	public ArrayList<String> getRank() {
		String URL="https://www.jobkorea.co.kr/";
		Connection conn = Jsoup.connect(URL);
		try {
			Document html = conn.get();
			Elements items=html.select("#ranking_carousel");
			items=items.select(".carousel-wrapper");
			items=items.select("li");
			int i=0;
			ArrayList<String> ranking=new ArrayList<String>();
           
            	Elements c=items.first().select("a");
            	for(Element k:c) {
            		i++;
            		System.out.println(k.text());
            		ranking.add(k.text());
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
	
}
