package com.coo.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.coo.s3.dao.board.NoticeDAO;
import com.coo.s3.model.board.NoticeVO;
import com.coo.s3.util.Pager;
import com.coo.s3.util.RowMaker;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO dao;
	
	public int noticeInsert(NoticeVO vo) throws Exception{
		
		return dao.noticeInsert(vo);
	}
	
	public int noticeDelete(int num) throws Exception{
		return dao.noticeDelete(num);
	}
	
	public int noticeUpdate(NoticeVO vo) throws Exception{
		return dao.noticeUpdate(vo);
	}
	
	public NoticeVO noticeSelect(int num) throws Exception{
		return dao.noticeSelect(num);
	}
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception{
		
		RowMaker maker = pager.makeRow();
		pager.makePager(dao.noticeCount(maker));
		return dao.noticeList(maker);
	}
}
