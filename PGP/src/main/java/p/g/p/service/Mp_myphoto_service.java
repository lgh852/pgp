package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Board;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;

public class Mp_myphoto_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private Mp_dao dao;

	public List<Join_board_boardphoto> Mp_MyphotoList(int member_idx) {
		

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);

		List<Join_board_boardphoto> list = dao.selectMyPhotoList(member_idx);

		return list;

	}

	public List<PhotoListmodel> myPhotolistview(Like like,int member_idx) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		
		List<PhotoListmodel> list = dao.myphotolist(member_idx);
		
		return list;
	}

}
