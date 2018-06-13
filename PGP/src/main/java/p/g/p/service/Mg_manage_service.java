package p.g.p.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Notice;
import p.g.p.model.report;

public class Mg_manage_service {

	@Autowired
	private SqlSessionTemplate s;
	
	private ManagerDao dao;
	
	public int deleteNoticeList(int notice_idx) {
		
		dao = s.getMapper(ManagerDao.class);
		
		int resultCnt = dao.deleteByIdx(notice_idx);
		
		
		return resultCnt;
	}

	public Notice updateSelect(int notice_idx) {
		
		Notice notice;
		dao = s.getMapper(ManagerDao.class);
		notice = dao.selectByNoticeIdx(notice_idx);
		
		return notice;
	}
	
	public int updateNoticeList(Notice notice, HttpServletRequest request) {
		
		dao = s.getMapper(ManagerDao.class);
		
		int result = dao.updateByIdx(notice);
		
		return result;
		
	}

	public List<report> selectReportList() {
		
		dao=s.getMapper(ManagerDao.class);
		
		List<report> r = dao.selectReportList();
		
		return r;
	}

}
