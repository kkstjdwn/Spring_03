package com.coo.s3;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.coo.s3.dao.board.QnaDAO;
import com.coo.s3.model.board.QnaVO;

public class QnaDAO_Test extends TestAbstractCase{
	@Inject
	private QnaDAO dao;
	
	@Test
	public void test() throws Exception{
		for (int i = 0; i < 120; i++) {
			QnaVO vo = new QnaVO();
			vo.setTitle("질문번호 "+i);
			vo.setWriter("질문자 "+i);
			vo.setContents("내용"+i);
			
			dao.qnaInsert(vo);
			Thread.sleep(50);
		}
	}

}
