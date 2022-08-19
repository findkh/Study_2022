package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardListController {
	
	//@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
	
		System.out.println("�� ��� �˻� ó��");
		
//		//1. ����� �Է� ���� ����
//		//2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//		
//		// 3. �˻� ����� ȭ�� ������ MadelAndView�� �����Ͽ� �����Ѵ�.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("boardList", boardList);
//		mav.setViewName("getBoardList");
//		return mav;
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //model ���� ����
		mav.setViewName("getBoardList.jsp"); //view ���� ����
		return mav;
	}
}
