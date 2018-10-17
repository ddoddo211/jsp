package kr.or.ddit.prod.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;

@WebServlet("/prodDetail")
public class ProdDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdServiceInf prodService = new ProdService();
		
		String prod_id = request.getParameter("prod_id");
		ProdVo prodVo = prodService.selectProd(prod_id);
		
		request.setAttribute("prodVo", prodVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
