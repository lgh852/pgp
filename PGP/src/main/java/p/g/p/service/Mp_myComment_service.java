package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Board_Comment;
import p.g.p.model.Member_info;

public class Mp_myComment_service {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Mp_dao dao;
	
	public List<Board_Comment> Mp_myCommentList(Member_info member){
		
		System.out.println("서비스에서 member를 확인해볼게"+member);
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		
		List<Board_Comment> list = dao.selectMyCommentList(member);
		
		
		
		return list;
		
	}

}
