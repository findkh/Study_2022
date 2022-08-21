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
		System.out.println("�� ��� ó��");
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		model.addAttribute("board", boardService.getBoard(vo)); //�� ���� ����
		return "getBoard.jsp";
	}
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition, 
//		@RequestParam(value="searchKeyword", defaultValue="", required=false)String keyword, BoardVO vo, BoardDAO boardDAO, Model model) {	
//		System.out.println("�� ��� �˻� ó��");
//		System.out.println("�˻� ����: " + condition);
//		System.out.println("�˻� �ܾ�: " + keyword);
//		model.addAttribute("boardList", boardDAO.getBoardList(vo)); //model ���� ����
//		return "getBoardList.jsp"; //�� �̸� ����
//	}

	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("����", "TITLE");
			conditionMap.put("����", "CONTENT");
			return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {	
		System.out.println("�� ��� �˻� ó��");
		
		//null üũ
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //model ���� ����
		return "getBoardList.jsp"; //�� �̸� ����
	}
	
}
