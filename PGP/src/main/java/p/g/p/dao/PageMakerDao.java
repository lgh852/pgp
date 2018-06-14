package p.g.p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import p.g.p.model.Faq;
import p.g.p.model.Notice;
import p.g.p.model.PageMaker;

public interface PageMakerDao {

	//전체 게시글에 갯수 가져오기 함수
	public int testcount();
    //공지사항 글 가져오기
	public List<Notice> noticelist(PageMaker pagemaker);
	//FAQ전체 게시글 갯수 가져오기
	public int faqtestcount();
	//FAQ글 가져오기 
	public List<Faq> faqlist(PageMaker pagemaker);
	
	
}
