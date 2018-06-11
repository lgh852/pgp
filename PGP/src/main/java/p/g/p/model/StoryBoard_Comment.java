package p.g.p.model;

import java.util.Date;

public class StoryBoard_Comment {

	private int storyboard_comment_idx;
	private int storyboard_idx;
	private String storyboard_comment_contents;
	private Date storyboard_comment_regdate;
	private int member_idx;
	public StoryBoard_Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoryBoard_Comment(int storyboard_comment_idx, int storyboard_idx, String storyboard_comment_contents,
			Date storyboard_comment_regdate, int member_idx) {
		super();
		this.storyboard_comment_idx = storyboard_comment_idx;
		this.storyboard_idx = storyboard_idx;
		this.storyboard_comment_contents = storyboard_comment_contents;
		this.storyboard_comment_regdate = storyboard_comment_regdate;
		this.member_idx = member_idx;
	}
	@Override
	public String toString() {
		return "StoryBoard_Comment [storyboard_comment_idx=" + storyboard_comment_idx + ", storyboard_idx="
				+ storyboard_idx + ", storyboard_comment_contents=" + storyboard_comment_contents
				+ ", storyboard_comment_regdate=" + storyboard_comment_regdate + ", member_idx=" + member_idx + "]";
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
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	
}
	