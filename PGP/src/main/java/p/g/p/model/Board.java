package p.g.p.model;

import java.util.Date;

public class Board {

	private int board_idx;//번호
	private String board_title;//제목
	private String board_contents;//내용
	private int board_cnt;//조회수
	private int board_comment;//댓글수
	private int board_like;//좋아요수
	private int board_scrap;//스크랩수
	private Date board_regdate;//작성일
	private int member_idx;//회원번호
	private int category_idx;//공간
	private int category_idx2;//평수
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int board_idx, String board_title, String board_contents, int board_cnt, int board_comment,
			int board_like, int board_scrap, Date board_regdate, int member_idx, int category_idx, int category_idx2) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_cnt = board_cnt;
		this.board_comment = board_comment;
		this.board_like = board_like;
		this.board_scrap = board_scrap;
		this.board_regdate = board_regdate;
		this.member_idx = member_idx;
		this.category_idx = category_idx;
		this.category_idx2 = category_idx2;
	}
	@Override
	public String toString() {
		return "BoardModel [board_idx=" + board_idx + ", board_title=" + board_title + ", board_contents="
				+ board_contents + ", board_cnt=" + board_cnt + ", board_comment=" + board_comment + ", board_like="
				+ board_like + ", board_scrap=" + board_scrap + ", board_regdate=" + board_regdate + ", member_idx="
				+ member_idx + ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + "]";
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	public int getBoard_comment() {
		return board_comment;
	}
	public void setBoard_comment(int board_comment) {
		this.board_comment = board_comment;
	}
	public int getBoard_like() {
		return board_like;
	}
	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}
	public int getBoard_scrap() {
		return board_scrap;
	}
	public void setBoard_scrap(int board_scrap) {
		this.board_scrap = board_scrap;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
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
	
	
}
