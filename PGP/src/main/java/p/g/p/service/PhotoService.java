package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import p.g.p.dao.PhotoleeDao;
import p.g.p.model.PhotoListmodel;

@Controller
public class PhotoService {

	PhotoleeDao dao;
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<PhotoListmodel> photolistview(){
		
		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		List<PhotoListmodel> list = dao.photolist();
		if(list!=null) {
			
		}else {
			list = null;
		}
		return list;
	}
	
}
