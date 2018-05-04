package p.g.p.model;

public class like {
	
	private int like_idx;
	private int member_idx;
	private int board_idx;
	
	public like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public like(int like_idx, int member_idx, int board_idx) {
		super();
		this.like_idx = like_idx;
		this.member_idx = member_idx;
		this.board_idx = board_idx;
	}
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	@Override
	public String toString() {
		return "like [like_idx=" + like_idx + ", member_idx=" + member_idx + ", board_idx=" + board_idx + "]";
	}
	
	

}
