package sum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		int mul = 1;
		for(int num = param1;num <=param2 ; num++){
			mul *= num;
		}
		
		System.out.println(mul);
		
		request.getSession().setAttribute("mulResult", "[" +param1+ "] 곱하기 [" + param2 + "] 의 결과는 [" + mul + "] 입니다");
		request.getRequestDispatcher("mulResult.jsp").forward(request, response);
	}

}
