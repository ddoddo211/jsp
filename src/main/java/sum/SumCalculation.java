package sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		
		int end = Integer.parseInt(request.getParameter("end"));
		
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start,end);
		
		
		
//		for(int num = start; num<=end;num++){
//			sum +=num;
//		}
		System.out.println(sum);
		
		request.getSession().setAttribute("sumResult","["+ start+"] 부터 [" + end + "] 까지의 합계는 [" + sum + "] 입니다");
		
		//dispatch
		RequestDispatcher rd = request.getRequestDispatcher("sumResult.jsp");
		rd.forward(request, response);
		
	}

}
