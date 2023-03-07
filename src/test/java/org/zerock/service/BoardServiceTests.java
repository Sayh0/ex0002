package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	BoardVO board = new BoardVO();
	private BoardVO makeTestDummy() {
		board.setTitle("서비스 테스트용 제목");
		board.setContent("서비스 테스트용 내용");
		board.setWriter("서비스 테스트용 작성자");
		return board;
	}
	
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}
	
	@Test
	public void registerTest() {
		makeTestDummy();
		service.register(board);
		log.info("생성된 서비스 테스트용 게시글 번호 : " + board.getBno());
	}
	
//	@Test
//	public void getListTest() {
//		service.getList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void getTest() {
//		log.info(service.get(7L));
//	}
	
	
	
	
	
}
