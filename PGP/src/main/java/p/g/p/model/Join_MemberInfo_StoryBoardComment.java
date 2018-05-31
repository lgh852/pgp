package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Join_MemberInfo_StoryBoardComment {
	// 멤버정보
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

	// 스토리 댓글
	private int storyboard_comment_idx;
	private int storyboard_idx;
	private String storyboard_comment_contents;
	private Date storyboard_comment_regdate;
	
	
	public Join_MemberInfo_StoryBoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Join_MemberInfo_StoryBoardComment(int member_idx, String member_id, String member_pw, String member_name,
			String member_nickname, String member_birth, String member_phone, String member_intro, String member_gender,
			MultipartFile photofile, String member_photo, int storyboard_comment_idx, int storyboard_idx,
			String storyboard_comment_contents, Date storyboard_comment_regdate) {
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
		this.storyboard_comment_idx = storyboard_comment_idx;
		this.storyboard_idx = storyboard_idx;
		this.storyboard_comment_contents = storyboard_comment_contents;
		this.storyboard_comment_regdate = storyboard_comment_regdate;
	}
	@Override
	public String toString() {
		return "Join_MemberInfo_StoryBoardComment [member_idx=" + member_idx + ", member_id=" + member_id
				+ ", member_pw=" + member_pw + ", member_name=" + member_name + ", member_nickname=" + member_nickname
				+ ", member_birth=" + member_birth + ", member_phone=" + member_phone + ", member_intro=" + member_intro
				+ ", member_gender=" + member_gender + ", photofile=" + photofile + ", member_photo=" + member_photo
				+ ", storyboard_comment_idx=" + storyboard_comment_idx + ", storyboard_idx=" + storyboard_idx
				+ ", storyboard_comment_contents=" + storyboard_comment_contents + ", storyboard_comment_regdate="
				+ storyboard_comment_regdate + "]";
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
	public int getStoryboard_comment_idx() {
		return storyboard_comment_idx;
	}
	public void setStoryboard_comment_idx(int storyboard_comment_idx) {
		this.storyboard_comment_idx = storyboard_comment_idx;
	}
	public int getStoryboard_idx() {
		return storyboard_idx;
	}
	public void setStoryboard_idx(int storyboard_idx) {
		this.storyboard_idx = storyboard_idx;
	}
	public String getStoryboard_comment_contents() {
		return storyboard_comment_contents;
	}
	public void setStoryboard_comment_contents(String storyboard_comment_contents) {
		this.storyboard_comment_contents = storyboard_comment_contents;
	}
	public Date getStoryboard_comment_regdate() {
		return storyboard_comment_regdate;
	}
	public void setStoryboard_comment_regdate(Date storyboard_comment_regdate) {
		this.storyboard_comment_regdate = storyboard_comment_regdate;
	}




}
