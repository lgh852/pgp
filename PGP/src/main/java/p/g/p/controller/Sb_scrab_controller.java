package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.scrapFN;
import p.g.p.service.Sb_scrap_service;

@Controller
public class Sb_scrab_controller {
   
   @Autowired
   Sb_scrap_service service;
   
   @RequestMapping("/sidebar/scrap")
   @ResponseBody
   public String sbScrap(scrapFN scrapfn) {
      
      String ck="n";
      
      
      int result = service.insertFolderName(scrapfn);
      
      System.out.println("오잉"+scrapfn);
       
      if(result>0) {
         ck="y";
      }else {
         ck="n";
      }
      
      
      return ck;
   }
   
   @RequestMapping("/sidebar/updateScrap")
   @ResponseBody
   public String sbScrapUpdate(scrapFN fn) {
      
      
      
      String c="n";
      
      int r = service.updateFolderName(fn);
      
      System.out.println("ㅋㅋㅋ"+fn);
      
      if(r>0) {
         c="y";
      }else {
         c="n";
      }
      
      
      
      
      return c;
   }

   
}