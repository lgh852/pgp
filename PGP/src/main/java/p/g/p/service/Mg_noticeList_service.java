package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Notice;

public class Mg_noticeList_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private ManagerDao dao;

	public List<Notice> getNoticeList() {
		
		dao = sqlSessionTemplate.getMapper(ManagerDao.class);

		List<Notice> list = dao.selectNoticeList();

		return list;
	}

}
