package p.g.p.model;

public class Category_Room {

	private int category_idx;
	private String category_room;
	public Category_Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category_Room(int category_idx, String category_room) {
		super();
		this.category_idx = category_idx;
		this.category_room = category_room;
	}
	@Override
	public String toString() {
		return "Category_Room [category_idx=" + category_idx + ", category_room=" + category_room + "]";
	}
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}
	public String getCategory_room() {
		return category_room;
	}
	public void setCategory_room(String category_room) {
		this.category_room = category_room;
	}
	
}
