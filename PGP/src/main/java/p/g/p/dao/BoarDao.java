package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Category_Room;
import p.g.p.model.Category_Space;

public interface BoarDao {

	public int spaceisnert(Category_Space space);

	public int roomisnert(Category_Room room);

	public int photoinsert(Board_Photo photo);
	
	public int Boardinsert(Board board);

	public List<Board_Photo>photoselect(int board_idx); 

}
