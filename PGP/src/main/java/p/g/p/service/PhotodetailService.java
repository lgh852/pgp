package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDao;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Member_info;

public class PhotodetailService {

	
	PhotoDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int ListInsertComment(Board_Comment  board_comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		System.out.println("댓글 성공"+board_comment);
		int resultCnt = dao.insertComment(board_comment);
			if(resultCnt>0) {
				System.out.println("댓글성공");
			}else {
				resultCnt = -1;
			}
		return resultCnt;
	}
	


	public List<Join_BoardComment_MemberInfo> ListselectCommentAll() {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		List<Join_BoardComment_MemberInfo> list= dao.selectCommentAll();
		
		return list;
		
	}
	
	public Board_Comment ListdeleteComment() {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		Board_Comment delete_C=dao.deleteComment();
		
		return delete_C;
	}
	

	
	
	
	
}
