package p.g.p.model;

import java.util.Date;

public class Faq {
	
	private int faq_idx;
	private String faq_title;
	private String faq_contents;
	private Date faq_regdate;
	private int manager_idx;
	
	
	
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faq(int faq_idx, String faq_title, String faq_contents, Date faq_regdate, int manager_idx) {
		super();
		this.faq_idx = faq_idx;
		this.faq_title = faq_title;
		this.faq_contents = faq_contents;
		this.faq_regdate = faq_regdate;
		this.manager_idx = manager_idx;
	}

	public int getFaq_idx() {
		return faq_idx;
	}

	public void setFaq_idx(int faq_idx) {
		this.faq_idx = faq_idx;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_contents() {
		return faq_contents;
	}

	public void setFaq_contents(String faq_contents) {
		this.faq_contents = faq_contents;
	}

	public Date getFaq_regdate() {
		return faq_regdate;
	}

	public void setFaq_regdate(Date faq_regdate) {
		this.faq_regdate = faq_regdate;
	}

	public int getManager_idx() {
		return manager_idx;
	}

	public void setManager_idx(int manager_idx) {
		this.manager_idx = manager_idx;
	}

	@Override
	public String toString() {
		return "Faq [faq_idx=" + faq_idx + ", faq_title=" + faq_title + ", faq_contents=" + faq_contents
				+ ", faq_regdate=" + faq_regdate + ", manager_idx=" + manager_idx + "]";
	}
	
	
	

}
