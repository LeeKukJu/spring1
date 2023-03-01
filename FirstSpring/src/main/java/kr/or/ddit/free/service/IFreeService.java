package kr.or.ddit.free.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeService {

	int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	List<FreeVO> selecFreeList(PaginationInfoVO<FreeVO> pagingVO);

	FreeVO selectFree(int freeno);

	ServiceResult insertFree(FreeVO freeVO);

	ServiceResult updateFree(FreeVO freeVO);

	ServiceResult deleteFree(int freeNo);

}
