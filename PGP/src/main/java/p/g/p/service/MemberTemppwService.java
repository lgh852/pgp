package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import p.g.p.dao.MemberDao;
import p.g.p.model.Member_info;

@Service
public class MemberTemppwService {

		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;

		private MemberDao dao;
		
		
		
		public Member_info tempPw(Member_info member) {
			
			
			dao =sqlSessionTemplate.getMapper(MemberDao.class);
			
			
			int member_pw =dao.updateChkPw(member);
			
			Member_info member_id = dao.loginSelect(member.getMember_id());
			
		
			
			//아이디값 찾기... 위 member_id member 값이 없다 (null)
			
			if(member_pw == 1 && member_id.getMember_id() != null) {
				
			}else{
				member_id=null;
			}
		
			return member_id;
		}


			
			
		}


