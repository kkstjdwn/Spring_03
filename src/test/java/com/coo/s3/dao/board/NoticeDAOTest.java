package com.coo.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.coo.s3.TestAbstractCase;
import com.coo.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase{
	@Inject
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void checkDAO() throws Exception{
//		assertNotNull(noticeDAO);
//	}
	
	@Test
	public void insertTest() throws Exception{
		NoticeVO vo = new NoticeVO();
		vo.setNum(1);
		vo.setTitle("셑제목");
		vo.setWriter("셑작성자");
		vo.setContents("셑내용");
		int result = noticeDAO.noticeUpdate(vo);
		assertEquals(1, result);
	}
//	
//	

//	@Test
//	public void deleteTest() throws Exception{
//		int result = noticeDAO.noticeDelete(2);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void selectTest() throws Exception{
//		List<NoticeVO> ar = noticeDAO.noticeList();
//		
//		assertEquals(0, ar.size());
//		
//	}
	
	
	
}
