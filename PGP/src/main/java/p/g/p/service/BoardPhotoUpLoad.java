package p.g.p.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import p.g.p.model.Member_info;



public class BoardPhotoUpLoad {

	public void fileload(HttpServletRequest request,Member_info member) throws IllegalStateException, IOException {
	/*	String uploadURI = "/resources/BoardPhoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);


		// 파일저장 //증명사진.jpg
		// 회원의 사진은 하나만 존재한다 중복된 이름의 파일 으 들어올경우 덮어 씌워지기 때문에 id값을 fileName로 넣어줌
		// 파일 이름 생성 : 회원아이디_ 원본 파일 이름
		if (!member.getFileName().isEmpty()) {
			// null이 아니면
			// 새로운 파일이름 생성 - > 파일 저장 -> DB에 저장할 파일이름 set
			System.out.println(member.getMember_id());
			System.out.println("-------------");
			System.out.println(member.getFileName());
			String fileName = member.getMember_id() + "_" + member.getFileName().getOriginalFilename();// id값을
																										// fileName으로
																										// 줄것임
			System.out.println(member.getFileName().getOriginalFilename());
			member.getFileName().transferTo(new File(dir, fileName));
			
			member.setMember_photo(fileName);// 새롭게 만들어진 photoName을 setPhoto로

		}*/
	}
}
