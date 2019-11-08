package com.coo.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.coo.s3.dao.board.NoticeDAO;
import com.coo.s3.model.board.NoticeVO;

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
	
	public List<NoticeVO> noticeList() throws Exception{
		return dao.noticeList();
	}
}
