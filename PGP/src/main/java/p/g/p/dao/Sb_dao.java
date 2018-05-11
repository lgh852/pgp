package p.g.p.dao;

import p.g.p.model.report;

public interface Sb_dao {

	public int like(String member_id,int board_idx);
	
	public int dislike(String member_id,int board_idx);

	public int reportboard(report report);
	
	
	
}
