package kr.or.ddit.user.main;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserMain {

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		List<UserVo> userVoList = ud.selectUserAll();
		for(UserVo uv : userVoList){
			System.out.println(uv.toString());
		}

	}

}
