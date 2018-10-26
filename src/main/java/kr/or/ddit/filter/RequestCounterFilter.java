package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCounterFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String uri = req.getRequestURI();
		
		
		System.out.println(uri);
//		int count = 0;
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		if(req.getServletContext().getAttribute("countMap")!=null){
			countMap = (Map<String, Integer>)req.getServletContext().getAttribute("countMap");
//			if(uri.equals("/filterServlet")){
//				count = countMap.get("/filterServlet");
//				count++;
//			}
//			countMap.put("/filterServlet", count);
			System.out.println("countMap null 이 아닌곳으로왔따");
			for(String key : countMap.keySet()){
				if(uri.equals(key)){
					countMap.put(key, countMap.get(key)+1);
				}
			}
			if(countMap.get(uri)==null){
				countMap.put(uri, 1);
			}
			
			
		} else {
			countMap.put(uri, 1);
		}
//		System.out.println("/filterServlet 요청횟수 : " + count);
		req.getServletContext().setAttribute("countMap", countMap);
		
		
		
		chain.doFilter(req, response);
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
