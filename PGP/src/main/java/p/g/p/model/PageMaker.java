package p.g.p.model;

public class PageMaker {
	private int totalcount;//전체 게시물개수
	private int pagenum; //현재 페이지 번호
    private int contentnum=5; //한 페이지에 몇개 표시할지
    private int startPage; //현재 페이지 블록의 시작 페이지
    private int endPage; //현재 페이지 블록의 마지막 페이지 
    private boolean prev=false; //이전 페이지로 가는 화살표 //처음엔 보이면 안되니까 false;
    private boolean next; //다음 페이지로 가는 화살표
    private int currentblock; //현재 페이지 블록
    private int lastblock; //마지막 페이지 블록
    private int pageChecknum;
    
    private int board_idx;
    
    
	
    public int getBoard_idx() {
		return board_idx;
	}

    public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}



	public void prevnext(int pagenum) {
    	
    	if(pagenum >0 && pagenum<6) {
    		setPrev(false);
    		setNext(true);
    	}else if(getLastblock() == getCurrentblock()) {
    		setPrev(true);
    		setNext(false);
    	}else {
    		setPrev(true);
    		setNext(true);
    	}
    }
    
    
    
    //게시판에 몇 페이지 까지 표시할지 계산하는 함수
    public int calcpage(int totalcount,int contentnum) {
    	
    	int totalpage = totalcount/contentnum;
    	if(totalcount/contentnum>0) {
    		totalpage++;
    	}
    	return totalpage;
    }
    
    
    public int getPageChecknum() {
    	return pageChecknum;
    }
    
    public void setPageChecknum(int pagenum) {
    	this.pageChecknum = pagenum *5;
    }
    
    public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getContentnum() {
		return contentnum;
	}
	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
	}
	public int getStartPage() {
		return startPage;
	}
	
	//시작페이지  
	//페이지 블록 5개씩 
	public void setStartPage(int currentblock) {
		this.startPage = (currentblock*5)-4;
	}
	public int getEndPage() {
		return endPage;
	}
	
	//끝페이지
	public void setEndPage(int getlastblock,int getcurrentblock) {
		if(getlastblock == getcurrentblock) {
			//예외경우 해당 페이지가 마지막 블록인 경우 
			this.endPage=calcpage(getTotalcount(),getContentnum());
		}else {
			//첫페이지 +4 하면 끝 페이지
			this.endPage=getStartPage()+4;
		}
		
	}
	
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentblock() {
		return currentblock;
	}
	
	//현재페이지
	//페이지 번호를 통해서 구한다
	public void setCurrentblock(int pagenum) {
		this.currentblock = pagenum/5;
		if(pagenum%5>0) {
			this.currentblock++;
		}
	}
	public int getLastblock() {
		return lastblock;
	}
	
	
	//마지막 블록 
	//한 블록당 50개의 페이지가 있음
	public void setLastblock(int totalcount) {
		this.lastblock = totalcount/(5*this.contentnum);
		if(totalcount/(5*this.contentnum)>0) {
			this.lastblock++;
		}
	}
    
    
    
    
    
    
}
