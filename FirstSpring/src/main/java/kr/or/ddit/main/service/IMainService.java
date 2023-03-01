package kr.or.ddit.main.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;

public interface IMainService {
	public List<BoardVO> selectBoardList();

	public List<NoticeVO> selectNoticeList();
}
