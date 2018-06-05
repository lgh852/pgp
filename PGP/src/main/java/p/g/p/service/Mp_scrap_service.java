package p.g.p.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;



import p.g.p.dao.Mp_dao;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Scrap_scrapFN;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;

public class Mp_scrap_service {
   
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;
   
   private Mp_dao dao;
   


public List<Join_Scrap_scrapFN> selectScrapPhotoList(Scrap scrap2) {
	
	dao = sqlSessionTemplate.getMapper(Mp_dao.class);
	List<Join_Scrap_scrapFN> scrapList = dao.selectScrapPhotoList(scrap2);
	
	
	return scrapList;
}


public List<Integer> selectscrapfnidx(int member_idx) {
	
	dao = sqlSessionTemplate.getMapper(Mp_dao.class);
	List<Integer> scrapfnidx = dao.selectscrpafnidx(member_idx);
    return scrapfnidx;
}


public int countFnIdx(int member_idx) {
	
	dao = sqlSessionTemplate.getMapper(Mp_dao.class);
	int c = dao.countFnIdx(member_idx);
	
	return c;
}


public int selectScrapboardidx(Join_Scrap_scrapFN scrap) {

	dao = sqlSessionTemplate.getMapper(Mp_dao.class);
	int result = dao.selectScrapBoardIdx(scrap);
	
	return result;
}


public String selectPhotoName(Integer integer) {
	
	dao = sqlSessionTemplate.getMapper(Mp_dao.class);
	String r = dao.selectPhotoName(integer);
	
	return r;
}



   
   

}