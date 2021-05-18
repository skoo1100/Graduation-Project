package zx9.web.dao;

import java.util.ArrayList;

import zx9.web.vo.jobVO;

public interface IndeedDao {



	ArrayList<jobVO> getSearchResult(String baseurl);

}
