package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Member_info;

public interface Mp_dao {
	
	public Member_info selectById(String member_id);
	
    public int updateById(Member_info member);
    
    public List<Board_Photo> selectScrapPhotoList(String member_id);
    
    public List<Board> selectMyPhotoList(String member_id);

}
