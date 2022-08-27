package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JPA�� insertBoard()");
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JPA�� updateBoard()");
		em.persist(vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JPA�� deleteBoard()");
		em.persist(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JPA�� getBoard()");
		return (BoardVO) em.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JPA�� getBoardList() ��� ó��");
		return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
	}
}
