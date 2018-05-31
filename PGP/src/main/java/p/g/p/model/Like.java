package p.g.p.model;

public class Like {
	
	private int like_idx;
	private int member_idx;
	private int board_idx;
	private int like_check;	
	private int storyboard_idx;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Like [like_idx=" + like_idx + ", member_idx=" + member_idx + ", board_idx=" + board_idx
				+ ", like_check=" + like_check + ", storyboard_idx=" + storyboard_idx + "]";
	}
	public Like(int like_idx, int member_idx, int board_idx, int like_check, int storyboard_idx) {
		super();
		this.like_idx = like_idx;
		this.member_idx = member_idx;
		this.board_idx = board_idx;
		this.like_check = like_check;
		this.storyboard_idx = storyboard_idx;
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
	public int getLike_check() {
		return like_check;
	}
	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	public int getStoryboard_idx() {
		return storyboard_idx;
	}
	public void setStoryboard_idx(int storyboard_idx) {
		this.storyboard_idx = storyboard_idx;
	}
	


}
