package p.g.p.model;

public class scrapFN {
   
   private int scrapFN_idx;
   private String scrap_name;
   private int member_idx;
   public scrapFN() {
      super();
      // TODO Auto-generated constructor stub
   }
   public scrapFN(int scrapFN_idx, String scrap_name, int member_idx) {
      super();
      this.scrapFN_idx = scrapFN_idx;
      this.scrap_name = scrap_name;
      this.member_idx = member_idx;
   }
   public int getScrapFN_idx() {
      return scrapFN_idx;
   }
   public void setScrapFN_idx(int scrapFN_idx) {
      this.scrapFN_idx = scrapFN_idx;
   }
   public String getScrap_name() {
      return scrap_name;
   }
   public void setScrap_name(String scrap_name) {
      this.scrap_name = scrap_name;
   }
   public int getMember_idx() {
      return member_idx;
   }
   public void setMember_idx(int member_idx) {
      this.member_idx = member_idx;
   }
   @Override
   public String toString() {
      return "scrapFN [scrapFN_idx=" + scrapFN_idx + ", scrap_name=" + scrap_name + ", member_idx=" + member_idx
            + "]";
   }
   
   

}