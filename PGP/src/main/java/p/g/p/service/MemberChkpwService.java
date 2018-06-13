package p.g.p.service;

import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import p.g.p.dao.MemberDao;
import p.g.p.model.Member_info;

@Service
public class MemberChkpwService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao dao;
	
	public Member_info pwChk(Member_info member) {
		/*Member resultMember = dao.selectByIntro)*/
	
		
		//StringButter = 스트링의 파생 메서드  기존의 버퍼 크기를 늘리는게(문자열 추가 및 변경) 가능하다. String은 선언 되는순간 내부 내용을 변환할 수 없다. (수정불가 == immutable)
		// -> 자료형 타입 = append / insert / substring
		// insert = insert 메소드는 특정 위치에 원하는 문자열을 삽입할 수 있다.
		// substring = substring(시작위치, 끝위치)와 같이 사용하면 StringBuffer 객체의 시작위치에서 끝위치까지의 문자를 뽑아내게 된다.
		//StringBuffer 자료형은 append 라는 메소드를 이용하여 계속해서 문자열을 추가해 나갈 수 있다. 그리고 위 예제와 같이 toString() 메소드를 이용하면 String 자료형으로 변경할 수 있다.
		//toString 메소드 : 자바의 제일 조상인 Object의 메소드이며, 객체의 속성값을 문자열로 반환할 필요가 있는 경우 재정의 하여 사용
	
		StringBuffer Buffer = new StringBuffer();
		
		Random random = new Random(); // 랜덤 메서드 값을 랜덤하게 준다.
		
		dao = sqlSessionTemplate.getMapper(MemberDao.class);

		String member_pw = dao.selectChkPw(member); // 데이터 베이스 쿼리문 실행을 멤버 객체에 받는다
		
		String member_id = dao.selectChkById(member); // member_id 값을 가지고 온다!? 		
		
		// 배열 사용
		final char[] pwt = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9'};
		
		System.out.println(Buffer.toString());
		System.out.println(Buffer.toString());
		System.out.println(Buffer.toString());
		
		
		for (int i = 0; i < 8; i++) {
			Buffer.append(pwt[random.nextInt(pwt.length)]); // random 확인하기 배열로 출력할 경우 투스트링으로 괄호랑 골뱅이가 나온다?
			System.out.println(Buffer.toString());
			/*member_pw =pwt.toString();*/
		}
		
		System.out.println(Buffer.toString());
		member_pw=Buffer.toString(); //배열의 랜덤으로 정해진 임시 비번 값이 member_pw 변수로 저장된다.
		
		member.setMember_pw(member_pw); // 변수를 재정의 하고(Member pw컬럼에 값을 저장한다.)
		dao.updateChkPw(member); // 임시 비번값을 database 쿼리문을 실행한다. (저장한다는 뜻)
		System.out.println("mem_pw : "+member_pw);
			
		if (member_pw != null && member_pw == member_id) {
			member.setMember_id(member_id);
			member.setMember_pw(member_pw);
		} else {
			member = null;
		}

		return member;
	}

	public Member_info findemail(Member_info member) {
		String member_id = dao.selectByEmail(member);
		System.out.println("수정 member_id : "+member_id);
		String member_pw = member.getMember_pw();
		System.out.println("메일보내기 : "+ member_pw);
		
		System.out.println("member_intro : " + member_id);
		
		if(member_id != null && member_pw != null) {
			
			
		}
		member.setMember_id(member_id);
		
		return member;
	}
}
