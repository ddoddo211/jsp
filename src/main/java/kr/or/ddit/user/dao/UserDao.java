package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf {
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		return session.selectList("user.selectUserAll");
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		return session.selectOne("user.selectUser", userId);
	}
	
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		return session.selectOne("user.selectUserByVo", userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		return session.selectList("user.selectUserPageList", pageVo);
	}
}
