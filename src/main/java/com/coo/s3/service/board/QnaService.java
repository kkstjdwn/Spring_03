package com.coo.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.coo.s3.dao.board.QnaDAO;
import com.coo.s3.model.board.QnaVO;
import com.coo.s3.util.Pager;
import com.coo.s3.util.RowMaker;

@Service
public class QnaService {
	
	@Inject
	QnaDAO dao;
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		RowMaker maker = pager.rowMake();
		int totalCount = dao.qnaCount(maker);
		pager.makePager(totalCount);
		return dao.qnaList(maker);
	}
	
	
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		
		
		return dao.qnaWrite(qnaVO);
	}
	
	public QnaVO qnaSelect(QnaVO qnaVO) throws Exception{
		return dao.qnaSelect(qnaVO);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception{
		QnaVO pVO = dao.qnaSelect(qnaVO);
		System.out.println(qnaVO.getNum());
		
		int result = dao.qnaReplyUpdate(pVO);
		qnaVO.setRef(pVO.getRef());
		qnaVO.setStep(pVO.getStep()+1);
		qnaVO.setDepth(pVO.getDepth()+1);
		
		return dao.qnaReply(qnaVO);
		
	}

}
