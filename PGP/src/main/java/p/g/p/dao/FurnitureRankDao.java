package p.g.p.dao;

import java.util.List;

import p.g.p.model.Join_Board_UrlTag;
import p.g.p.model.Url_Tag;

public interface FurnitureRankDao {

   public List<Url_Tag> orderByBoardCnt() ;
   public List<Url_Tag>  orderByPriceDesc() ;
   public List<Url_Tag> orderByPriceAsc() ;
   public List<Join_Board_UrlTag> orderByRegDate();
}