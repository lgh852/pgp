package p.g.p.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board_Photo  {

	private int photo_idx;
	private String photo_name;
	private MultipartFile FileName;
	private int board_idx;
	public Board_Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board_Photo(int photo_idx, String photo_name, MultipartFile fileName, int board_idx) {
		super();
		this.photo_idx = photo_idx;
		this.photo_name = photo_name;
		FileName = fileName;
		this.board_idx = board_idx;
	}
	@Override
	public String toString() {
		return "Board_Photo [photo_idx=" + photo_idx + ", p5hoto_name=" + photo_name + ", FileName=" + FileName
				+ ", board_idx=" + board_idx + "]";
	}
	public int getPhoto_idx() {
		return photo_idx;
	}
	public void setPhoto_idx(int photo_idx) {
		this.photo_idx = photo_idx;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public MultipartFile getFileName() {
		return FileName;
	}
	public void setFileName(MultipartFile fileName) {
		FileName = fileName;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	
	
}
