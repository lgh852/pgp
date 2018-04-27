package p.g.p.dao;

import p.g.p.model.Member_info;

public interface MemberDao {

	public int insertMember(Member_info member);

	public Member_info loginSelect(String id);

	
	
}
