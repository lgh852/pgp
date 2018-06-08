package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Member_info;

public interface MainPageDao {

	public List<Board_Photo> maxcntimg();

	public List<Board> selecttitle(int board_idx);
	public Board selecttitles(int board_idx);

	public List<Member_info> selectuserid(int member_idx); 
	public Member_info selectuserids(int member_idx); 
}
