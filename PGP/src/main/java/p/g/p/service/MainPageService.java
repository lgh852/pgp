package p.g.p.service;

import org.apache.log4j.chainsaw.Main;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.MainPageDao;

public class MainPageService {

	MainPageDao dao;
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	
	public String mainimg() {
		
		dao= sessionTemplate.getMapper(MainPageDao.class);
		String cntmaxfileName = dao.maxcntimg();
		if(cntmaxfileName!=null) {
			//실행성공 
		}else {
			//실행 실패
			cntmaxfileName = null;
		}
		return cntmaxfileName;
	}

}
