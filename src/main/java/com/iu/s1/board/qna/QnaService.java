package com.iu.s1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;

public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	
}
