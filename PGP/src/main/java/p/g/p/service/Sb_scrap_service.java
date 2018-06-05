package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Sb_dao;
import p.g.p.model.Board;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;

public class Sb_scrap_service {
   
   @Autowired 
   private SqlSessionTemplate sqlSessionTemplate;
   
   private Sb_dao dao;

   public scrapFN selectScrpaIdx;
   
   
   public List<scrapFN> folder(int member_idx){
      
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      
      List<scrapFN> folderName = dao.ScrapFolderNameList(member_idx);      
      
      return folderName;      
   }
   

   public int insertFolderName(scrapFN scrapfn) {
      dao=sqlSessionTemplate.getMapper(Sb_dao.class);
      int resultCnt = dao.insertFolderName(scrapfn);
      
      if(resultCnt>0) {
         //실행
         
         
      }else {
         resultCnt=0;
      }
      
      return resultCnt;
   }


   public int insertScrap(Scrap scrap) {
      
      dao=sqlSessionTemplate.getMapper(Sb_dao.class);
      
      int resultCk = dao.InsertScrap(scrap);
      
      if(resultCk>0) {
         //실행
      }else {
         resultCk=-1;
      }
      
      
      return resultCk;
   }


   public int deleteScrapFolder(scrapFN scrapfn) {
      
      dao=sqlSessionTemplate.getMapper(Sb_dao.class);
     
      
      int c = dao.deleteScrapName(scrapfn);
     
      System.out.println("????????????");
      
      
      if(c>0) {
         System.out.println("삭제 서비스 성공");
      }else {
         c=0;
      }
      
      
      return c;
   }


   public int updateFolderName(scrapFN fn) {
      
      dao=sqlSessionTemplate.getMapper(Sb_dao.class);
      
      int cc = dao.updateScrapName(fn);
      
      if(cc>0) {
         System.out.println("폴더명 업데이트 서비스 성공");
      }else {
         cc=0;
      }
      
      return cc;
   }


   public scrapFN selectScrpaIdx(String scrap_name) {
      
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      
      scrapFN S = dao.selectIdx(scrap_name);
      
      return S;
   }


   public List<PhotoListmodel>Listscrapck(List<PhotoListmodel> list,Scrap scrap) {
	   
	      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
	      List<Scrap> scrapck = dao.selectscrapckList(scrap);
	      
	   for(int i = 0; i<list.size();i++) {
	   	
		   	int board_idx = list.get(i).getBoard_idx();
	   			System.out.println("list board_idx"+board_idx);
	   		for(int x = 0;x<scrapck.size();x++) {
	   			int board_idxs = scrapck.get(x).getBoard_idx();
	   			System.out.println("scrapck"+board_idxs);
	   			if(board_idxs==board_idx) {
	   				System.out.println("성고오오오옹");
	   				list.get(i).setScrapck("s");
	   			}
	   		}
	   	}
	 
      
      return list;
   }

   public Scrap scrapck(Scrap scrap) {
	      
	      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
	      scrap = dao.selectscrapck(scrap);
	      
	      return scrap;
	   }

   public int scrapCountUp(Board board) {
      
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      int r = dao.scrapCntUp(board);
      if(r>0) {
         //성공
      }else {
         r=-1;
      }
      
      return r;
   }


   public int DeleteScrap(Scrap scrap) {
      
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      
      int r = dao.deleteScrap(scrap);
      if(r>0) {
         //성공
      }else {
         r=-1;
      }
      
      return r;
   }


   public int scrapCountDown(Board board) {
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      int r = dao.scrapCntDown(board);
      if(r>0) {
         //성공
      }else {
         r=-1;
      }
      
      return r;
   }

    //scrap 인포가져오기 
   public Scrap selectIdx(Board boardboard) {
      
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      Scrap scrap_info = dao.scrapInfo(boardboard);
      
      return scrap_info;
   }


   public int getFnIdx(scrapFN scrapfn) {
      System.out.println("입력됨?");
      dao = sqlSessionTemplate.getMapper(Sb_dao.class);
      int idx = dao.getScrapIdx(scrapfn);
      System.out.println("insert(성공"+idx);
      return idx;
   }



   }
   

