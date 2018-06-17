package p.g.p.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import p.g.p.dao.PhotoleeDao;
import p.g.p.model.Board_Photo;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;

@Controller
public class PhotoService {

	PhotoleeDao dao;

	@Autowired
	SqlSessionTemplate sessionTemplate;

	public List<PhotoListmodel> photolistview(Like like, PhotoListmodel photolist, Member_info member) {

		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		List<PhotoListmodel> list;

		if (photolist.getAlignment().equals("board_cnt")) {
			// cnt꺼 실행
			list = dao.photolistcnt(photolist);

		} else if (photolist.getAlignment().equals("board_like")) {
			// like 실행
			list = dao.photolistlike(photolist);

		} else {
			// 일반 정렬

			list = dao.photolist(photolist);

		}

		if (member != null) {
			like.setMember_idx(member.getMember_idx());

			list = listlikeck(list, like);

			if (list != null) {

			} else {
				list = null;

			}

		}

		return list;

	}

	public List<PhotoListmodel> listlikeck(List<PhotoListmodel> list, Like like) {

		List<Like> likelist = selectimg(like);

		for (int i = 0; i < list.size(); i++) {

			int photoidx = list.get(i).getBoard_idx();

			for (int x = 0; x < likelist.size(); x++) {

				int listidx = likelist.get(x).getBoard_idx();

				if (photoidx == listidx) {

					list.get(i).setLikeck("ss");

				}
			}
		}
		return list;
	}

	public List<Like> selectimg(Like like) {
		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		List<Like> likelist = dao.seleteimg(like);

		if (likelist != null) {

		} else {

			likelist = null;
		}

		return likelist;
	}

	public int listLikeup(Like like) {

		dao = sessionTemplate.getMapper(PhotoleeDao.class);

		int resultcnt = dao.likeUp(like);

		if (resultcnt > 0) {

		} else {
			resultcnt = 0;
		}
		return resultcnt;
	}

	public Like likeck(Like like) {

		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		like = dao.selectlikeck(like);
		// 성공여부에 상관없이 반환

		return like;
	}

	public int updateLikecntUP(Like like) {
		dao = sessionTemplate.getMapper(PhotoleeDao.class);

		int resultcnt = dao.likeupdatUp(like);
		if (resultcnt > 0) {
			// 성공
		} else {
			resultcnt = -1;
		}
		return resultcnt;
	}

	public int udateLikecntDown(Like like) {
		dao = sessionTemplate.getMapper(PhotoleeDao.class);
		int result = dao.likeupdatDown(like);

		if (result > 0) {

		} else {
			result = -1;
		}
		return result;
	}

	public int deltelike(Like likeck) {
		dao = sessionTemplate.getMapper(PhotoleeDao.class);

		int reslut = dao.deletelike(likeck);

		if (reslut > 0) {
			// 성공
		} else {
			reslut = -1;
		}
		return reslut;
	}

	public void latestlist(HttpSession session, List<Board_Photo> latelylist, String photoName, Board_Photo photo) {
		int sessionck = 0;

		if (latelylist != null) {

			for (int i = 0; i < latelylist.size(); i++) {
				String listck = latelylist.get(i).getPhoto_name();
				System.out.println("현재 비교할 값이지롱" + listck);
				if (listck != null && photoName.equals(listck)) {
					// 값이 있고 기존리스트에 동일한 값이 있으면 생성안함
					sessionck = +1;
				} else {

				}

			}
			if (sessionck == 0) {

				latelylist.add(latelylist.size(), photo);

			}
			session.setAttribute("latelylist", latelylist);

		}

		else {
			latelylist = new ArrayList<Board_Photo>();
			latelylist.add(0, photo);
			session.setAttribute("latelylist", latelylist);
		}

	}

}