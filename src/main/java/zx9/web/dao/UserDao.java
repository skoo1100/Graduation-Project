package zx9.web.dao;

import java.util.List;

import zx9.web.vo.UserVO;

public interface UserDao {

	void register(UserVO a);

	boolean login(UserVO a);

	UserVO getall(UserVO a);

	List<UserVO> GetallUser();

	void chmod(UserVO u);

}
