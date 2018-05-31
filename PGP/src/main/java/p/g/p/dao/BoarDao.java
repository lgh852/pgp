package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Category_Room;
import p.g.p.model.Category_Space;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Url_Tag;

public interface BoarDao {

	public int spaceisnert(Category_Space space);

	public int roomisnert(Category_Room room);

	public int photoinsert(Board_Photo photo);
	
	public int Boardinsert(Board board);

	public List<Board_Photo>photoselect(int board_idx); 

	public Board_Photo photoTagformselect(String board_idx); 

	public int taginsert(Url_Tag tag);
	
	public int tagnocount(Url_Tag tag);
	
	public String selectTagInfo(Url_Tag tag);
	
	public int tagdelete(Url_Tag tag);
	

	public List<PhotoListmodel>boardsearch(PhotoListmodel listmodel);
	
	public List<PhotoListmodel>boardsearchlike(PhotoListmodel listmodel);
	
	public List<PhotoListmodel>boardsearchcnt(PhotoListmodel listmodel);
	
	

}

