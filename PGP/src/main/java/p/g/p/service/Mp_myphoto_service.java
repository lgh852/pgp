package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Board;
import p.g.p.model.Join_board_boardphoto;

public class Mp_myphoto_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private Mp_dao dao;

	public List<Join_board_boardphoto> Mp_MyphotoList(int member_idx) {
		

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);

		List<Join_board_boardphoto> list = dao.selectMyPhotoList(member_idx);

		return list;

	}

}
