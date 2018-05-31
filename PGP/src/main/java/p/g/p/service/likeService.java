package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Sb_dao;
import p.g.p.model.PhotoListmodel;

public class likeService {
	
	Sb_dao dao;
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public PhotoListmodel mypagelike(String board_idx) throws NullPointerException {
		

		dao = sessionTemplate.getMapper(Sb_dao.class);
		
		PhotoListmodel like = dao.mypagelikeck(board_idx);
		
		
		String likeck;
		if(like ==null) {
			//좋아요 이미 해당 user 가 체크함 해당 게시물에 
		}else {
			like.setLikeck("ck");
				//체크안함 
			}
		
		return like ;
		
	}

	

}
