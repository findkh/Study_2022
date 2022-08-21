package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		model.addAttribute("board", boardService.getBoard(vo)); //모델 정보 저장
		return "getBoard.jsp";
	}
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition, 
//		@RequestParam(value="searchKeyword", defaultValue="", required=false)String keyword, BoardVO vo, BoardDAO boardDAO, Model model) {	
//		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건: " + condition);
//		System.out.println("검색 단어: " + keyword);
//		model.addAttribute("boardList", boardDAO.getBoardList(vo)); //model 정보 저장
//		return "getBoardList.jsp"; //뷰 이름 리턴
//	}

	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {	
		System.out.println("글 목록 검색 처리");
		
		//null 체크
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //model 정보 저장
		return "getBoardList.jsp"; //뷰 이름 리턴
	}
	
}
