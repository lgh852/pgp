package p.g.p.model;

import java.util.Date;

public class Notice {
	
	private int notice_idx;
    private String notice_title;
    private String notice_contents;
    private Date notice_regdate;
    private int manager_idx;
	
    
    
    public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Notice(int notice_idx, String notice_title, String notice_contents, Date notice_regdate, int manager_idx) {
		super();
		this.notice_idx = notice_idx;
		this.notice_title = notice_title;
		this.notice_contents = notice_contents;
		this.notice_regdate = notice_regdate;
		this.manager_idx = manager_idx;
	}



	public int getNotice_idx() {
		return notice_idx;
	}



	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}



	public String getNotice_title() {
		return notice_title;
	}



	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}



	public String getNotice_contents() {
		return notice_contents;
	}



	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}



	public Date getNotice_regdate() {
		return notice_regdate;
	}



	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}



	public int getManager_idx() {
		return manager_idx;
	}



	public void setManager_idx(int manager_idx) {
		this.manager_idx = manager_idx;
	}



	@Override
	public String toString() {
		return "Notice [notice_idx=" + notice_idx + ", notice_title=" + notice_title + ", notice_contents="
				+ notice_contents + ", notice_regdate=" + notice_regdate + ", manager_idx=" + manager_idx + "]";
	}
	
	
    
    
    
}
