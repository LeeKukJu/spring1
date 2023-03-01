package kr.or.ddit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class BoardServiceImpl implements IBoardService {

	@Inject
	private IBoardDAO boardDao;

	@Override
	public List<BoardVO> selectBoardList() {

		return boardDao.selectBoardList();
	}

	@Override
	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO) {
		return boardDao.selecBoardCount(pagingVO);
	}

	@Override
	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO) {
		return boardDao.selectBoardList(pagingVO);
	}

	@Override
	public BoardVO selectBoard(int bono) {
		boardDao.incrementHit(bono); // 조회수 증가
		return boardDao.selectBoard(bono);
	}

	@Override
	public ServiceResult insertBoard(BoardVO boardVO) {
		ServiceResult result = null;
		// 성공하면 1, 실패하면 0
		// boardVO안에 boNo가 들어있다.
		// selectKey 설정에 의해서 최신 글 번호가 담겨서 넘어온다.
		int status = boardDao.insertBoard(boardVO);
		if (status > 0) { // 등록 성공
			result = ServiceResult.OK;
		} else { // 등록 실패
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult updateBoard(BoardVO boardVO) {
		ServiceResult result = null;
		int cnt = boardDao.updateBoard(boardVO);
		if (cnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public ServiceResult deleteBoard(int boNo) {
		ServiceResult result = null;
		int cnt = boardDao.deleteBoard(boNo);
		if (cnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

}
