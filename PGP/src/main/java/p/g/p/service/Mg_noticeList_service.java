package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.dao.PageMakerDao;
import p.g.p.model.Notice;
import p.g.p.model.PageMaker;

public class Mg_noticeList_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private PageMakerDao dao2;

	public int noticetestcount() {

		dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

		int noticeListCount = dao2.testcount();

		if (noticeListCount > 0) {

		} else {
			noticeListCount = 0;
		}

		return noticeListCount;
	}

	public List<Notice> noticeList(PageMaker pagemaker) {
		
		dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

		List<Notice> list = dao2.noticelist(pagemaker);

        return list;
	}

}
