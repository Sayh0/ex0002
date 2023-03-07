package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" //컨트롤러 관련 테스트라
	// MVC 관련 설정도 같이 끌고와야 함
})
@Log4j
public class BoardControllerTests {
	// 컨트롤러 요청은 서버가 있어애(톰캣이 있어야) url 이 왔다갔다 할 수 있다.
	// 톰캣 대용 mock 객체 필요.
	
	@Autowired
	private WebApplicationContext ctx; //테스트용 스프링 컨테이너/컨텍스트
	
	private MockMvc mockMvc; //서버 대용 테스트 더미. 테스트용 톰캣.
	
	@Before // 어노테이션 하기 전에 호출
	public void setup() { // 목 객체를 얻기 위한 작업.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testList() throws Exception{
//		log.info(
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//		.andReturn()
//		.getModelAndView()
//		.getModelMap()
//		);
//	}
//	
//	@Test
//	public void testRegister() throws Exception {
//		
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새글 제목")
//				.param("content","테스트 새글 내용")
//				.param("writer", "테스트 새글 작성자"))
//				.andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//	}
	
//	@Test
//	public void TestGet() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//				.param("bno", "2"))
//				.andReturn()
//				.getModelAndView().getModelMap());
//	}
	
	@Test
	public void testList() throws Exception{
		log.info(
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "10"))
		.andReturn()
		.getModelAndView()
		.getModelMap()
		);
	}
}
