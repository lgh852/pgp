package p.g.p.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Notice;

public class Mg_noticeInsert_service {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ManagerDao dao;
	
	
	//공지사항 입력하기 위한 서비스 
	public int noticeInsert(Notice notice) {
		
		
		dao = sqlSessionTemplate.getMapper(ManagerDao.class);
		
		
		
		int resultCnt = dao.insertNotice(notice);
		
		
		return resultCnt;
		
	}
	
	

}
