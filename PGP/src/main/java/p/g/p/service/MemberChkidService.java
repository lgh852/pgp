package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import p.g.p.dao.MemberDao;
import p.g.p.model.Member_info;

@Service
public class MemberChkidService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao dao;
	
	
	public String idchk(Member_info member) {
		// 런 타임시에(실행중) 매퍼 생성을 위한 처리
				dao = sqlSessionTemplate.getMapper(MemberDao.class);

				String member_id = dao.selectChkId(member);
				System.out.println("들어왔나여?! : " + member_id);
				
				
				System.out.println("zzx : "+ member);
				System.out.println("zzx : "+ member);
				System.out.println("zzx : "+ member);
				
				
				if (member_id != null) {
					System.out.println("hhj : "+ member_id);
				} else {
					member = null;
				}
				
				return member_id;
			}

	
	
			public String selectChkId(Member_info member) { //필요 없다 이거 실행하는데

				return dao.selectChkId(member);
	}

}
