package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스 객체
		UserServiceInf userService = new UserService();
		
		//아이디 받아오기
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		//아이디로 VO받아오기
		UserVo userVo = userService.selectUser(userId);
		
		//VO jsp 로 넘기기
		request.setAttribute("userVo", userVo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 post 방식 인코딩 처리
				request.setCharacterEncoding("utf-8");
		
		//서비스 객체
				UserServiceInf userService = new UserService();
		
		//파일 쓰기관련
		//profile.part
		Part profilePart = request.getPart("profile");
		String sontentDisposition = profilePart.getHeader("Content-disposition");
		
		String fileName = StringUtil.getFileNameFromHeader(sontentDisposition);
		
		String path = getServletContext().getRealPath("/profile");
		
		profilePart.write(path + File.separator+fileName);
		profilePart.delete(); // 파일저장시 사용한 임시영역에서 삭제
		
		//String profile
		String profile = "/profile/"+fileName;
				
		
		UserVo userVo = new UserVo();
		String userId = request.getParameter("userId");
		System.out.println("userId : " + userId);
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2  = request.getParameter("addr2");
		String birth  = request.getParameter("birth");
		System.out.println("birth : " + request.getParameter("birth"));
		String zipcd  = request.getParameter("zipcd");
		String email  = request.getParameter("email");
		String tel  = request.getParameter("tel");
		
		userVo.setUserId(userId);
		userVo.setPass(pass);
		userVo.setName(name);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			userVo.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setZipcd(zipcd);
		userVo.setEmail(email);
		userVo.setTel(tel);
		if(profilePart!=null){
		userVo.setProfile(profile);
		}
		//db에서 수정
		int cnt = userService.userUpdate(userVo);
		
		//보내기 직전 userVo 생성해서 넘겨줘야함
		userVo = userService.selectUser(userId);
		request.setAttribute("userVo", userVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);
	}

}
