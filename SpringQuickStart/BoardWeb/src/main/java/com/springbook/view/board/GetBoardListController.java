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
	
		System.out.println("글 목록 검색 처리");
		
//		//1. 사용자 입력 정보 추출
//		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//		
//		// 3. 검색 결과와 화면 정보를 MadelAndView에 저장하여 리턴한다.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("boardList", boardList);
//		mav.setViewName("getBoardList");
//		return mav;
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //model 정보 저장
		mav.setViewName("getBoardList.jsp"); //view 정보 저장
		return mav;
	}
}
