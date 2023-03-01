package kr.or.ddit.book.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookModifyController {
	
	/*
	 * 서비스 호출하기 위해 IBookService를 의존성 주입한다.
	 */
	@Inject
	private IBookService bookService;
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = bookService.selectBook(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", detailMap);
		mav.setViewName("book/update");  // .jsp 빠져있는거임
		return mav;
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isUpdateSuccess = bookService.updateBook(map);
		
		if(isUpdateSuccess) { // 정상
			// 업데이트가 정상적으로 데이터 갱신되었을때 확인을 위해 상세 페이지로 이동합니다.
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);
		}else {				// 실패
			// 갱신이 되지 않았을 경우, GET 메소드로 redirect하는 방법도 있지만,
			// 상세보기 화면을 바로 보여 줄 수도 있습니다.
			mav = update(map);
		}
		return mav;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		// 삭제가 성공했는지 확인합니다.
		boolean isDeleteSuccess = bookService.removeBook(map);
		if(isDeleteSuccess) {	// 삭제 완료
			// 삭제가 성공했으면 상세 페이지가 없으므로 목록으로 redirect한다.
			mav.setViewName("redirect:/book/list.do");
		}else {
			// 삭제가 실패했으면 다시 상제페이지로 이동하여 삭제를 재시도 할 수 있도록 한다.
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		}
		return mav;
	}
	
}
