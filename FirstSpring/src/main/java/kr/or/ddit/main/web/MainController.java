package kr.or.ddit.main.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class MainController {
	
	@Inject
	private IMainService mainService;
	
	// '/'이거나 '/main.do'
	@RequestMapping(value = {"/","main.do"}, method = RequestMethod.GET)
	public String main(Model model) {
		// Model 데이터 전달자 이용
		
		List<BoardVO> boardList = mainService.selectBoardList();
		List<NoticeVO> noticeList = mainService.selectNoticeList();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("noticeList", noticeList);
		
		return "main";    // = "/WEB-INF/views/main.jsp";
	}
}
