package p.g.p.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_MemberInfo_StoryBoard;
import p.g.p.model.Join_Scrap_scrapFN;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.MemberService;
import p.g.p.service.Mp_MyPageList;
import p.g.p.service.MypageService;

import p.g.p.service.SidebarSerivce;
import p.g.p.service.StoryBoardService;

@Controller
public class MypageController {
	@Autowired
	private StoryBoardService storyboardservice;
	@Autowired
	private  MemberService service;
    @Autowired
	private Mp_MyPageList pagelistservice;
    @Autowired
	private MypageService mpservice;
    @Autowired
    private SidebarSerivce service2;
    
    ////////////////////////////////////////////////////마이페이지 들어가면 메인 
    @RequestMapping("/mypage/mp_main")
	public String mypage(HttpSession session, Model model, Board board, Member_info member) {

		String view = "home";

		String page = "mypage/mp_newmain.jsp";

		String ck = "s";

		member = pagelistservice.userck(session, member);
		

		if (member != null) {
			// 성공
			int member_idx = member.getMember_idx();

			// 사진 갯수
			int photo_count = service.countPhoto(member_idx);
			model.addAttribute("photo_count", photo_count);

			if (photo_count > 0) {

				ck = "y";

			} else {

				ck = "n";
			}
			
			// 사진들 가져오쟈
			List<Join_board_boardphoto> boardLatestPhoto = service.selectLatestPhoto(member_idx);
			if (boardLatestPhoto != null) {
				model.addAttribute("boardLatestPhoto", boardLatestPhoto);

			} else {
				boardLatestPhoto = null;
			}
			// 스크랩한 최근 사진 가져오쟈
			String scrapLatestPhoto = service.selectScrapLatestPhoto(member_idx);
			if (scrapLatestPhoto != null) {
				model.addAttribute("scrapLatestPhoto", scrapLatestPhoto);
			} else {
				scrapLatestPhoto = null;
			}

			// 좋아요한 최근 사진 가져오쟈
			String likeLatestPhoto = service.selectLikeLatestPhoto(member_idx);
			if (likeLatestPhoto != null) {
				model.addAttribute("likeLatestPhoto", likeLatestPhoto);
			} else {
				likeLatestPhoto = null;
			}
			
			model.addAttribute("member", member);
		} else {

			// 실패 뷰값 주삼
			// 실패
		}
		
		    //

		model.addAttribute("page", page);
		model.addAttribute("ck", ck);
		model.addAttribute("member", member);

		return view;

	}
 
    
    //좋아요
	@RequestMapping("/mypage/mp_myLike")
	public String myLikePage(HttpSession session, Model model, Member_info member) {

		String view = "";
		String page = "";

		member = pagelistservice.userck(session, member);
		if (member != null) {
			// 좋아요 가져오쟈
			view = "home";
			page = "mypage/mp_myLike.jsp";
			List<Join_board_boardphoto> likeList = service.selectLikeList(member.getMember_idx());
			if (likeList != null) {

				model.addAttribute("likeList", likeList);
			} else {
				likeList = null;
			}

			model.addAttribute("member", member);
		} else {

			// 에러페이지로 보내 이색기야

		}

		model.addAttribute("page", page);

		return view;
	}

	// 스토리
	@RequestMapping("/mypage/mp_myStory")
	public String myStoryPage(HttpSession session, Model model, Like like, Member_info member) {
		String view = "";
		String page = "";
		
		System.out.println("111111111"+member);

		member = pagelistservice.userck(session, member);
		
		System.out.println("222222222"+member);

		if (member != null) {
			
			
			List<Join_MemberInfo_StoryBoard> mpListStory = storyboardservice.selectMpStory(like,member);
			
			view = "home";
			page = "mypage/mp_myStory.jsp";
			
			if (mpListStory != null) {

				model.addAttribute("listStory", mpListStory);
			} else {
				mpListStory = null;
			}
			model.addAttribute("member", member);
		} else {

			// 에러페이지로 보내 이시키야
		}

		model.addAttribute("page", page);

		return view;
	}

