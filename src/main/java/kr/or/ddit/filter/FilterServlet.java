package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8081/filterServlet
@WebServlet("/filterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("filter servlet do get");
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setCharacterEncoding 설정을 filter 로 이관(코드 중복 제거)
		//request.setCharacterEncoding("utf-8");
		
		//userNm 파라미터 받기
		String userNm = request.getParameter("userNm");
		
		//request 속성으로 저장
		request.setAttribute("userNm", userNm);
		
		//request foward (/filter/view.jsp)
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
		
		//view.jsp request 객체의 userNm 이라고 설정한 속성을 화면에 표시
	
	}

}
