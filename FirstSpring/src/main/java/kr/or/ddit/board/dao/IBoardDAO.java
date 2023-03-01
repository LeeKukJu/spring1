package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDAO {
	public List<BoardVO> selectBoardList();

	public int selecBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

	public void incrementHit(int bono);

	public BoardVO selectBoard(int bono);

	public int insertBoard(BoardVO boardVO);

	public int updateBoard(BoardVO boardVO);

	public int deleteBoard(int boNo);
}
