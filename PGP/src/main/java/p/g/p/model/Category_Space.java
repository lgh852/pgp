package p.g.p.model;

public class Category_Space {

	private int category_idx;
	private String category_space;
	public Category_Space() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category_Space(int category_idx, String category_space) {
		super();
		this.category_idx = category_idx;
		this.category_space = category_space;
	}
	@Override
	public String toString() {
		return "Category_Space [category_idx=" + category_idx + ", category_space=" + category_space + "]";
	}
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}
	public String getCategory_space() {
		return category_space;
	}
	public void setCategory_space(String category_space) {
		this.category_space = category_space;
	}
	
}
