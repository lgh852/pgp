package p.g.p.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class StoryBoard {
	private int storyboard_idx;
	private String storyboard_contents; //스토리내용
	private Date storyboard_regdate;//스토리 저장일
	private String storyboard_photo;//스토리 사진
	private MultipartFile FileName;
	private int storyboard_like;// 좋아요수 
	private int member_idx;
	
	public StoryBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoryBoard(int storyboard_idx, String storyboard_contents, Date storyboard_regdate, String storyboard_photo,
			MultipartFile fileName, int storyboard_like, int member_idx) {
		super();
		this.storyboard_idx = storyboard_idx;
		this.storyboard_contents = storyboard_contents;
		this.storyboard_regdate = storyboard_regdate;
		this.storyboard_photo = storyboard_photo;
		FileName = fileName;
		this.storyboard_like = storyboard_like;
		this.member_idx = member_idx;
	}

	@Override
	public String toString() {
		return "storyboard [storyboard_idx=" + storyboard_idx + ", storyboard_contents=" + storyboard_contents
				+ ", storyboard_regdate=" + storyboard_regdate + ", storyboard_photo=" + storyboard_photo
				+ ", FileName=" + FileName + ", storyboard_like=" + storyboard_like + ", member_idx=" + member_idx
				+ "]";
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

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	
	

}
