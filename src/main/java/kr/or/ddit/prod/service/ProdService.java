package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;

public class ProdService implements ProdServiceInf {
	ProdDaoInf ud = new ProdDao();
	
	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		// TODO Auto-generated method stub
		return ud.selectProdList(pageVo);
	}

	@Override
	public int cntProdList() {
		// TODO Auto-generated method stub
		return ud.cntProdList();
	}

	@Override
	public ProdVo selectProd(String prod_id) {
		// TODO Auto-generated method stub
		return ud.selectProd(prod_id);
	}

}
