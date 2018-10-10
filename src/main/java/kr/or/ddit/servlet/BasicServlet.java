package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BasicServlet.java
 *
 * @author bms
 * @version 1.0
 * @see
 *
 * <pre>
 * << �����̷�(Modification Information) >>
 *
 * ������ ��������
 * ------ ------------------------
 * bms ���� ����
 * ���� �ð��� ����ϴ� html �� �����ϴ� ����
 * </pre>
 */
public class BasicServlet extends HttpServlet {

	//��û http �޼��忡 ���� ����Ǵ� �޼��尡 �޶�����  
	// get : doGet, 
	// post : doPost
	
	@Override
	public void init() throws ServletException {
		System.out.println("init �޼��� ����");
	
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy ����");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//HttpServletRequest : 요청에대한
		//HttpServletResponse : 응답에 대한
		
		resp.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter pw = resp.getWriter();
		Date date = new Date();
		//
		
//		pw.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		Hello world");
		pw.println("<br>" + sdf.format(date));
		pw.println("	</body>");
		pw.println("</html>");
		
		
//		pw.println("<!DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head>");
//		pw.println("<meta charset=\"UTF-8\">");
//		pw.println("<title>Insert title here</title>");
//		pw.println("");
//		pw.println("</head>");
//		pw.println("<body>");
//		pw.println("");
//		pw.println("</body>");
//		pw.println("<script type=\"text/javascript\">");
//		pw.println("	var date = new Date();");
//		pw.println("	");
//		pw.println("	document.getElementsByTagName(\"body\")[0].innerHTML = \"현재시간: \" + date;");
//		pw.println("");
//		pw.println("</script>");
//		pw.println("</html>");
		
		
		
		
		
	}
	
	// �����ڷ� : index.htl --> url
	// �����ڷ� : servlet --> url mapping ���� �ʿ� : web.xml
	
	
}
