package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardController {
	
	//@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("�� �� ��ȸ ó��");
		
//		//1. �˻��� �Խñ� ��ȣ ����
//		String seq = request.getParameter("seq");
//
//		//2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		BoardVO board = boardDAO.getBoard(vo);
//		
//		//3. �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("getBoard");
//		return mav;
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;		
	}
}
