package p.g.p.model;

import java.util.Date;

public class Join_Board_UrlTag {
   private int board_idx;// 번호
   private String board_title;// 제목
   private String board_contents;// 내용
   private int board_cnt;// 조회수
   private int board_comment;// 댓글수
   private int board_like;// 좋아요수
   private int board_scrap;// 스크랩수
   private Date board_regdate;// 작성일
   private int member_idx;// 회원번호
   private int category_idx;// 공간
   private int category_idx2;// 평수

   private int tag_idx;
   private String tag_url;
   private String tag_position_y;
   private String tag_position_x;
   private int tag_no;
   private int tag_url_cnt;
   private String tag_url_img;
   private String tag_url_price;
   private String tag_url_title;

   public Join_Board_UrlTag() {
      super();
      // TODO Auto-generated constructor stub
   }

   public Join_Board_UrlTag(int board_idx, String board_title, String board_contents, int board_cnt, int board_comment,
         int board_like, int board_scrap, Date board_regdate, int member_idx, int category_idx, int category_idx2,
         int tag_idx, String tag_url, String tag_position_y, String tag_position_x, int tag_no, int tag_url_cnt,
         String tag_url_img, String tag_url_price, String tag_url_title) {
      super();
      this.board_idx = board_idx;
      this.board_title = board_title;
      this.board_contents = board_contents;
      this.board_cnt = board_cnt;
      this.board_comment = board_comment;
      this.board_like = board_like;
      this.board_scrap = board_scrap;
      this.board_regdate = board_regdate;
      this.member_idx = member_idx;
      this.category_idx = category_idx;
      this.category_idx2 = category_idx2;
      this.tag_idx = tag_idx;
      this.tag_url = tag_url;
      this.tag_position_y = tag_position_y;
      this.tag_position_x = tag_position_x;
      this.tag_no = tag_no;
      this.tag_url_cnt = tag_url_cnt;
      this.tag_url_img = tag_url_img;
      this.tag_url_price = tag_url_price;
      this.tag_url_title = tag_url_title;
   }

   @Override
   public String toString() {
      return "Join_Board_UrlTag [board_idx=" + board_idx + ", board_title=" + board_title + ", board_contents="
            + board_contents + ", board_cnt=" + board_cnt + ", board_comment=" + board_comment + ", board_like="
            + board_like + ", board_scrap=" + board_scrap + ", board_regdate=" + board_regdate + ", member_idx="
            + member_idx + ", category_idx=" + category_idx + ", category_idx2=" + category_idx2 + ", tag_idx="
            + tag_idx + ", tag_url=" + tag_url + ", tag_position_y=" + tag_position_y + ", tag_position_x="
            + tag_position_x + ", tag_no=" + tag_no + ", tag_url_cnt=" + tag_url_cnt + ", tag_url_img="
            + tag_url_img + ", tag_url_price=" + tag_url_price + ", tag_url_title=" + tag_url_title + "]";
   }

   public int getBoard_idx() {
      return board_idx;
   }

   public void setBoard_idx(int board_idx) {
      this.board_idx = board_idx;
   }

   public String getBoard_title() {
      return board_title;
   }

   public void setBoard_title(String board_title) {
      this.board_title = board_title;
   }

   public String getBoard_contents() {
      return board_contents;
   }

   public void setBoard_contents(String board_contents) {
      this.board_contents = board_contents;
   }

   public int getBoard_cnt() {
      return board_cnt;
   }

   public void setBoard_cnt(int board_cnt) {
      this.board_cnt = board_cnt;
   }

   public int getBoard_comment() {
      return board_comment;
   }

   public void setBoard_comment(int board_comment) {
      this.board_comment = board_comment;
   }

   public int getBoard_like() {
      return board_like;
   }

   public void setBoard_like(int board_like) {
      this.board_like = board_like;
   }

   public int getBoard_scrap() {
      return board_scrap;
   }

   public void setBoard_scrap(int board_scrap) {
      this.board_scrap = board_scrap;
   }

   public Date getBoard_regdate() {
      return board_regdate;
   }

   public void setBoard_regdate(Date board_regdate) {
      this.board_regdate = board_regdate;
   }

   public int getMember_idx() {
      return member_idx;
   }

   public void setMember_idx(int member_idx) {
      this.member_idx = member_idx;
   }

   public int getCategory_idx() {
      return category_idx;
   }

   public void setCategory_idx(int category_idx) {
      this.category_idx = category_idx;
   }

   public int getCategory_idx2() {
      return category_idx2;
   }

   public void setCategory_idx2(int category_idx2) {
      this.category_idx2 = category_idx2;
   }

   public int getTag_idx() {
      return tag_idx;
   }

   public void setTag_idx(int tag_idx) {
      this.tag_idx = tag_idx;
   }

   public String getTag_url() {
      return tag_url;
   }

   public void setTag_url(String tag_url) {
      this.tag_url = tag_url;
   }

   public String getTag_position_y() {
      return tag_position_y;
   }

   public void setTag_position_y(String tag_position_y) {
      this.tag_position_y = tag_position_y;
   }

   public String getTag_position_x() {
      return tag_position_x;
   }

   public void setTag_position_x(String tag_position_x) {
      this.tag_position_x = tag_position_x;
   }

   public int getTag_no() {
      return tag_no;
   }

   public void setTag_no(int tag_no) {
      this.tag_no = tag_no;
   }

   public int getTag_url_cnt() {
      return tag_url_cnt;
   }

   public void setTag_url_cnt(int tag_url_cnt) {
      this.tag_url_cnt = tag_url_cnt;
   }

   public String getTag_url_img() {
      return tag_url_img;
   }

   public void setTag_url_img(String tag_url_img) {
      this.tag_url_img = tag_url_img;
   }

   public String getTag_url_price() {
      return tag_url_price;
   }

   public void setTag_url_price(String tag_url_price) {
      this.tag_url_price = tag_url_price;
   }

   public String getTag_url_title() {
      return tag_url_title;
   }

   public void setTag_url_title(String tag_url_title) {
      this.tag_url_title = tag_url_title;
   }

}