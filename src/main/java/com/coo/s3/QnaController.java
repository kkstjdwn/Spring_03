package com.coo.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s3.model.board.QnaVO;
import com.coo.s3.service.board.QnaService;
import com.coo.s3.util.Pager;

@Controller
@RequestMapping("qna/**")
public class QnaController {
	@Inject
	private QnaService service;
	
	@RequestMapping(value = "qnaList")
	public void qnaList(Model model, Pager pager) throws Exception{
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<QnaVO> ar =service.qnaList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		
	}
	
	@RequestMapping(value = "qnaWrite",method = RequestMethod.GET)
	public void qnaWrite( )throws Exception{
	}
	
	@RequestMapping(value = "qnaWrite",method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception{
		int result = service.qnaWrite(qnaVO);
		ModelAndView mv = new ModelAndView();
		String msg = "작성 실패";
		String path = "qnaList";
		if (result>0) {
			msg = "작성 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(Model model,QnaVO qnaVO) throws Exception{
		model.addAttribute("vo", service.qnaSelect(qnaVO));
	}
	
	@RequestMapping(value = "qnaReply")
	public void qnaReply(Model model,QnaVO qnaVO) throws Exception{
		model.addAttribute("vo", service.qnaSelect(qnaVO));
	}
	
	@RequestMapping(value = "qnaReply",method = RequestMethod.POST)
	public ModelAndView qnaReply(QnaVO qnaVO) throws Exception{
		int result = service.qnaReply(qnaVO);
		ModelAndView mv = new ModelAndView();
		String msg = "답변작성 실패";
		String path = "qnaList";
		if (result>0) {
			msg = "답변작성 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
