package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PhotoListmodel {
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
	private String category_room;
	private String category_space;
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
	private int like_idx;
	private int like_check;
	private String likeck;
	private String Alignment;
	private String room;
	private String space;
	private String search;
	private String choice;
	private String scrapck;
	public PhotoListmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhotoListmodel(int board_idx, String board_title, String board_contents, int board_cnt, int board_comment,
			int board_like, int board_scrap, Date board_regdate, int member_idx, int category_idx, int category_idx2,
			int photo_idx, String photo_name, MultipartFile fileName, String category_room, String category_space,
			String member_id, String member_pw, String member_name, String member_nickname, String member_birth,
			String member_phone, String member_intro, String member_gender, MultipartFile photofile,
			String member_photo, int like_idx, int like_check, String likeck, String alignment, String room,
			String space, String search, String choice, String scrapck) {
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
		this.category_room = category_room;
		this.category_space = category_space;
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
		this.like_idx = like_idx;
		this.like_check = like_check;
		this.likeck = likeck;
		Alignment = alignment;
		this.room = room;
		this.space = space;
		this.search = search;
		this.choice = choice;
		this.scrapck = scrapck;
	}
	@Override
	public String toString() {
		return "PhotoListmodel [board_idx=" + board_idx + ", board_title=" + board_title + ", board_contents="
				+ board_contents + ", board_cnt=" + board_cnt + ", board_comment=" + board_comment + ", board_like="
				+ board_like + ", board_scrap=" + board_scrap + ", board_regdate=" + board_regdate + ", member_idx="
				+ member_idx + ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + ", photo_idx="
				+ photo_idx + ", photo_name=" + photo_name + ", FileName=" + FileName + ", category_room="
				+ category_room + ", category_space=" + category_space + ", member_id=" + member_id + ", member_pw="
				+ member_pw + ", member_name=" + member_name + ", member_nickname=" + member_nickname
				+ ", member_birth=" + member_birth + ", member_phone=" + member_phone + ", member_intro=" + member_intro
				+ ", member_gender=" + member_gender + ", photofile=" + photofile + ", member_photo=" + member_photo
				+ ", like_idx=" + like_idx + ", like_check=" + like_check + ", likeck=" + likeck + ", Alignment="
				+ Alignment + ", room=" + room + ", space=" + space + ", search=" + search + ", choice=" + choice
				+ ", scrapck=" + scrapck + "]";
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
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public int getLike_check() {
		return like_check;
	}
	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	public String getLikeck() {
		return likeck;
	}
	public void setLikeck(String likeck) {
		this.likeck = likeck;
	}
	public String getAlignment() {
		return Alignment;
	}
	public void setAlignment(String alignment) {
		Alignment = alignment;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getScrapck() {
		return scrapck;
	}
	public void setScrapck(String scrapck) {
		this.scrapck = scrapck;
	}
	
}
