package p.g.p.model;

public class Scrap {
	
	private int scrap_idx;
	private String scrap_name;
	private int board_idx;
	private int member_idx;
	
	public Scrap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Scrap(int scrap_idx, String scrap_name, int board_idx, int member_idx) {
		super();
		this.scrap_idx = scrap_idx;
		this.scrap_name = scrap_name;
		this.board_idx = board_idx;
		this.member_idx = member_idx;
	}

	public int getScrap_idx() {
		return scrap_idx;
	}
	public void setScrap_idx(int scrap_idx) {
		this.scrap_idx = scrap_idx;
	}
	public String getScrap_name() {
		return scrap_name;
	}
	public void setScrap_name(String scrap_name) {
		this.scrap_name = scrap_name;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}



	@Override
	public String toString() {
		return "Scrap [scrap_idx=" + scrap_idx + ", scrap_name=" + scrap_name + ", board_idx=" + board_idx
				+ ", member_idx=" + member_idx + "]";
	}

	
	

	
	
}
