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
//		for (int i = 83; i < 150; i++) {
//			NoticeVO vo = new NoticeVO();
//			vo.setTitle(i+"번째 제목");
//			vo.setWriter(i+"번째 작성자");
//			vo.setContents("ㅎ");
//			Thread.sleep(50);
//			int result = noticeDAO.noticeInsert(vo);
//			
//		}

		int count = noticeDAO.noticeCount();
		System.out.println(count/10+1);
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
