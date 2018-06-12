package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Like;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.report;
import p.g.p.model.scrapFN;

public interface Sb_dao {

	// 신고
	public int reportboard(report report);

	// 좋아요들!!! 좋아요 체크 되어있나 확인해보쟈
	public Like selectlikeck(Like like);

	// 게시물에 라이크 해준당
	public int likeup(Like like);

	// 게시물 라이크 수 업!
	public int likeUpdateUP(Board board);

	// 게시물 라이크 없어져랏 야아아ㅏㅏㅂ
	public int deletelike(Like like);

	// 게ㅣ물 라이크 수 다운!
	public int likeupdateDown(Board board);

	public PhotoListmodel mypagelikeck(String board_idx);

	// 스크랩 폴더명 리스트 보여주기
	public List<scrapFN> ScrapFolderNameList(int member_idx);

	// 스크랩 폴더명 입력하기
	public int insertFolderName(scrapFN scrapfn);

	// 스크랩 하기
	public int InsertScrap(Scrap scrap);

	// 스크랩 폴더명 삭제하기
	public int deleteScrapName(scrapFN scrapfn);

	// 스크랩 폴더명 수정하기
	public int updateScrapName(scrapFN fn);

	// 스크랩 폴더 가져오기
	public scrapFN selectIdx(String scrap_name);

	// 스크랩 되어 있나 일단 확인해야 하지 ㅠㅠ
	public Scrap selectscrapck(Scrap scrap);

	// 스크랩 되어 있나 일단 확인해야 하지 ㅠㅠList
	public List<Scrap> selectscrapckList(Scrap scrap);

	// 스크랩 수 증가
	public int scrapCntUp(Board board);

	// 스크랩 해제하기
	public int deleteScrap(Scrap scrap);

	// 스크랩 수 감소
	public int scrapCntDown(Board board);

	// 스크랩 정보 가져오기
	public Scrap scrapInfo(Board boardboard);

	// 스크랩 폴더 네임 IDX 가져와서 저장해야 함
	public int getScrapIdx(scrapFN scrapfn);

	// 보드 정보 가져오기
	public Board selectBoardInfo(int board_idx);

	// 마이페이지에서 스크랩 해제할 때
	public int deleteMpScrap(int scrapFN_idx);

	// 스크랩 폴더 idx가져오기
	public int getScrapfnIdx(scrapFN scrapfn);

}