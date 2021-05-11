package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BoardVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "notice"; //Model.addAttribute("board", "notice"); 를 이 선언으로 공통선언
	}
	
	@GetMapping("list")
	public String getList(Model model) throws Exception {
		List<BoardVO> ar = noticeService.getList();
		model.addAttribute("list", ar);
		return "board/list";
	}
	
}
