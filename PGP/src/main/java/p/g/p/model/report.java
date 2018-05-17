package p.g.p.model;

public class report {

	private int report_idx;
	private int board_idx;
	private int storyboard_idx;
	private String report_contents;
	private int member_idx;
	public report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public report(int report_idx, int board_idx, int storyboard_idx, String report_contents, int member_idx) {
		super();
		this.report_idx = report_idx;
		this.board_idx = board_idx;
		this.storyboard_idx = storyboard_idx;
		this.report_contents = report_contents;
		this.member_idx = member_idx;
	}
	public int getReport_idx() {
		return report_idx;
	}
	public void setReport_idx(int report_idx) {
		this.report_idx = report_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getStoryboard_idx() {
		return storyboard_idx;
	}
	public void setStoryboard_idx(int storyboard_idx) {
		this.storyboard_idx = storyboard_idx;
	}
	public String getReport_contents() {
		return report_contents;
	}
	public void setReport_contents(String report_contents) {
		this.report_contents = report_contents;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	@Override
	public String toString() {
		return "report [report_idx=" + report_idx + ", board_idx=" + board_idx + ", storyboard_idx=" + storyboard_idx
				+ ", report_contents=" + report_contents + ", member_idx=" + member_idx + "]";
	}
	
	
	
}
