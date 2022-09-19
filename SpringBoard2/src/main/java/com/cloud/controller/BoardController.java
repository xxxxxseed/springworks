package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.domain.ReplyVO;
import com.cloud.service.BoardService;
import com.cloud.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")		//localhost:8080/board/*
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;
	
	//��� ����
	/*@GetMapping("/boardList")
	public String getBoardList(Model model) {
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);			//view�� ����
		return "/board/boardList";
	}*/
	
	//��� ����
	@GetMapping("/boardList")
	public String getBoardList(Criteria cri, Model model) {
		List<BoardVO> boardList = service.getListWithPage(cri);
		int total = service.getTotalCount(cri);
		PageDTO pageMaker = new PageDTO(cri, total);
		
		model.addAttribute("boardList", boardList);			//view�� ����
		model.addAttribute("pageMaker", pageMaker);			//"pageMaker" -> boardList.jsp
		return "/board/boardList";
	}
	
	//�۾��� �� ������ ��û
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//�۾��� ó�� ��û
	//@PreAuthorize("isAuthenticated()")
	@PostMapping("/insertBoard")
	public String insert(BoardVO vo) throws IllegalStateException, IOException {
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {		//������ ÷�εǾ��ٸ�
			String fileName = uploadFile.getOriginalFilename();	//���� �̸�
			String filePath = "C:/upload/";		//������ ���� ��ġ 
			uploadFile.transferTo(new File(filePath + fileName));
		}
		
		service.insert(vo);			
		return "redirect:/board/boardList";
	}
	
	//�� �󼼺��� ó��, ��� ���
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/boardView")
	public String getBoard(int bno, Criteria cri, Model model) {
		service.updateCount(bno);							//��ȸ�� ����
		BoardVO board = service.getBoard(bno);				//�� ���� ó��
		List<ReplyVO> replyList = replyService.getReplyList(bno);	//��� ��� ó��
		
		model.addAttribute("board", board);					//model="board" ������
		model.addAttribute("cri", cri);						//model="cri" ������
		model.addAttribute("replyList", replyList);			//model="replyList" ������
		return "/board/boardView";
	}
	
	//�� ����
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri,
			RedirectAttributes rttr) {		//redirect ��η� ������ ��� RedirectAttributes ���
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//�� ����
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/updateBoard")
	public String update(BoardVO vo, Criteria cri,
			RedirectAttributes rttr) {
		service.update(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//��� ���
	@PostMapping("/reply")
	public String reply(ReplyVO vo, RedirectAttributes rttr) {
		log.info("��� �ۼ�");
		
		replyService.register(vo);				//��� ó�� ����
		
		rttr.addAttribute("bno", vo.getBno());
		return "redirect:/board/boardView";
	}
}