	//댓글
	@RequestMapping(value = "/mypage/mp_myComment", method = RequestMethod.GET)
	public String myComment(HttpSession session, Model model, Member_info member) {
		String page = "";

		String view = "";
		
		member = pagelistservice.userck(session, member);
	
		if (member != null) {
			page = "mypage/mp_myComment.jsp";
			view = "home";
			
			List<Board_Comment> myComment = mpservice.Mp_myCommentList(member);
			System.out.println("아니왜죠"+myComment);
			
			if (myComment != null) {

				System.out.println("adjf"+myComment);
				model.addAttribute("myComment", myComment);
				System.out.println("adfadfadfadfadf");
			} else {
				myComment = null;
				System.out.println("여기로 들어와야 하는데?0?");
				model.addAttribute("myComment", myComment);
			}
			model.addAttribute("member",member);
		} else {

			// 에러 페이지 처리
		}

		model.addAttribute("page", page);

		return view;

	}

	//사진
	@RequestMapping(value ="/mypage/mp_myphoto",method=RequestMethod.GET)
	public String mypageMyphoto(HttpSession session, Model model, Member_info member,Like like) {
	
		String page = "";
		
		String view = "";
		
		member = pagelistservice.userck(session, member);
		
		if(member!=null) {
			
			view = "home";
			
			page = "mypage/mp_myphoto.jsp";
			
			List<PhotoListmodel> list = mpservice.myPhotolistview(member);
			
			if(list!=null) {

				model.addAttribute("listlist",list);
				
			}else {
				
				list = null;
			}
			
			model.addAttribute("member", member);
		}else {
			
			
			//에러페이지 처리 하세요 
		}
	
        model.addAttribute("page", page);

		return view;
		
	
	}
	
	//////////////////////////////////////////////////////////////////////////스크랩
	 @RequestMapping(value="/mypage/mp_scrap",method=RequestMethod.GET)
	   public String mypageScrap(Model model,
			   Join_Scrap_scrapFN scrap,HttpSession session) {
	      
	    
	      
	      Member_info member = (Member_info)session.getAttribute("user");
	      model.addAttribute("member", member);
	      
	        
	        
	      	//스크랩 폴더 명 리스트 보여주기 
	        List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
	        
	        model.addAttribute("scrapNameList", scrapNameList);
	        
	        
	        
	        //일단 scrapFN_idx 검색해오쟈
	        List<Integer> scrapfnidx = mpservice.selectscrapfnidx(member.getMember_idx());
	        System.out.println("3"+scrapfnidx);
	       
	        

	        //반복 횟수 (스크랩 폴더 갯수 )가져오쟈
	        int c = mpservice.countFnIdx(member.getMember_idx());
	      
	        
	        scrap.setMember_idx(member.getMember_idx());
	        
	        List<Integer> boardIdxList = new ArrayList<Integer>(); 
	        
	        
	        for(int i=0;i<c;i++) {
	        	
	        scrap.setScrapFN_idx(scrapfnidx.get(i));
	        
	        System.out.println("scrap있냐화기어마러"+scrap);
	        
	        int boardidxcheck = mpservice.boardIdxCheck(scrap);
	        
	        if(boardidxcheck>0) {
	        	
	        	 int boardidx = mpservice.selectScrapboardidx(scrap);
	             
	             boardIdxList.add(boardidx);
	        	
	        }else{ //스크랩 폴더에 스크랩 된 게시물이 하나도 없는 것이 있음 
	        	
	        	int boardidx = 0;
	        	boardIdxList.add(boardidx);
	        	
	        }
	        
	        }
	        
	       
	        //board_idx를 통해서 photo_name가져오기 
	        List<String> photonameList = new ArrayList<String>();
	        
	        for(int i=0;i<c;i++) {
	        	
	        	String photoname = mpservice.selectPhotoName(boardIdxList.get(i));
	        	
	        	if(photoname!=null) {
	        		photonameList.add(photoname);
	            		
	        	}else {
	        		photonameList.add("nothing");
	                		
	        	}
	        	
	        }
	        
	      
	        model.addAttribute("photonameList", photonameList);
	        
	       
	      String page = "mypage/mp_scrap.jsp";
	      String view = "home";
	      model.addAttribute("page", page);

	      return view;
	      
	   }
	   
