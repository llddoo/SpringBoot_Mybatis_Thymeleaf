package com.iu.s1.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@ModelAttribute("board")
	public String getBoard() {
		return "qna"; //Model.addAttribute("board", "qna"); 를 이 선언으로 공통선언
	}
	
	@GetMapping("list")
	public String getList() throws Exception {
		return "board/list";
	}
}