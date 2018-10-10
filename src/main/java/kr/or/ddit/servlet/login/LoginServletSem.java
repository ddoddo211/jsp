package kr.or.ddit.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

public class LoginServletSem extends HttpServlet{
	private final String USERID = "brown";
	private final String PASSWORD = "1234";
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	UserService us = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1. 사용자 ID, 비밀번호를 request 객체에서 받아온다
		//2. db에서 조회에온 아이디, 비밀번호를 체크한다
		//상수대신 db 조회 아이디 확인
		// 1) 사용자가 전송한 ID 파라미터로 사용자 정보조회
		// 2) db에서 조회한 사용자가 비밀번호가 파라미터로 전송된 비밀번호와 동인한지 비교
		
		//3. 일치할 경우main.jsp 로 이동
		//3-2. 불일치할 경우 login.jsp 로 이동
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		String userId= req.getParameter("userId");
		String password = req.getParameter("password");
		System.out.println(userId);
		UserVo userVo = us.selectUser(userId);
		if(userVo!=null && password.equals(userVo.getPass())){
			//main.jsp 이동
			
			//redirect DB에 변화준다고 했을때 주로사용
//			resp.sendRedirect("main.jsp?userId="+userId+"&password="+password);
			
//			//session 에 사용자 정보 설정
//			UserVo userVoTemp = new UserVo();
//			userVoTemp.setUserId(userId);
//			userVoTemp.setName("바루스");
////			userVo.setAlias("원딜");
//			userVoTemp.setBirth(new Date());
			HttpSession session = req.getSession();
//			session.setAttribute("session", userVo.getName()+"["+userVo.getAlias()+"] 님 안녕하세요");
			session.setAttribute("session", userVo.getName()+"["+userVo.getUserId()+"] 님 안녕하세요");
			
			//2. main.jsp
			//body 영역에
			//이름[별명] 님 안녕하세요
			
			//dispatch
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
			rd.forward(req, resp);
			
			
		} else {
			//login.jsp 이동
			resp.sendRedirect("login/login.jsp");
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
		//userId : brown / sally
		String[] userIds = req.getParameterValues("userId");
		for(String userId : userIds)
			pw.println("		userId : " + userId + "<br>");
		pw.println("		password : " + req.getParameter("password") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");
	}
}
