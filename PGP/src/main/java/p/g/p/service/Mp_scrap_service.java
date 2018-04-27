package p.g.p.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;



import p.g.p.dao.Mp_dao;
import p.g.p.model.Board_Photo;

public class Mp_scrap_service {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Mp_dao dao;
	
	public List<Board_Photo> Mp_ScrapList(String member_id) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		
		List<Board_Photo> list = dao.selectScrapPhotoList(member_id);
		
		return list;
	}
	
	

}
