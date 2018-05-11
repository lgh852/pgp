package p.g.p.dao;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Board_Category_RoomNSpace;

public interface PhotoDetailUpdateDao {
	
	public int UpdateBoard(Board board);
	public int UpdateBoardPhoto(Board_Photo board_photo);
	public int UpdateCategoryRoom(Join_Board_Category_RoomNSpace joinBoardRoom);
	public int UpdateCategorySpace(Join_Board_Category_RoomNSpace joinBoardSpace);
	
	
}
