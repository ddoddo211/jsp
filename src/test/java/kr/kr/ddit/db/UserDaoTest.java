package kr.kr.ddit.db;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	
	private UserDaoInf ud;
	
	@Before
	public void setup(){
		ud = new UserDao();
	}

	@Test
	public void selectUserAllTest() {
		List<UserVo> userVoList = ud.selectUserAll();
		for(UserVo uv : userVoList){
			System.out.println(uv.toString());
		}
		
		assertEquals(105, userVoList.size());
		

		
		
		
	}
	
	/**
	 * 아이디를 매개변수로 주고 userVo 를 얻어오는 메서드 테스트
	 * Method : selectUserTest
	 * 작성자 : bms
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void selectUserTest(){
		/***Given***/
		
		/***When***/
		UserVo brown = ud.selectUser("brown");
		System.out.println(brown.getName()+","+brown.getUserId());
		
		/***Then***/
		
		assertEquals("브라운",brown.getName());
		assertEquals("brown",brown.getUserId());
		
	}
	
	/**
	 * Dao 의 같은 메서드명에 다른 매개변수를 가진 오버로딩 메서드를 활용
	 * Method : selectUserByVoTest
	 * 작성자 : bms
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void selectUserByVoTest(){
		/***Given***/
		UserVo TestVo = new UserVo();
		TestVo.setUserId("brown");
		/***When***/
		UserVo brown = ud.selectUser(TestVo);
		System.out.println(brown.getName()+","+brown.getUserId());
		
		/***Then***/
		
		assertEquals("브라운",brown.getName());
		assertEquals("brown",brown.getUserId());
		
	}
	
	//기존 service >> dao 는 단순히 동일이름 메서드 호출만했다
	// 이제 service 에서 dao에서 여러개의 메서드 호출
	
	//ex) 게시글 입력
	// 제목, 내용 --> board
	// 첨부파일 ==> boardFile  두번에 걸쳐 불러와야한다

	@Test
	public void getUserCntTest(){
		/***Given***/

		/***When***/
		int totalCnt = ud.getUserCnt();

		/***Then***/
		assertEquals(105,totalCnt);

	}
	
}
