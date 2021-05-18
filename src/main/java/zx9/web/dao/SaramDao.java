package zx9.web.dao;

import java.util.ArrayList;

import zx9.web.vo.jobVO;

public interface SaramDao {



	ArrayList<jobVO> getSearchResult(String baseurl);

}
