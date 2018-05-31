package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Join_MemberInfo_StoryBoard {
	//멤버정보
	private int member_idx;
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
	
	
	//스토리보드 
	private int storyboard_idx;
	private String storyboard_contents; //스토리내용
	private Date storyboard_regdate;//스토리 저장일
	private String storyboard_photo;//스토리 사진
	private MultipartFile FileName;
	private int storyboard_like;// 좋아요수 
	
	private int like_idx;
	private int board_idx;
	private int like_check;
	
	private String likeck;
	public Join_MemberInfo_StoryBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Join_MemberInfo_StoryBoard(int member_idx, String member_id, String member_pw, String member_name,
			String member_nickname, String member_birth, String member_phone, String member_intro, String member_gender,
			MultipartFile photofile, String member_photo, int storyboard_idx, String storyboard_contents,
			Date storyboard_regdate, String storyboard_photo, MultipartFile fileName, int storyboard_like, int like_idx,
			int board_idx, int like_check, String likeck) {
		super();
		this.member_idx = member_idx;
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
		this.storyboard_idx = storyboard_idx;
		this.storyboard_contents = storyboard_contents;
		this.storyboard_regdate = storyboard_regdate;
		this.storyboard_photo = storyboard_photo;
		FileName = fileName;
		this.storyboard_like = storyboard_like;
		this.like_idx = like_idx;
		this.board_idx = board_idx;
		this.like_check = like_check;
		this.likeck = likeck;
	}


	@Override
	public String toString() {
		return "Join_MemberInfo_StoryBoard [member_idx=" + member_idx + ", member_id=" + member_id + ", member_pw="
				+ member_pw + ", member_name=" + member_name + ", member_nickname=" + member_nickname
				+ ", member_birth=" + member_birth + ", member_phone=" + member_phone + ", member_intro=" + member_intro
				+ ", member_gender=" + member_gender + ", photofile=" + photofile + ", member_photo=" + member_photo
				+ ", storyboard_idx=" + storyboard_idx + ", storyboard_contents=" + storyboard_contents
				+ ", storyboard_regdate=" + storyboard_regdate + ", storyboard_photo=" + storyboard_photo
				+ ", FileName=" + FileName + ", storyboard_like=" + storyboard_like + ", like_idx=" + like_idx
				+ ", board_idx=" + board_idx + ", like_check=" + like_check + ", likeck=" + likeck + "]";
	}

	public String getLikeck() {
		return likeck;
	}

	public void setLikeck(String likeck) {
		this.likeck = likeck;
	}

	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
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
	public int getStoryboard_idx() {
		return storyboard_idx;
	}
	public void setStoryboard_idx(int storyboard_idx) {
		this.storyboard_idx = storyboard_idx;
	}
	public String getStoryboard_contents() {
		return storyboard_contents;
	}
	public void setStoryboard_contents(String storyboard_contents) {
		this.storyboard_contents = storyboard_contents;
	}
	public Date getStoryboard_regdate() {
		return storyboard_regdate;
	}
	public void setStoryboard_regdate(Date storyboard_regdate) {
		this.storyboard_regdate = storyboard_regdate;
	}
	public String getStoryboard_photo() {
		return storyboard_photo;
	}
	public void setStoryboard_photo(String storyboard_photo) {
		this.storyboard_photo = storyboard_photo;
	}
	public MultipartFile getFileName() {
		return FileName;
	}
	public void setFileName(MultipartFile fileName) {
		FileName = fileName;
	}
	public int getStoryboard_like() {
		return storyboard_like;
	}
	public void setStoryboard_like(int storyboard_like) {
		this.storyboard_like = storyboard_like;
	}
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
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

	
	
}
