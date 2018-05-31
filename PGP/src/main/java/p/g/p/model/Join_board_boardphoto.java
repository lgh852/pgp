package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Join_board_boardphoto {

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
	
	private int photo_idx;
	private String photo_name;
	private MultipartFile FileName;
	
	public Join_board_boardphoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Join_board_boardphoto(int board_idx, String board_title, String board_contents, int board_cnt,
			int board_comment, int board_like, int board_scrap, Date board_regdate, int member_idx, int category_idx,
			int category_idx2, int photo_idx, String photo_name, MultipartFile fileName) {
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
		this.photo_idx = photo_idx;
		this.photo_name = photo_name;
		FileName = fileName;
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

	public int getPhoto_idx() {
		return photo_idx;
	}

	public void setPhoto_idx(int photo_idx) {
		this.photo_idx = photo_idx;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public MultipartFile getFileName() {
		return FileName;
	}

	public void setFileName(MultipartFile fileName) {
		FileName = fileName;
	}

	@Override
	public String toString() {
		return "Join_board_boardphoto [board_idx=" + board_idx + ", board_title=" + board_title + ", board_contents="
				+ board_contents + ", board_cnt=" + board_cnt + ", board_comment=" + board_comment + ", board_like="
				+ board_like + ", board_scrap=" + board_scrap + ", board_regdate=" + board_regdate + ", member_idx="
				+ member_idx + ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + ", photo_idx="
				+ photo_idx + ", photo_name=" + photo_name + ", FileName=" + FileName + "]";
	}
	
	
	
}
