package p.g.p.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Faq;

public class Mg_faq_service {
   
   @Autowired
   private SqlSessionTemplate s;
   
   private ManagerDao dao;

   public List<Faq> getFaqList() {
      
      dao = s.getMapper(ManagerDao.class);
      
      List<Faq> list = dao.selectFaqList();
      
      return list;
   }

   public int faqInsert(Faq faq) {
      
      dao = s.getMapper(ManagerDao.class);
      
      int c = dao.insertFaq(faq);
      
      
      return c;
   }

   public Faq viewFaqContents(int faq_idx) {
      
      Faq faq;
      
      dao=s.getMapper(ManagerDao.class);
      
      faq = dao.selectByFaqIdx(faq_idx);
      
      return faq;

   }

   public int deleteFaqList(int faq_idx) {
      
      dao = s.getMapper(ManagerDao.class);
      
      int cc = dao.deleteFaqByIdx(faq_idx);
      
      return cc;
      
   }

   public Faq updateSelectFaq(int faq_idx) {
      
      Faq faq;
      
      dao=s.getMapper(ManagerDao.class);
      
      faq = dao.selectByFaqIdx(faq_idx);
      
      return faq;
      
   }

   public int updateFaqList(Faq faq, HttpServletRequest request) {
      
      dao = s.getMapper(ManagerDao.class);
      
      int re = dao.updateFaqByIdx(faq);
      
      return re;
   }

}