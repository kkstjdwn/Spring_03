package com.coo.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coo.s3.model.board.QnaVO;
import com.coo.s3.util.RowMaker;

@Repository
public class QnaDAO {
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "qnaMapper.";
	
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"qnaWrite",qnaVO);
	}
	
	public List<QnaVO> qnaList(RowMaker maker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"qnaList",maker);
	}
	
	public int qnaCount(RowMaker maker) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount",maker);
	}
	
	public QnaVO qnaSelect(QnaVO qnaVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaSelect",qnaVO);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaReply",qnaVO);
	}
	
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception{
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate",qnaVO);
	}

	
}
