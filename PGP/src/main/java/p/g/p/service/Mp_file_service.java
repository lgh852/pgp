package p.g.p.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Member_info;



public class Mp_file_service {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Mp_dao dao; 

    

	public void memberPhotoUpload(Member_info member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		String uploadURI = "/resources/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		
		// 업로드 파일의 물리적 저장
		// 파일 저장 : 증명사진.jpg
		// 회원의 사진은 하나만 존재한다.
		// 파일 이름 생성 : 회원아이디_원본파일이름
		if (!member.getPhotofile().isEmpty() ) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id()+"_"+member.getPhotofile().getOriginalFilename();
			
			member.getPhotofile().transferTo(new File(dir, fileName));
			
			member.setMember_photo(fileName);
			
			System.out.println("asdasdasd"+member);

		
		}
		
		
	}

}
