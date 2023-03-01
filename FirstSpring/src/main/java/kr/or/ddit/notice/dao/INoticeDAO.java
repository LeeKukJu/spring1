package kr.or.ddit.notice.dao;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeDAO {

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public NoticeVO selectNotice(int noticeno);

	public void incrementHit(int noticeno);

	public int insertNotice(NoticeVO noticeVO);

	public int updateNotice(NoticeVO noticeVO);

	public int deleteNotice(int noticeNo);
}
