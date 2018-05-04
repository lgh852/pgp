package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoFeedDao;
import p.g.p.model.Board_Photo;

public class PhotofeedService {
	
	PhotoFeedDao dao;
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public  List<Board_Photo> BoardPhotoList(){
		dao = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		List<Board_Photo> list = dao.selectPhotoFeed();
		return list;
	}

}
