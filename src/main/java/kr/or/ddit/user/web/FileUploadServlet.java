package kr.or.ddit.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fileUpload.jsp 전달
		request.getRequestDispatcher("/fileUpload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 text 파라미터 : request.getParameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		
		System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
//		System.out.println("profile : " +request.getParameter("profile"));
		
		//profile.part
		Part profilePart = request.getPart("profile");
		System.out.println(profilePart.getContentType());
		
		System.out.println(profilePart.getHeader("Content-disposition"));
		String sontentDisposition = profilePart.getHeader("Content-disposition");
		
		String fileName = "";
		
		int indexFilename = sontentDisposition.indexOf("filename");
		int indexEnd = sontentDisposition.lastIndexOf("\"");
		fileName = sontentDisposition.substring(indexFilename+10, indexEnd);
		
		profilePart.write("C:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\"+fileName);
		profilePart.delete(); // 파일저장시 사용한 임시영역에서 삭제
		
		
	}

}
