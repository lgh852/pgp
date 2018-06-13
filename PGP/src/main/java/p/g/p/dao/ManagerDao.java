package p.g.p.dao;

import java.util.List;

import p.g.p.model.Faq;
import p.g.p.model.Manager;
import p.g.p.model.Notice;
import p.g.p.model.report;

public interface ManagerDao {

   public Manager loginSelect(String id);

   /*public int insertManager(Manager manager);*/
   
   //공지사항 입력하기 
   public int insertNotice(Notice notice);
   
   //공지사항 리스트 보여주기
   public List<Notice> selectNoticeList();
   
   //공지사항 글 중 하나 클릭하면 내용에 들어가기 위한 셀렉트 
   public Notice selectByNoticeIdx(int notice_idx);

   //공지사항 글 삭제
   public int deleteByIdx(int notice_idx);
    
   //공지사항 글 수정
   public int updateByIdx(Notice notice);

   //신고 리스트 보기 
   public List<report> selectReportList();

   //faq리스트 보여주기 
   public List<Faq> selectFaqList();

   //FAQ입력하기 
   public int insertFaq(Faq faq);

   //FAQ리스트 글 중 하나 클릭하면 내용에 들어가기 위한 셀렉트
   public Faq selectByFaqIdx(int faq_idx);

   //FAQ삭제
   public int deleteFaqByIdx(int faq_idx);

   //FAQ수정
   public int updateFaqByIdx(Faq faq);
   
   
   
   
}
