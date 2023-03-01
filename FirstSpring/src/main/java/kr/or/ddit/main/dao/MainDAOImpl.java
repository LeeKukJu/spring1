package kr.or.ddit.main.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;

@Repository
public class MainDAOImpl implements IMainDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVO> selectBoardList() {
		return sqlSession.selectList("Main.selectBoardList");
	}

	@Override
	public List<NoticeVO> selectNoticeList() {
		return sqlSession.selectList("Main.selectNoticeList");
	}

}
