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
		int totalCount = dao.qnaCount();
		pager.makePager(totalCount);
		return dao.qnaList(maker);
	}

}
