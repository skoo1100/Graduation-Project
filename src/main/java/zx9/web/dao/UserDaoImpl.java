package zx9.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zx9.web.vo.UserVO;
@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private SqlSession sqlSession;// 자동 의존성 주입 => mybatis쿼리문 수행객체

	@Override
	public void register(UserVO a) {
	sqlSession.insert("register", a);
	
	}

	@Override
	public boolean login(UserVO a) {
		UserVO b=sqlSession.selectOne("selall", a);
		if(b==null)
			return false;
		
		boolean ispwright=b.getSpw().equals(a.getSpw());
			return ispwright;
		
	}

	@Override
	public UserVO getall(UserVO a) {
		// TODO Auto-generated method stub
		a=sqlSession.selectOne("selall",a);
		return a;
	}

	@Override
	public List<UserVO> GetallUser() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("GetallUser");
	}

	@Override
	public void chmod(UserVO u) {
		// TODO Auto-generated method stub
		sqlSession.update("chmod",u);
		
	}

}
