package p.g.p.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import p.g.p.dao.MemberDao;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;

public class MemberService {

	@Autowired
	private JavaMailSender mailSender;

	MemberDao dao;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int memberInsert(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		System.out.println("service 목록" + member);
		int resultCnt = dao.insertMember(member);
		if (resultCnt > 0) {
			// insert 성공시
			System.out.println("회원가입 성공");
		} else {
			// 회원가입 실패시 -1 값 주입
			resultCnt = -1;
		}

		return resultCnt;
	}

	public Member_info loginService(String id, String pw) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info member = dao.loginSelect(id);

		// 1.. 암호 해제? 비교

		// 2.. 방금 들어온갑 암호화해서 비교

		if (member != null && member.getMember_pw().equals(pw)) {
			// 로그인성공

			// 비밀번호 있을시
			member.setMember_pw("");

		} else {
			// 로그인 실패
			member = null;
		}

		return member;
	}

	public int countPhoto(int member_idx) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		int c = dao.countPhoto(member_idx);
		if (c > 0) {
			// 등록한 사진 있음
		} else {
			c = -1;
		}
		return c;
	}

	public List<Join_board_boardphoto> selectLatestPhoto(int member_idx) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		List<Join_board_boardphoto> LatestPhoto = dao.LatestPhoto(member_idx);
		if (LatestPhoto != null) {

		} else {

			LatestPhoto = null;

		}

		return LatestPhoto;
	}

	public List<Join_board_boardphoto> selectLikeList(int member_idx) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		List<Join_board_boardphoto> LikeList = dao.selectLikePhoto(member_idx);
		if (LikeList != null) {

		} else {

			LikeList = null;

		}
		return LikeList;
	}

	public Member_info kakaock(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info memberck = dao.loginSelect(member.getMember_id());
		int cks = 0;
		System.out.println("쳌");
		if (memberck != null) {
			// 아이디 있음
			// memberck 값이 존재
			// 아이디 있으면 0;

		} else {
			member.setMember_phone("");
			memberck = null;
			cks = dao.kakaoinsert(member);

			// 회원가입 가능
			// insert 성공시 1 값
		}

		return memberck;

	}

	public Member_info memberCk(String member_id) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info member = dao.loginSelect(member_id);
		if (member == null) {
			// 없으면
			member = null;
		} else {

		}

		return member;
	}

	public String selectScrapLatestPhoto(int member_idx) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		String LatestScrapPhoto = dao.LatestScrapPhoto(member_idx);

		if (LatestScrapPhoto != null) {

		} else {

			LatestScrapPhoto = null;

		}
		return LatestScrapPhoto;
	}

	public String selectLikeLatestPhoto(int member_idx) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		String LatestLikePhoto = dao.LatestLikePhoto(member_idx);
		if (LatestLikePhoto != null) {

		} else {

			LatestLikePhoto = null;

		}
		return LatestLikePhoto;
	}

	// 회원정보 수정 사진 업로드
	public void memberPhotoUpload(Member_info member, HttpServletRequest request)
			throws IllegalStateException, IOException {

		String uploadURI = "/resources/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);

		// 업로드 파일의 물리적 저장
		// 파일 저장 : 증명사진.jpg
		// 회원의 사진은 하나만 존재한다.
		// 파일 이름 생성 : 회원아이디_원본파일이름
		if (!member.getPhotofile().isEmpty()) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id() + "_" + member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setMember_photo(fileName);
		}

	}

	public String sha256(String planText) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(planText.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Member_info pwChk(Member_info member) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);

		// 비교값

		member = dao.selectChkPw(member); // 데이터 베이스 쿼리문 실행을 멤버 객체에 받는다

		if (member.getMember_pw() != null) {
			StringBuffer Buffer = new StringBuffer();

			Random random = new Random(); // 랜덤 메서드 값을 랜덤하게 준다.

			// 배열 사용
			final char[] pwt = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
					'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

			for (int i = 0; i < 8; i++) {
				Buffer.append(pwt[random.nextInt(pwt.length)]); // random 확인하기 배열로 출력할 경우 투스트링으로 괄호랑 골뱅이가 나온다?

				/* member_pw =pwt.toString(); */
			}
			String member_pw = Buffer.toString(); // 배열의 랜덤으로 정해진 임시 비번 값이 member_pw 변수로 저장된다.

			System.out.println("원래 멤버" + member);
			if (member.getMember_pw() != null && member_pw != null) {
				member.setMember_pw(member_pw);

				// 임시비밀번호가 발급 되었습니다

				int resultmail = sendMailAttach(member);

				if (resultmail > 0) {

					member.setMember_pw(sha256(member.getMember_pw()));
					int result = dao.updateChgPw(member);

					if (result < 0) {
						member = null;
					} else {

					}

				} else {
					member = null;

				}

			} else {
				member = null;
				// 실패
			}

		} else {

			member = null;
			// 일치하는 정보 없음

		}

		return member;
	}

	public int sendMailAttach(Member_info member) {

		MimeMessage message = mailSender.createMimeMessage();

		int result = 0;
		try {

			// 메일에 파일 첨부를 위해서 MimeMessageHelper 클레스 이용,
			// 생성자 매개변수(메시지, 파일 첨부여부, 인코딩)
			MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

			// 제목설정
			helper.setSubject("임시 비밀번호 발급");

			String htmlContent = "<strong>안녕하세요" + member.getMember_name() + "</strong>, 반갑습니다." + "귀하의 임시 비밀번호는"
					+ member.getMember_pw() + "입니다. 감사합니다.";

			helper.setText(htmlContent, true);

			// 보내는 사람 설정
			helper.setFrom("sms44556688@gmail.comsdasd", "지코");

			if (member.getMember_id() != null) {
				// 받는 사람 설정
				helper.setTo(new InternetAddress(member.getMember_id(), "UTF-8"));
				mailSender.send(message);
				result = 10;
			} else {
				result = -10;

			}

		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int change_pw(Member_info member) {
		int result = 0;
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		if (member != null) {
			member.setMember_pw(sha256(member.getMember_pw()));
			result = dao.updateChgPw(member);
			if (result > 0) {

			} else {
				result = -100;
			}
		}

		return result;
	}

	public String idchk(Member_info member) {
		// 런 타임시에(실행중) 매퍼 생성을 위한 처리
		dao = sqlSessionTemplate.getMapper(MemberDao.class);

		String member_id = dao.selectChkId(member);

		if (member_id != null) {

		} else {
			member = null;
		}

		return member_id;
	}

}
