package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import p.g.p.dao.PhotoleeDao;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;

@Controller
public class PhotoService {

   PhotoleeDao dao;

   @Autowired
   SqlSessionTemplate sessionTemplate;

   public List<PhotoListmodel> photolistview(Like like, PhotoListmodel photolist,Member_info member) {

      dao = sessionTemplate.getMapper(PhotoleeDao.class);
      List<PhotoListmodel> list;
      
      if (photolist.getAlignment().equals("board_cnt")) {
         // cnt꺼 실행
         list = dao.photolistcnt(photolist);
         
      } else if (photolist.getAlignment().equals("board_like")) {
         // like 실행
         list = dao.photolistlike(photolist);
         
      } else {
         // 일반 정렬
    	  System.out.println("체크");
    	  
         list = dao.photolist(photolist);
         
      }
      
 
      if(member!=null) {
    		like.setMember_idx(member.getMember_idx());
    	  System.out.println("실행되야댐");
      list = listlikeck(list, like);
    
      if (list != null) {

      } else {
         list = null;
   	  System.out.println("실행되야댐ㄴㄴㄴㄴ");
      }

      }

      return list;
      
   }

   public List<PhotoListmodel> listlikeck(List<PhotoListmodel> list, Like like) {
System.out.println(like);
      List<Like> likelist = selectimg(like);
      	System.out.println("시붍애"+likelist);
      for (int i = 0; i < list.size(); i++) {
    	  System.out.println("1");
         int photoidx = list.get(i).getBoard_idx();
    
         System.out.println("photoidx"+photoidx);
         for (int x = 0; x < likelist.size(); x++) {
        	 System.out.println("13");
            int listidx = likelist.get(x).getBoard_idx();
            System.out.println("listidx"+listidx);
            if (photoidx == listidx) {
            	System.out.println("15");
               list.get(i).setLikeck("ss");
               System.out.println("sss");
            }
         }
      }
      return list;
   }

   public List<Like> selectimg(Like like) {
      dao = sessionTemplate.getMapper(PhotoleeDao.class);
      List<Like> likelist = dao.seleteimg(like);
      System.out.println("오바대스네");
      if (likelist != null) {
    	  
      } else {
    	  
         likelist = null;
      }

      return likelist;
   }

}