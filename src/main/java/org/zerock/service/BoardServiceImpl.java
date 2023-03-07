package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;
	
	
	@Override
	public void register(BoardVO board) {
		log.info("register check..."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get check..."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify check..."+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove check..."+ bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList check...");
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList(Criteria) check...");
		return mapper.getListWithPaging(cri);
	}

}
