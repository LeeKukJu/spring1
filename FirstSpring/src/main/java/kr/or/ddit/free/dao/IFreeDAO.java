package kr.or.ddit.free.dao;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeDAO {

	int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	FreeVO selectFree(int freeno);

	int insertFree(FreeVO freeVO);

	int updateFree(FreeVO freeVO);

	void incrementHit(int freeno);

	int deleteFree(int freeNo);

}
