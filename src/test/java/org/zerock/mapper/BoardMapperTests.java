package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper; 
	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새 제목");
//		board.setContent("새 내용");
//		board.setWriter("새 글쓴이");
//		
//		boardMapper.insert(board);
//		
//		log.info(board);
//	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새 제목2");
		board.setContent("새 내용2");
		board.setWriter("새 글쓴이2");
		
		boardMapper.insertSelectKey(board);
		
		log.info(board);
	}
	
//	@Test
//	public void testReadList() {
//		List<BoardVO> list = boardMapper.getList();
//		list.forEach(board -> log.info(board));
//	}
//	
//	@Test
//	public void testRead() {
//		BoardVO board = boardMapper.read(6L);
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		boardMapper.delete(5L);
//		List<BoardVO> list = boardMapper.getList();
//		list.forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(1L);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		board.setWriter("수정된 작성자");
//		//count 1 이면 삭제됨 / 0 이면 실패.
//		int count = boardMapper.update(board);
//		log.info("UPDATE COUNT : " + count);
//		
//	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		
//		List<BoardVO> board =boardMapper.getListWithPaging(cri);
//		for(BoardVO b : board) {
//			log.info(b);
//		}
//	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("테스트");
		cri.setType("테스트");
	
		
		List<BoardVO> board =boardMapper.getListWithPaging(cri);
		for(BoardVO b : board) {
			log.info(b);
		}
	}
	
	
}