	   //스크랩 디테일이얌 스크랩 폴더에 각각 들어갔을 때
	   @RequestMapping(value="/sidebar/scrapdetail")
	   public String ScrapDetail(@RequestParam("scrap_name")String scrap_name,Model model,
			   HttpSession session,Scrap scrap2) {
	      
		   Member_info member = (Member_info)session.getAttribute("user");
	      
	      model.addAttribute("member", member);
	      
	   
	      scrapFN scrap = service2.selectScrpaIdx(scrap_name);
	      
	      model.addAttribute("scrap", scrap);
	      
	   
	      
	      scrap2.setMember_idx(scrap.getMember_idx());
	      scrap2.setScrapFN_idx(scrap.getScrapFN_idx());
	      
	    
	      //각각 스크랩 폴더에 들어갔을 떄 출력되는 사진 리스트
	      List<Join_Scrap_scrapFN> scrapPhotoList = mpservice.selectScrapPhotoList(scrap2);
	      
	      model.addAttribute("scrapPhotoList",scrapPhotoList);
	      
	      
	      
	      
	      String view="home";
	      String page="mypage/mp_scrap_detail.jsp";
	      
	      model.addAttribute("page", page);
	      
	      return view;
	   }
	   
	   @RequestMapping(value="/sidebar/scrapdelete",method=RequestMethod.GET)
	   public String ScrapDelete(scrapFN scrapfn,Model model,HttpSession session,Member_info member) {
	      
	      member=pagelistservice.userck(session,member);
	      	
	      
		   if(member!=null) {
			   
			   int scrapFN_idx = service2.getscrapfnIdx(scrapfn);
			    //먼저 스크랩 폴더랑 연결되있는 스크랩 부터 모두 삭제하고 
			   int r = service2.DeleteMpScrap(scrapFN_idx);
			   
			   System.out.println("서비스 됐쟈"+scrapFN_idx);
			   
			   if(r>0) {
			   //스크랩 폴더 삭제
			   int resultC = service2.deleteScrapFolder(scrapfn);
			   
			   if(resultC>0) {
			         System.out.println("폴더를 삭제하지 ");
			      }else {
			         System.out.println("멍청아!!!!!!!!");
			      }
			   }else {
				   //스크랩 삭제 오류
			   }
		   }else {
			   //오류
		   }
	      
	     
	        model.addAttribute("member_id",member.getMember_id());
	      
	        List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
	      
	        model.addAttribute("scrapNameList", scrapNameList);
	      
	      String view="home";
	      String page="mypage/mp_scrap.jsp";
	      
	      model.addAttribute("page", page);
	      
	      return view;
	   }
	    
	   ////////////////////////////////////////////////////////회원 정보 수정
		@RequestMapping(value="/mypage/mp_update",method = RequestMethod.GET)
		public String mypageUpdateForm(@RequestParam("member_idx") String member_idx, Model model, Member_info member) {
			String page = "";
			String view = "";
			String phone1="";
			String phone2="";
			String phone3="";
			member = mpservice.Mp_update_select(member_idx);
			if (member != null) {
				
				if(member.getMember_phone()!=null) {
					 phone1 = member.getMember_phone().substring(0, 3);
					 phone2 = member.getMember_phone().substring(3, 7);
					 phone3 = member.getMember_phone().substring(7, 11);
				}
				if(member.getMember_birth()!=null) {
					
			
				System.out.println(member.getMember_birth());
				String birth = member.getMember_birth();
				if (birth != null) {
					String[] births = birth.split("-");
					if (births.length > 1) {
						for (int i = 0; i < births.length; i++) {
							System.out.println(births[i]);
						}
						String year = births[0];
						String month = births[1];
						String day = births[2];
						model.addAttribute("year", year);
						model.addAttribute("month", month);
						model.addAttribute("day", day);
					}

				}
				}
				
				page = "mypage/mp_update_form.jsp";
				view = "home";
				model.addAttribute("member", member);

				model.addAttribute("phone1", phone1);
				model.addAttribute("phone2", phone2);
				model.addAttribute("phone3", phone3);

			} else {

				// 값이 없을때
			}

			model.addAttribute("page", page);

			return view;

		}

		@RequestMapping(value="/mypage/mp_update",method = RequestMethod.POST)
		public String mypageUpdate(Member_info member, HttpServletRequest request, Model model,
				@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("day") String day,
				@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2,
				@RequestParam("phone3") String phone3) throws IllegalStateException, IOException {
				
		
		
			if (member != null) { // 값이 있으면 update 실행
				member.setMember_phone(phone1 + phone2 + phone3);
				member.setMember_birth(year + "-" + month + "-" + day);
				
			
				int resultCnt = mpservice.Mp_update(member, request);

				
				if (resultCnt > 0) {
					System.out.println("정상적으로 실행");
               } else {
					System.out.println("비어있는 값이 있습니다.");
				}
			}

			String page = "mypage/mp_update.jsp";
			String view = "home";
			
			model.addAttribute("member", member);
			model.addAttribute("page", page);

			return view;

		}

	
	
	
    
}
