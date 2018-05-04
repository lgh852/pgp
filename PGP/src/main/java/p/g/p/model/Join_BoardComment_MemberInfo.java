package p.g.p.model;

import java.util.Date;

public class Join_BoardComment_MemberInfo {
	private String member_id;
	private int board_comment_idx;
	private String board_comment_contents;
	private Date board_comment_regdate;
	private int member_idx;
	private int board_idx;
	public Join_BoardComment_MemberInfo(String member_id, int board_comment_idx, String board_comment_contents,
			Date board_comment_regdate, int member_idx, int board_idx) {
		super();
		this.member_id = member_id;
		this.board_comment_idx = board_comment_idx;
		this.board_comment_contents = board_comment_contents;
		this.board_comment_regdate = board_comment_regdate;
		this.member_idx = member_idx;
		this.board_idx = board_idx;
	}
	public Join_BoardComment_MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Join_BoardComment_MemberInfo [member_id=" + member_id + ", board_comment_idx=" + board_comment_idx
				+ ", board_comment_contents=" + board_comment_contents + ", board_comment_regdate="
				+ board_comment_regdate + ", member_idx=" + member_idx + ", board_idx=" + board_idx + "]";
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getBoard_comment_idx() {
		return board_comment_idx;
	}
	public void setBoard_comment_idx(int board_comment_idx) {
		this.board_comment_idx = board_comment_idx;
	}
	public String getBoard_comment_contents() {
		return board_comment_contents;
	}
	public void setBoard_comment_contents(String board_comment_contents) {
		this.board_comment_contents = board_comment_contents;
	}
	public Date getBoard_comment_regdate() {
		return board_comment_regdate;
	}
	public void setBoard_comment_regdate(Date board_comment_regdate) {
		this.board_comment_regdate = board_comment_regdate;
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
	
	
	
	
}
