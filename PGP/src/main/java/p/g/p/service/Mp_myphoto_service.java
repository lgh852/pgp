package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Board;

public class Mp_myphoto_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private Mp_dao dao;

	public List<Board> Mp_MyphotoList(String member_id) {
		

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);

		List<Board> list = dao.selectMyPhotoList(member_id);

		return list;

	}

}
