package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class ProdDao implements ProdDaoInf {
	

	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<ProdVo> prodList = session.selectList("prod.selectProdList", pageVo);
		session.close();
		return prodList;
		
		
	}

	@Override
	public int cntProdList() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int totalCnt = session.selectOne("prod.cntProdList");
		session.close();
		return totalCnt;
	}

	@Override
	public ProdVo selectProd(String prod_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		System.out.println(prod_id);
		ProdVo prodVo = session.selectOne("prod.selectProd", prod_id);
		session.close();
		return prodVo;
	}
}
