package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("mybatis로 getBoard() 기능 처리");
		//검색 조건에 따른 분기 처리
//		if (vo.getSearchCondition().equals("TITLE")) {
//			return mybatis.selectOne("BoardDAO.getBoard_T", vo);
//		} else if (vo.getSearchCondition().equals("CONTENT")) {
//			return mybatis.selectOne("BoardDAO.getBoard_C", vo);
//		}
//		return null;
		
		return (BoardVO) mybatis.selectList("boardDAO.getBoardList", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
