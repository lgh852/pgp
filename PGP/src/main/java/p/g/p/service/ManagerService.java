package p.g.p.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.dao.PageMakerDao;
import p.g.p.model.Faq;
import p.g.p.model.Manager;
import p.g.p.model.Notice;
import p.g.p.model.PageMaker;
import p.g.p.model.report;


public class ManagerService {
	
	private ManagerDao dao;
	private PageMakerDao dao2;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public Manager loginService(Manager manager, String id, String pw) {

		dao = sqlSessionTemplate.getMapper(ManagerDao.class);
		manager = (Manager) dao.loginSelect(id);
		
		if (manager != null) {
			// 로그인성공
			if (manager.getManager_pw() == pw) {
				// 비밀번호 있을시
				manager.setManager_pw("");
				return manager;
			}

		} else {
			// 로그인 실패
			return manager = null;
		}

		return manager;
	}
	
	////////////////////////////////////////////////////////////////////////////////FAQ 관련
	public List<Faq> getFaqList() {
	      
	      dao = sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      List<Faq> list = dao.selectFaqList();
	      
	      return list;
	   }

	   public int faqInsert(Faq faq) {
	      
	      dao = sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      int c = dao.insertFaq(faq);
	      
	      
	      return c;
	   }

	   public Faq viewFaqContents(int faq_idx) {
	      
	      Faq faq;
	      
	      dao=sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      faq = dao.selectByFaqIdx(faq_idx);
	      
	      return faq;

	   }

	   public int deleteFaqList(int faq_idx) {
	      
	      dao = sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      int cc = dao.deleteFaqByIdx(faq_idx);
	      
	      return cc;
	      
	   }

	   public Faq updateSelectFaq(int faq_idx) {
	      
	      Faq faq;
	      
	      dao=sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      faq = dao.selectByFaqIdx(faq_idx);
	      
	      return faq;
	      
	   }

	   public int updateFaqList(Faq faq, HttpServletRequest request) {
	      
	      dao = sqlSessionTemplate.getMapper(ManagerDao.class);
	      
	      int re = dao.updateFaqByIdx(faq);
	      
	      return re;
	   }
	   
	   public List<Faq> faqList(PageMaker pagemaker) {
		   
		   dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

			List<Faq> list = dao2.faqlist(pagemaker);

	        return list;
		
		}
	   
	   //////////////////////////////////////////////////////////////////////////////Notice 관련
	   
	   public int noticeInsert(Notice notice) {
			
			dao = sqlSessionTemplate.getMapper(ManagerDao.class);
			
			int resultCnt = dao.insertNotice(notice);
			
		    return resultCnt;
			
		}
	   
	   public int noticetestcount() {

			dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

			int noticeListCount = dao2.testcount();

			if (noticeListCount > 0) {

			} else {
				noticeListCount = 0;
			}

			return noticeListCount;
		}

		public List<Notice> noticeList(PageMaker pagemaker) {
			
			dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

			List<Notice> list = dao2.noticelist(pagemaker);

	        return list;
		}
		
		public int deleteNoticeList(int notice_idx) {
			
			dao = sqlSessionTemplate.getMapper(ManagerDao.class);
			
			int resultCnt = dao.deleteByIdx(notice_idx);
			
			
			return resultCnt;
		}

		public Notice updateSelect(int notice_idx) {
			
			Notice notice;
			dao = sqlSessionTemplate.getMapper(ManagerDao.class);
			notice = dao.selectByNoticeIdx(notice_idx);
			
			return notice;
		}
		
		public int updateNoticeList(Notice notice, HttpServletRequest request) {
			
			dao = sqlSessionTemplate.getMapper(ManagerDao.class);
			
			int result = dao.updateByIdx(notice);
			
			return result;
			
		}
		
		
        ////////////////////////////////////////////////////////////////////////신고 관련
		public List<report> selectReportList() {
			
			dao=sqlSessionTemplate.getMapper(ManagerDao.class);
			
			List<report> r = dao.selectReportList();
			
			return r;
		}

		public int faqtestcount() {
			
			dao2 = sqlSessionTemplate.getMapper(PageMakerDao.class);

			int faqListCount = dao2.faqtestcount();

			if (faqListCount > 0) {

			} else {
				faqListCount = 0;
			}

			return faqListCount;
			
		}

		

	   
	   

	
	
	
	
	
	
	
}
