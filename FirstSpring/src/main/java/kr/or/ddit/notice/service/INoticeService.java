package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeService {
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);
	public NoticeVO selectNotice(int noticeno);
	public ServiceResult insertNotice(NoticeVO noticeVO);
	public ServiceResult updateNotice(NoticeVO noticeVO);
	public ServiceResult deleteNotice(int noticeNo);
}
