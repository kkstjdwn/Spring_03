package com.coo.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> noticeList(int curPage) throws Exception{
		int startRow = (curPage-1)*10 + 1;
		int lastRow	 = curPage * 10;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		//총 글의 갯수
		int totalCount = dao.noticeCount();
		//페이지의 갯수
		int totalPage = totalCount/10;
		if (totalCount%10!=0) {
			totalPage+=1; //totalPage++
		}
		//totalBlock
		int totalBlock = totalPage/5;
		if (totalPage%5!=0) {
			totalBlock++;
		}
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("totalPage", totalPage);
		map2.put("list", dao.noticeList(map));
		
		return map2;
	}
}
