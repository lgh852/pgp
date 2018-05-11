package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import p.g.p.dao.PhotoleeDao;
import p.g.p.model.Like;
import p.g.p.model.PhotoListmodel;

@Controller
public class PhotoService {

	PhotoleeDao dao;
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<PhotoListmodel> photolistview(Like like){
		
		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		List<PhotoListmodel> list = dao.photolist();
		
		List<Like> likelist = selectimg(like);
		for(int i=0;i<list.size();i++) {
			int photoidx =  list.get(i).getBoard_idx();
			for(int x=0;x<likelist.size();x++) {
			int listidx = likelist.get(x).getBoard_idx();
				if(photoidx==listidx) {
					list.get(i).setLikeck("ss");
				}
			}
		}
		
		if(list!=null) {
		
		}else {
			list = null;
		}
		return list;
	}
	
	public List<Like> selectimg(Like like){
		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		List<Like> likelist = dao.seleteimg(like);
		
		if(likelist!=null) {
					}else {
			likelist =null;
		}
		
		return likelist;
	}
	
}
