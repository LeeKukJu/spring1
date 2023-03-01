package kr.or.ddit.board.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardModifyController {
	
	@Inject
	private IBoardService boardService;
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String boardUpdateView(@RequestParam int boNo, Model model) {
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		model.addAttribute("status", "u"); // u : update 약자로 사용할거임
		
		return "board/form";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO, Model model) {
		String goPage = "";
		ServiceResult result = boardService.updateBoard(boardVO);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/board/detail.do?bono=" + boardVO.getBoNo();
		}else {
			model.addAttribute("board", boardVO);
			goPage = "board/form";
		}
		return goPage;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String boardDelete(int boNo, Model model) {
		String goPage = "";
		ServiceResult result = boardService.deleteBoard(boNo);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/board/list.do";
		}else {
			goPage = "redirect:/board/detail.do?bono=" + boNo;
		}
		return goPage;
	}
}
