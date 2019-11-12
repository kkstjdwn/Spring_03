package com.coo.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
