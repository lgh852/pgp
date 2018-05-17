package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoleeDao;
import p.g.p.dao.Sb_dao;
import p.g.p.model.Like;

public class Sb_like_service {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private Sb_dao dao;
	
	public Like likeck(Like like) {
		
		dao = sqlSessionTemplate.getMapper(Sb_dao.class);
		like = dao.selectlikeck(like);
		
		
		return like;
	}


	public int Likeup(Like like) {
		
		dao=sqlSessionTemplate.getMapper(Sb_dao.class);
		
		int resultCnt=dao.likeup(like);
		
		if(resultCnt>0) {
			
		}else {
			resultCnt=0;
		}
		
		return resultCnt;
	}

	public int updateLikecntUp(Like like) {
		
		dao=sqlSessionTemplate.getMapper(Sb_dao.class);
		
		int resultCnt = dao.likeUpdateUP(like);
		
		return resultCnt;
	}
	
	


	public int deletelike(Like likeck) {
		
		dao=sqlSessionTemplate.getMapper(Sb_dao.class);
		
		int result = dao.deletelike(likeck);
		
		if(result>0) {
			
		}else {
			result=-1;
		}
		
		return result;
	}


	public int updateLikecntDown(Like like) {

		dao = sqlSessionTemplate.getMapper(Sb_dao.class);
		
		int result = dao.likeupdateDown(like);
		
		if(result>0) {
			
		}else {
			result=-1;
		}
		return result;
	}

}
