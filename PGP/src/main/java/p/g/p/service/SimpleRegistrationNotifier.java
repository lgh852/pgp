package p.g.p.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import p.g.p.dao.MemberDao;
import p.g.p.model.Member_info;

@Service
public class SimpleRegistrationNotifier {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDao dao;
	
	public void sendMail(Member_info member) {
		
		MimeMessage message = mailSender.createMimeMessage();
		try {
			
			//제목 설정
			message.setSubject("임시 비밀번호 발급안내 ");
			
			//내용 설정(html)
			String htmlMsg="<strong>안녕하세요. " + member.getMember_name() + "님</strong>, 반갑습니다."+"귀하의 임시 비밀번호는"+member.getMember_pw()+"입니다. 감사합니다.";
			message.setText(htmlMsg, "utf-8", "html");
			
			//보내는 메일 주소
			message.setFrom(new InternetAddress());
			
			// 받는 메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(member.getMember_intro()));
			
			mailSender.send(message);
			
		}catch (MessagingException e) {
			e.printStackTrace();
		}
			
		}
	
	public void sendMailAttach(Member_info member) {
		
		MimeMessage message = mailSender.createMimeMessage();

		
		
		System.out.println(member);
		System.out.println(member);
		
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		
		String member_pw = member.getMember_pw();
		
		String member_id = member.getMember_id();
		
		try {
			
			// 메일에 파일 첨부를 위해서 MimeMessageHelper 클레스 이용,
			// 생성자 매개변수(메시지, 파일 첨부여부, 인코딩)
			MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

			//제목설정
			helper.setSubject("임시 비밀번호 발급");
			
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다."+"귀하의 임시 비밀번호는"+member_pw+"입니다. 감사합니다.";
			
			/*String htmlContent1 = "<a href=\"http://localhot:8080/pg5/member/chage_pw/\">비밀번호 변경</a>";*/
			helper.setText(htmlContent, true);
			
			

			
			// 보내는 사람 설정
			helper.setFrom("sms44556688@gmail.comsdasd", "지코");
			
			// 받는 사람 설정
			helper.setTo(new InternetAddress(member_id, "UTF-8"));
			
			if(member_id != null) {
	
				//dao.selectIntro(member);
			}
				member_id = null;
			
	
			
			
			/*DataSource dataSource = new FileDataSource("d:\\25.jpg");
			
			helper.addAttachment(MimeUtility.encodeText("다스.jpg", "UTF-8", "B"), dataSource);*/
			
			mailSender.send(message);
			
			
			
		}catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
