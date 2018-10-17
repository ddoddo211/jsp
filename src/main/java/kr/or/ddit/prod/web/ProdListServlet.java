package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;


@WebServlet("/prodList")
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdServiceInf userService = new ProdService();
		
		//pagenation
				PageVo pageVo = new PageVo();
				int page = 0;
				if(request.getParameter("pageNum")==null){
					page = 1;
				} else {
					page = Integer.parseInt(request.getParameter("pageNum"));
				}
				int pageSize = 10;
				pageVo.setPage(page);
				pageVo.setPageSize(pageSize);
		
		List<ProdVo> prodList = userService.selectProdList(pageVo);
		System.out.println(prodList);
		
	
		request.setAttribute("totalCnt", userService.cntProdList());
		request.setAttribute("prodList", prodList);
		request.setAttribute("pageVo", pageVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodList.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
