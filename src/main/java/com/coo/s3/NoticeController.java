package com.coo.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s3.model.board.NoticeVO;
import com.coo.s3.service.board.NoticeService;

@Controller
@RequestMapping(value = "notice/**")
public class NoticeController {
	@Inject
	private NoticeService service;
	
	//List
	@RequestMapping("noticeList")
	public void noticeList(Model model) throws Exception	{
		List<NoticeVO> ar =  service.noticeList();
		
		model.addAttribute("list", ar);
		
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView noticeSelect(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		NoticeVO vo = service.noticeSelect(num);
		String msg="개수작부리지마세요";
		String path="noticeList";
		if (vo==null) {
			mv.addObject("msg", msg);
			mv.addObject("path", path);
			mv.setViewName("common/common_result");
		}else {
			
			mv.addObject("vo", vo);
			mv.setViewName("notice/noticeSelect");
		}
		
		return mv;
	}
	
	@RequestMapping("noticeWrite")
	public void noticeWrite(){
		
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO vo) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.noticeInsert(vo);
		
		String msg = "작성 실패";
		String path = "noticeList";
		if (result>0) {
			msg = "작성 성공";
			
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.addObject("vo", vo);
		mv.setViewName("common/common_result");
		
		
		return mv;
	}
	
	@RequestMapping("noticeUpdate")
	public void noticeUpdate(int num,Model model) throws Exception{
		model.addAttribute("vo", service.noticeSelect(num));
		
	}
	
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO vo) throws Exception{
		int result = service.noticeUpdate(vo);
		String msg = "수정 실패";
		if (result>0) {
			msg = "수정 성공";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception{
		int result = service.noticeDelete(num);
		String msg = "삭제 실패";
		String path = "noticeList";
		ModelAndView mv = new ModelAndView();
		if (result>0) {
			msg = "삭제 성공";
			
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}

}
