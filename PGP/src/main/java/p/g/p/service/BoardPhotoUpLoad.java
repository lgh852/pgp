package p.g.p.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import p.g.p.model.Board_Photo;
import p.g.p.model.Member_info;
import p.g.p.model.StoryBoard;



public class BoardPhotoUpLoad {

	public void fileupload(HttpServletRequest request,HttpSession session,Board_Photo photo) throws IllegalStateException, IOException {
		String uploadURI = "/resources/BoardPhoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);


		// 파일저장 //증명사진.jpg
		// 회원의 사진은 하나만 존재한다 중복된 이름의 파일 으 들어올경우 덮어 씌워지기 때문에 id값을 fileName로 넣어줌
		// 파일 이름 생성 : 회원아이디_ 원본 파일 이름
		if (!photo.getFileName().isEmpty()) {
			//세션에서 아이디값 가져오기 
			Member_info member = (Member_info)session.getAttribute("user");

			String fileName =photo.getBoard_idx()+"_"+ member.getMember_id()+ "_" + photo.getFileName().getOriginalFilename();// id값을
																										// fileName으로
																										// 줄것임
			System.out.println(photo.getFileName().getOriginalFilename());
			photo.getFileName().transferTo(new File(dir, fileName));
			
			photo.setPhoto_name(fileName);// 새롭게 만들어진 photoName을 setPhoto로

		}
	}
	

	public void storyfileupload(HttpServletRequest request,HttpSession session,StoryBoard storyboard_photo,int photoMaxIDX) throws IllegalStateException, IOException {
		String uploadURI = "/resources/StoryPhoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);


		// 파일저장 //증명사진.jpg
		// 회원의 사진은 하나만 존재한다 중복된 이름의 파일 으 들어올경우 덮어 씌워지기 때문에 id값을 fileName로 넣어줌
		// 파일 이름 생성 : 회원아이디_ 원본 파일 이름
		if (!storyboard_photo.getFileName().isEmpty()) {
			//세션에서 아이디값 가져오기 
			Member_info member = (Member_info)session.getAttribute("user");

			System.out.println("얍ㅇ뱡!!!!!!!!!!!!!!!=>>"+storyboard_photo);
			String fileName =photoMaxIDX+"_"+ member.getMember_id()+ "_" + storyboard_photo.getFileName().getOriginalFilename();// id값을
																										// fileName으로
																										// 줄것임
			System.out.println(storyboard_photo.getFileName().getOriginalFilename());
			storyboard_photo.getFileName().transferTo(new File(dir, fileName));
			
			storyboard_photo.setStoryboard_photo(fileName);// 새롭게 만들어진 photoName을 setPhoto로

		}
	}
}
