package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Notice;

public class Mg_noticeView_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private ManagerDao dao;

	public Notice viewNoticeContents(int notice_idx) {
		Notice notice;

		dao = sqlSessionTemplate.getMapper(ManagerDao.class);

		notice = dao.selectByNoticeIdx(notice_idx);

		return notice;

	}

}
