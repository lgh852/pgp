package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Join_Board_MemberInfo {
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

	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_nickname;
	private String member_birth;
	private String member_phone;
	private String member_intro;
	private String member_gender;
	private MultipartFile photofile;
	private String member_photo;
	public Join_Board_MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Join_Board_MemberInfo(int board_idx, String board_title, String board_contents, int board_cnt,
			int board_comment, int board_like, int board_scrap, Date board_regdate, int member_idx, int category_idx,
			int category_idx2, String member_id, String member_pw, String member_name, String member_nickname,
			String member_birth, String member_phone, String member_intro, String member_gender,
			MultipartFile photofile, String member_photo) {
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
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_nickname = member_nickname;
		this.member_birth = member_birth;
		this.member_phone = member_phone;
		this.member_intro = member_intro;
		this.member_gender = member_gender;
		this.photofile = photofile;
		this.member_photo = member_photo;
	}
	@Override
	public String toString() {
		return "Join_Board_MemberInfo [board_idx=" + board_idx + ", board_title=" + board_title + ", board_contents="
				+ board_contents + ", board_cnt=" + board_cnt + ", board_comment=" + board_comment + ", board_like="
				+ board_like + ", board_scrap=" + board_scrap + ", board_regdate=" + board_regdate + ", member_idx="
				+ member_idx + ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + ", member_id="
				+ member_id + ", member_pw=" + member_pw + ", member_name=" + member_name + ", member_nickname="
				+ member_nickname + ", member_birth=" + member_birth + ", member_phone=" + member_phone
				+ ", member_intro=" + member_intro + ", member_gender=" + member_gender + ", photofile=" + photofile
				+ ", member_photo=" + member_photo + "]";
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_intro() {
		return member_intro;
	}
	public void setMember_intro(String member_intro) {
		this.member_intro = member_intro;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public MultipartFile getPhotofile() {
		return photofile;
	}
	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
	public String getMember_photo() {
		return member_photo;
	}
	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}
	
	
	
}
