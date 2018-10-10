package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		Map<String, String[]> reqMap = req.getParameterMap();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		
		for(String str : reqMap.get("userId")){
			pw.println("userId: " + str +"<br>");
		}
		
		for(String str : reqMap.get("password")){
			pw.println("password: " +str);
		}
		
		pw.println("	</body>");
		pw.println("</html>");
	
	}
	
}
