package p.g.p.model;


public class Join_Board_Category_RoomNSpace {

	private int board_idx;//번호
	private int member_idx;//회원번호
	private int category_idx;//공간
	private int category_idx2;//평수
	
	private String category_room;
	private String category_space;
	
	public Join_Board_Category_RoomNSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Join_Board_Category_RoomNSpace(int board_idx, int member_idx, int category_idx, int category_idx2,
			String category_room, String category_space) {
		super();
		this.board_idx = board_idx;
		this.member_idx = member_idx;
		this.category_idx = category_idx;
		this.category_idx2 = category_idx2;
		this.category_room = category_room;
		this.category_space = category_space;
	}
	@Override
	public String toString() {
		return "Join_Board_Category_RoomNSpace [board_idx=" + board_idx + ", member_idx=" + member_idx
				+ ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + ", category_room="
				+ category_room + ", category_space=" + category_space + "]";
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}
	public int getCategory_idx2() {
		return category_idx2;
	}
	public void setCategory_idx2(int category_idx2) {
		this.category_idx2 = category_idx2;
	}
	public String getCategory_room() {
		return category_room;
	}
	public void setCategory_room(String category_room) {
		this.category_room = category_room;
	}
	public String getCategory_space() {
		return category_space;
	}
	public void setCategory_space(String category_space) {
		this.category_space = category_space;
	}

	
	
}
