package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;


public interface ProdDaoInf {
	
	
	
	public List<ProdVo> selectProdList(PageVo pageVo);
	
	public int cntProdList();
	
	public ProdVo selectProd(String prod_id);
}
