package p.g.p.model;

import org.springframework.web.multipart.MultipartFile;

public class Member_info {

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
	public Member_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member_info(int member_idx, String member_id, String member_pw, String member_name, String member_nickname,
			String member_birth, String member_phone, String member_intro, String member_gender,
			MultipartFile photofile, String member_photo) {
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
	}
	@Override
	public String toString() {
		return "Member_info [member_idx=" + member_idx + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_nickname=" + member_nickname + ", member_birth="
				+ member_birth + ", member_phone=" + member_phone + ", member_intro=" + member_intro
				+ ", member_gender=" + member_gender + ", photofile=" + photofile + ", member_photo=" + member_photo
				+ "]";
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


}