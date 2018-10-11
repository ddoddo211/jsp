package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

@WebServlet(urlPatterns ={"/userAllList", "/userPageList", "/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//보통 링크클릭은 doget으로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 uri로 로직분기
		String uri = request.getRequestURI();
		System.out.println("userServlet : "+uri+" : doGet 진입");
		//uri == userAllList
		if(uri.equals("/userAllList")){
			userAllList(request, response);
		}
		//uri == userPageList
		else if(uri.equals("/userPageList")){
			
			userPageList(request,response);
		}
		//사용자 상세 조회
		else if(uri.equals("/userDetail")){
			userDetail(request, response);
		}
	
	}
	
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserServiceInf userService = new UserService();
		// 사용자 아이디가 파라미터로 넘어옴
		String userId = request.getParameter("userId");
		// 사용자 아이디에 해당하는 사용자 정보조회
		UserVo userVo = userService.selectUser(userId);
		// jsp 로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("userVo", userVo);
		//사용자 상세 화면으로 위임
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * 
	 * Method : userPageList
	 * 작성자 : bms
	 * 변경이력 :
	 * @param request
	 * @param response
	 * Method 설명 : 사용자 페이지 리스트 조회
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// userservice 생성
		// userPageList 호출 : 메소드 인자 -pageVo : page, pageSie
		//request 객체에 저장
		
		//forward (userAllList.jsp --> userPageList.jsp)
		
		UserServiceInf userService = new UserService();
		
		//전체 사용자 정보 조회
		List<UserVo> userList = userService.selectUserAll();
		System.out.println(request.getParameter("pageNum"));
		//pagenation
		PageVo pageVo = new PageVo();
		int page = 0;
		if(request.getParameter("pageNum")==null){
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}
		int pageSize = 10;
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		//원하는 페이지 적용해서 넘김
		List<UserVo> userListP = (List<UserVo>)resultMap.get("userList");
		
		// request : 해당 요청의 응답이 끝날때까지 접근 가능
		request.setAttribute("totalCnt", userService.getUserCnt());
		request.setAttribute("userList", userList);
		request.setAttribute("userListP", userListP);
		request.setAttribute("pageVo", pageVo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPageList.jsp");
		rd.forward(request, response);
	}

	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("userAllList method 진입");
		UserServiceInf userService = new UserService();
		
		//전체 사용자 정보 조회
		List<UserVo> userList = userService.selectUserAll();
		System.out.println(request.getParameter("pageNum"));
		//pagenation
		PageVo pageVo = new PageVo();
		int page = 0;
		if(request.getParameter("pageNum")==null){
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}
		int pageSize = 10;
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		//원하는 페이지 적용해서 넘김
		List<UserVo> userListP = (List<UserVo>)resultMap.get("userList");
		
		
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
		request.setAttribute("userListP", userListP);
		request.setAttribute("pageVo", pageVo);
		
		//화면으로 위임
		//1. dispatch :  (2. sendRedirect방식이 아닌경우)조회만 했을때
		//2. sendRedirect :  서버에 데이터가 변경되었을때
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
