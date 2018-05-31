package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Join_Board_UrlTag;
import p.g.p.model.Url_Tag;
import p.g.p.service.FurnitureRankService;

@Controller
@RequestMapping(value = "furniture/furnitureRank")
public class FurnitureRankController {
   
   @Autowired
   FurnitureRankService furniturerankservice;
   
   @RequestMapping(method = RequestMethod.GET)
   public String furnitureRankView(Model model,@RequestParam(value="valueCnt", defaultValue="boardOrder") String valueCnt) {
      String view = "home";
      String page = "furniture/furnitureRank.jsp";
      
      System.out.println("=====");
      System.out.println(valueCnt+"dsdsdsdsdsdsdssdds");
      
      if(valueCnt.equals("boardOrder")) {
         List<Url_Tag>  orderByBoardCntList =furniturerankservice.orderByBoardCnt(); //조회수순으로 출력 
         model.addAttribute("orderList",orderByBoardCntList);
      }else if(valueCnt.equals("priceDesc")) {
         List<Url_Tag> orderByPriceDescList= furniturerankservice.orderByPriceDesc(); //높은 가격순으로 출력 
         model.addAttribute("orderList",orderByPriceDescList);
      }else if(valueCnt.equals("priceAsc")) {
         List<Url_Tag> orderByPriceAscList=furniturerankservice.orderByPriceAsc(); //낮은 가격순으로  출력
         model.addAttribute("orderList",orderByPriceAscList);
      }else if(valueCnt.equals("regdateOrder")) {
         List<Join_Board_UrlTag> orderByRegDateList = furniturerankservice.orderByRegDate(); //등록일순 
         model.addAttribute("orderList",orderByRegDateList);
      }
      
      model.addAttribute("page", page);
      
      return view;
   }

}