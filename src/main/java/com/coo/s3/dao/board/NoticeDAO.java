package com.coo.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coo.s3.model.board.NoticeVO;
import com.coo.s3.util.RowMaker;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	public int noticeInsert(NoticeVO vo) throws Exception{
		
		int result=sqlSession.insert(NAMESPACE+"noticeInsert", vo);
		
		return result;
	}
	
	public int noticeDelete(int num) throws Exception{
		
		int result = sqlSession.delete(NAMESPACE+"noticeDelete",num);
		
		return result;
	}
	
	public NoticeVO noticeSelect(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", map);
	}
	
	
	public int noticeCount(RowMaker maker) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"noticeCount",maker);
	}
	
	public List<NoticeVO> noticeList(RowMaker maker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"noticeList",maker);
	}
	
	public int noticeUpdate(NoticeVO vo) throws Exception{
		return sqlSession.update(NAMESPACE+"noticeUpdate",vo);
	}
}


















