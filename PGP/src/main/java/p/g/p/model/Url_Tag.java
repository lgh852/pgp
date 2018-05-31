package p.g.p.model;

public class Url_Tag {

	private int tag_idx;
	private String tag_url;
	private String tag_position_y;
	private int board_idx;
	private String tag_position_x;
	private int tag_no;
	private int tag_url_cnt;
	private String tag_url_img;
	private String tag_url_price;
	private String tag_url_title;
	public Url_Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Url_Tag(int tag_idx, String tag_url, String tag_position_y, int board_idx, String tag_position_x, int tag_no,
			int tag_url_cnt, String tag_url_img, String tag_url_price, String tag_url_title) {
		super();
		this.tag_idx = tag_idx;
		this.tag_url = tag_url;
		this.tag_position_y = tag_position_y;
		this.board_idx = board_idx;
		this.tag_position_x = tag_position_x;
		this.tag_no = tag_no;
		this.tag_url_cnt = tag_url_cnt;
		this.tag_url_img = tag_url_img;
		this.tag_url_price = tag_url_price;
		this.tag_url_title = tag_url_title;
	}
	@Override
	public String toString() {
		return "Url_Tag [tag_idx=" + tag_idx + ", tag_url=" + tag_url + ", tag_position_y=" + tag_position_y
				+ ", board_idx=" + board_idx + ", tag_position_x=" + tag_position_x + ", tag_no=" + tag_no
				+ ", tag_url_cnt=" + tag_url_cnt + ", tag_url_img=" + tag_url_img + ", tag_url_price=" + tag_url_price
				+ ", tag_url_title=" + tag_url_title + "]";
	}
	public int getTag_idx() {
		return tag_idx;
	}
	public void setTag_idx(int tag_idx) {
		this.tag_idx = tag_idx;
	}
	public String getTag_url() {
		return tag_url;
	}
	public void setTag_url(String tag_url) {
		this.tag_url = tag_url;
	}
	public String getTag_position_y() {
		return tag_position_y;
	}
	public void setTag_position_y(String tag_position_y) {
		this.tag_position_y = tag_position_y;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getTag_position_x() {
		return tag_position_x;
	}
	public void setTag_position_x(String tag_position_x) {
		this.tag_position_x = tag_position_x;
	}
	public int getTag_no() {
		return tag_no;
	}
	public void setTag_no(int tag_no) {
		this.tag_no = tag_no;
	}
	public int getTag_url_cnt() {
		return tag_url_cnt;
	}
	public void setTag_url_cnt(int tag_url_cnt) {
		this.tag_url_cnt = tag_url_cnt;
	}
	public String getTag_url_img() {
		return tag_url_img;
	}
	public void setTag_url_img(String tag_url_img) {
		this.tag_url_img = tag_url_img;
	}
	public String getTag_url_price() {
		return tag_url_price;
	}
	public void setTag_url_price(String tag_url_price) {
		this.tag_url_price = tag_url_price;
	}
	public String getTag_url_title() {
		return tag_url_title;
	}
	public void setTag_url_title(String tag_url_title) {
		this.tag_url_title = tag_url_title;
	}

}
