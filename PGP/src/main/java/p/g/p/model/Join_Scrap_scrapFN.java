package p.g.p.model;

public class Join_Scrap_scrapFN {
   
   private int scrap_idx;
   private int board_idx;
   private int member_idx;
   private int scrapFN_idx;

   private String scrap_name;
   
   
   

   public Join_Scrap_scrapFN() {
      super();
      // TODO Auto-generated constructor stub
   }

   @Override
   public String toString() {
      return "Join_Scrap_scrapFN [scrap_idx=" + scrap_idx + ", board_idx=" + board_idx + ", member_idx=" + member_idx
            + ", scrapFN_idx=" + scrapFN_idx + ", scrap_name=" + scrap_name + "]";
   }

   public Join_Scrap_scrapFN(int scrap_idx, int board_idx, int member_idx, int scrapFN_idx, String scrap_name) {
      super();
      this.scrap_idx = scrap_idx;
      this.board_idx = board_idx;
      this.member_idx = member_idx;
      this.scrapFN_idx = scrapFN_idx;
      this.scrap_name = scrap_name;
   }

   public int getScrap_idx() {
      return scrap_idx;
   }

   public void setScrap_idx(int scrap_idx) {
      this.scrap_idx = scrap_idx;
   }

   public int getBoard_idx() {
      return board_idx;
   }

   public void setBoard_idx(int board_idx) {
      this.board_idx = board_idx;
   }

   public int getMember_idx() {
      return member_idx;
   }

   public void setMember_idx(int member_idx) {
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
   
   

}