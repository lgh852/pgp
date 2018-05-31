package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoleeDao;
import p.g.p.model.Like;

public class PhotoListLeeService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private PhotoleeDao dao;

	public int listLikeup(Like like) {

		dao = sqlSessionTemplate.getMapper(PhotoleeDao.class);


		int resultcnt = dao.likeUp(like);


		if (resultcnt > 0) {

		} else {
			resultcnt = 0;
		}
		return resultcnt;
	}

	public Like likeck(Like like) {

		dao = sqlSessionTemplate.getMapper(PhotoleeDao.class);
		like = dao.selectlikeck(like);
		// 성공여부에 상관없이 반환
	
		return like;
	}

	public int updateLikecntUP(Like like) {
		dao = sqlSessionTemplate.getMapper(PhotoleeDao.class);
	
		int resultcnt = dao.likeupdatUp(like);
		if (resultcnt > 0) {
			// 성공
		} else {
			resultcnt = -1;
		}
		return resultcnt;
	}

	public int udateLikecntDown(Like like) {
		dao = sqlSessionTemplate.getMapper(PhotoleeDao.class);
		int result = dao.likeupdatDown(like);

		if (result > 0) {

		} else {
			result = -1;
		}
		return result;
	}

	public int deltelike(Like likeck) {
		dao = sqlSessionTemplate.getMapper(PhotoleeDao.class);

		int reslut = dao.deletelike(likeck);

		if (reslut > 0) {
			// 성공
		} else {
			reslut = -1;
		}
		return reslut;
	}

}
