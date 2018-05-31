package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.FurnitureRankDao;
import p.g.p.model.Join_Board_UrlTag;
import p.g.p.model.Url_Tag;

public class FurnitureRankService {
   FurnitureRankDao dao;
   
   @Autowired
   SqlSessionTemplate sqlSessionTemplate;
   
   //조회수순으로 정렬 
   public List<Url_Tag> orderByBoardCnt() {
      dao = sqlSessionTemplate.getMapper(FurnitureRankDao.class);
      List<Url_Tag> orderByBoardCntList=dao.orderByBoardCnt();
      return orderByBoardCntList;
   }
   //높은가격 순으로 정렬
   public List<Url_Tag>  orderByPriceDesc() {
      dao = sqlSessionTemplate.getMapper(FurnitureRankDao.class);
      List<Url_Tag> orderByPriceDescList=dao.orderByPriceDesc();
      return orderByPriceDescList;
      
   }
   
   //낮은가격순으로 정ㄹ렬
   public List<Url_Tag> orderByPriceAsc() {
      dao = sqlSessionTemplate.getMapper(FurnitureRankDao.class);
      List<Url_Tag> orderByPriceAscList=dao.orderByPriceAsc();
      return orderByPriceAscList;
   }
   
   //등록일순
   public List<Join_Board_UrlTag> orderByRegDate(){
      dao = sqlSessionTemplate.getMapper(FurnitureRankDao.class);
      List<Join_Board_UrlTag> orderByRegDateList=dao.orderByRegDate();
      return orderByRegDateList;
   }
}