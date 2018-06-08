package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.MainPageDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Member_info;

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



	public List<Board> imgusertitle(List<Board_Photo> list) {
	
		System.out.println(list);
		System.out.println(list);
		
		dao= sessionTemplate.getMapper(MainPageDao.class);
		
		List<Board> boardlsit = dao.selecttitle(list.get(0).getBoard_idx());
		int x = 0;
		
	
		for(int i = 1;i<3;i++) {
			
			Board board = dao.selecttitles(list.get(i).getBoard_idx());
		
			boardlsit.add(i,board);
				
		}
		
		return boardlsit;
	}
	
	
	public List<Member_info> imguserid(List<Board> board){
		
		dao = sessionTemplate.getMapper(MainPageDao.class); 
		
		List<Member_info> memberlist = dao.selectuserid(board.get(0).getMember_idx());
		System.out.println(memberlist);
		for(int i =1;i<3;i++) {
			
			Member_info member  = dao.selectuserids(board.get(i).getMember_idx());
			
			memberlist.add(i,member);
			
		}
	
		
		
		return memberlist;
				
	}


}


