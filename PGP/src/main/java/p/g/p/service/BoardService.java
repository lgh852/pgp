package p.g.p.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.BoarDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Category_Room;
import p.g.p.model.Category_Space;
import p.g.p.model.Member_info;
import p.g.p.model.Url_Tag;

public class BoardService {

	BoarDao dao;

	@Autowired
	SqlSessionTemplate sessionTemplate;

	@Autowired
	BoardPhotoUpLoad photoup;

	public int insertroom(Category_Room room) {
		dao = sessionTemplate.getMapper(BoarDao.class);
		int resultCnt = dao.roomisnert(room);
		if (resultCnt < 0) {
			resultCnt = -1;
		}

		return resultCnt;
	}

	public int insertspace(Category_Space space) {
		dao = sessionTemplate.getMapper(BoarDao.class);
		int resultCnt = dao.spaceisnert(space);
		if (resultCnt < 0) {
			resultCnt = -1;
		}
		return resultCnt;
	}

	// 파일이름 저장하는 디비 실행 하는 메서드
	public int insertPhotoName(Board_Photo photo) {
		dao = sessionTemplate.getMapper(BoarDao.class);
		int resultCnt = dao.photoinsert(photo);
		if (resultCnt < 0) {
			resultCnt = -1;
		}
		return resultCnt;
	}

	public int Boardinsert(Board board) {
		dao = sessionTemplate.getMapper(BoarDao.class);
		int resultCnt = dao.Boardinsert(board);
		if (resultCnt < 0) {
			resultCnt = -1;
		}

		return resultCnt;

	}

	public int BoardAllService(HttpServletRequest request, Board_Photo photo, Category_Room room, Category_Space space,
			Board board, HttpSession session) throws IllegalStateException, IOException {
		int result = 0;
		// 사진업로드
		if (room.getCategory_room()!=null) {
			int resultroom = insertroom(room);
			// idx 가져와서 넣어줌 key 값으로
			board.setCategory_idx(room.getCategory_idx());
		}
		

		if (space.getCategory_space() != null) {
			int resultspace = insertspace(space);
			// idx 가져와서 넣어줌 key 값으로
			board.setCategory_idx2(space.getCategory_idx());
		}
		// 게시글 업데이트

		Member_info member = (Member_info) session.getAttribute("user");		
		if (member != null) {
			board.setMember_idx(member.getMember_idx());

		}
		if (board != null) {
			
			result = Boardinsert(board);
			photo.setBoard_idx(board.getBoard_idx());
			
		}else {
			result = -1;
		}
		

		
		if (photo != null) {
			photo.setBoard_idx(board.getBoard_idx());
			// 사진업로드
			photoup.fileupload(request, session, photo);
			result = insertPhotoName(photo);

		}else {
			result = -1;
		}
		
		return result;
		
	}

	public 	List<Board_Photo> photoSelect(Board board) {
		int board_idx = board.getBoard_idx();
		dao = sessionTemplate.getMapper(BoarDao.class);
		List<Board_Photo> listPhoto = dao.photoselect(board_idx);
		if(listPhoto != null) {
		
		}else {
			listPhoto = null;
		}
		
		return listPhoto;
	}
	public Board_Photo phototagselect(String board_idx) {
		
		dao = sessionTemplate.getMapper(BoarDao.class);
		
		Board_Photo photo = dao.photoTagformselect(board_idx);
		
		if(photo!=null) {
			
		}else {
			photo = null;
		}
		
		
		
		 
		return photo;
				
	}

	public int taginsert(Url_Tag tag) {
		
		dao = sessionTemplate.getMapper(BoarDao.class);
		int check;
		int count = dao.tagnocount(tag);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		
		if(count>=0&&count<5) {
			tag.setTag_no(count+1);
			int result = dao.taginsert(tag);
			//count 햇을때 나온 수에다 +1의 값을 저장해줌 그수를 다시 no에 저장 
			
			if(result>0) {
				check = tag.getTag_no();
			}else {
				check = 15;
				//저장불가 
			}

		}else {
			//no가 5개 이상일경우 더이상 행성할수 없다는 태그 
			check = 55;
		}
		
				
		return check;
	}

}
