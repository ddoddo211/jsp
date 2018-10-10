package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/userAllList")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//보통 링크클릭은 doget으로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceInf userService = new UserService();
		
		//전체 사용자 정보 조회
		List<UserVo> userList = userService.selectUserAll();
		
		//pagenation
		PageVo pageVo = new PageVo();
		request.getParameter("");
		
		
		
		
		
		// 세션에 attribute key value 설정 (List)
		//조회된 사용자 정보를 userAllList.jsp 를 통해 화면 처리
		//userAllList.jsp 에서 userList 참조하기위한 방법
		// >> Attribute
		// session : 해당 사용자만 접근이 가능(사용자 전용공간) >> 자주 참조하는 데이터
		// 			>>> 너무많은 데이터를 저장할 경우  OOM 유발 가능성(과부하)
		
		// application : 모든 사용자가 접근 가능(서버당 하나만 생성), 설정과 관련된 것을 많이한다
		// application >>> request.getServletContext().setAttribute("UserVoList", userList);
		
		// request : 해당 요청의 응답이 끝날때까지 접근 가능
		request.setAttribute("userList", userList);
		
		//화면으로 위임
		//1. dispatch :  (2. sendRedirect방식이 아닌경우)조회만 했을때
		//2. sendRedirect :  서버에 데이터가 변경되었을때
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
