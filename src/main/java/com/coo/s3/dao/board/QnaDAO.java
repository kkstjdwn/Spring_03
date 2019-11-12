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
	
	public int qnaInsert(QnaVO vo) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"qnaInsert",vo);
	}
	
	public List<QnaVO> qnaList(RowMaker maker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"qnaList",maker);
	}
	
	public int qnaCount(RowMaker maker) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount",maker);
	}

	
}
