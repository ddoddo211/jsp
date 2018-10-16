package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userForm.jsp로 위임
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
	}

	//사용자 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 파라미터 post 방식 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//파일 쓰기관련
		//profile.part
		Part profilePart = request.getPart("profile");
		String sontentDisposition = profilePart.getHeader("Content-disposition");
		
		String fileName = StringUtil.getFileNameFromHeader(sontentDisposition);
		
//		int indexFilename = sontentDisposition.indexOf("filename");
//		int indexEnd = sontentDisposition.lastIndexOf("\"");
//		fileName = sontentDisposition.substring(indexFilename+10, indexEnd);
		
		//url 정보를 실제 경로로 변경
		String path = getServletContext().getRealPath("/profile");
		
		profilePart.write(path + File.separator+fileName);
		profilePart.delete(); // 파일저장시 사용한 임시영역에서 삭제
		
		// 파라미터 받아오기
		String userId 	= request.getParameter("userId");
		String pass		= request.getParameter("pass");
		String name		= request.getParameter("name");
		String zipcd	= request.getParameter("zipcd");
		String addr1	= request.getParameter("addr1");
		String addr2	= request.getParameter("addr2");
		String birth	= request.getParameter("birth");
		String email	= request.getParameter("email");
		String tel		= request.getParameter("tel");
		
		//String profile
		String profile = "/profile/"+fileName;
		System.out.println(userId+"/"+pass+"/"+name+"/"+zipcd+"/"+addr1+"/"+addr2+"/"+birth+"/"+email+"/"+tel);
		
		//파라미터를 UserVo 로 만들기
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setPass(pass);
		userVo.setName(name);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcd(zipcd);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			userVo.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setEmail(email);
		userVo.setTel(tel);
		userVo.setProfile(profile);
		// 사용자 등록 서비스 호출(미구현)
		UserServiceInf userService = new UserService();
		int cnt = userService.insertUser(userVo);
		
		
		
		
		//사용자 리스트로 이동(redirect : 서버상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복등록되는 현상을 막는다
		response.sendRedirect("/userPageList");
	}

}
