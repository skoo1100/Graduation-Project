package zx9.web.dao;

import java.util.ArrayList;

import zx9.web.vo.jobVO;

public interface JobkoDao {

	ArrayList<ArrayList<String>> getNews();

	ArrayList<ArrayList<String>> getRank();

	ArrayList<jobVO> getSearchResult(String baseurl);

}
