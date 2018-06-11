package p.g.p.model;

import java.util.Date;

public class Join_BoardComment_MemberInfo {
	private String member_id;
	private int board_comment_idx;
	private String board_comment_contents;
	private Date board_comment_regdate;
	private int member_idx;
	private int board_idx;
	private int regroup; // 그룹
	private int reparent; // 부모
	private int redepth; // 깊이
	private int reorder; // 순서
	public Join_BoardComment_MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Join_BoardComment_MemberInfo(String member_id, int board_comment_idx, String board_comment_contents,
			Date board_comment_regdate, int member_idx, int board_idx, int regroup, int reparent, int redepth,
			int reorder) {
		super();
		this.member_id = member_id;
		this.board_comment_idx = board_comment_idx;
		this.board_comment_contents = board_comment_contents;
		this.board_comment_regdate = board_comment_regdate;
		this.member_idx = member_idx;
		this.board_idx = board_idx;
		this.regroup = regroup;
		this.reparent = reparent;
		this.redepth = redepth;
		this.reorder = reorder;
	}
	@Override
	public String toString() {
		return "Join_BoardComment_MemberInfo [member_id=" + member_id + ", board_comment_idx=" + board_comment_idx
				+ ", board_comment_contents=" + board_comment_contents + ", board_comment_regdate="
				+ board_comment_regdate + ", member_idx=" + member_idx + ", board_idx=" + board_idx + ", regroup="
				+ regroup + ", reparent=" + reparent + ", redepth=" + redepth + ", reorder=" + reorder + "]";
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
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getReparent() {
		return reparent;
	}
	public void setReparent(int reparent) {
		this.reparent = reparent;
	}
	public int getRedepth() {
		return redepth;
	}
	public void setRedepth(int redepth) {
		this.redepth = redepth;
	}
	public int getReorder() {
		return reorder;
	}
	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	
	
}
