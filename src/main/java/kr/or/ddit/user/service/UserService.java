package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {
	UserDao ud = new UserDao();
	
	@Override
	public List<UserVo> selectUserAll() {
		// TODO Auto-generated method stub
		return ud.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return ud.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return ud.selectUser(userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		// TODO Auto-generated method stub
		return ud.selectUserPageList(pageVo);
	}

}
