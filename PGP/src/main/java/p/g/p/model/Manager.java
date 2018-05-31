package p.g.p.model;

public class Manager {
	
	private int manager_idx;
	private String manager_id;
	private String manager_pw;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int manager_idx, String manager_id, String manager_pw) {
		super();
		this.manager_idx = manager_idx;
		this.manager_id = manager_id;
		this.manager_pw = manager_pw;
	}

	public int getManager_idx() {
		return manager_idx;
	}

	public void setManager_idx(int manager_idx) {
		this.manager_idx = manager_idx;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_pw() {
		return manager_pw;
	}

	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}

	@Override
	public String toString() {
		return "Manager [manager_idx=" + manager_idx + ", manager_id=" + manager_id + ", manager_pw=" + manager_pw
				+ "]";
	}
	
	
	

}
