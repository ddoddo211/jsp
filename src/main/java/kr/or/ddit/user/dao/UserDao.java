package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf {
	
	//DB 에 값 변화 줄때 session.close() , session.commit(), session.rollback() 해주기
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserVo> userList = session.selectList("user.selectUserAll");
		session.close();
		return userList;
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserVo userVo = session.selectOne("user.selectUser", userId);
		session.close();
		return userVo;
	}
	
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserVo userVoSel = session.selectOne("user.selectUserByVo", userVo);
		session.close();
		return userVoSel;
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserVo> userList = session.selectList("user.selectUserPageList", pageVo);
		session.close();
		return userList;
	}
	
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int totalCnt = session.selectOne("user.getUserCnt");
		session.close();
		return totalCnt;
	}
}
