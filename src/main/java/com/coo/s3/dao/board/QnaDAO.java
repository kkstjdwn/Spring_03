package com.coo.s3.dao.board;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coo.s3.model.board.QnaVO;

@Repository
public class QnaDAO {
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "qnaMapper.";
	
	public int qnaInsert(QnaVO vo) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"qnaInsert",vo);
	}

	
}
