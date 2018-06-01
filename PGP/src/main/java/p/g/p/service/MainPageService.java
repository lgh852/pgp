package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.MainPageDao;
import p.g.p.model.Board_Photo;

public class MainPageService {

	MainPageDao dao;
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	
	public List<Board_Photo> mainimg() {
		
		dao= sessionTemplate.getMapper(MainPageDao.class);
		List<Board_Photo> list = dao.maxcntimg();
		if(list!=null) {
			//실행성공 
		}else {
			//실행 실패
			list = null;
		}
		return list;
	}

}
