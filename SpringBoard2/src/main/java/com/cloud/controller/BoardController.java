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
	
	//목록 보기
	/*@GetMapping("/boardList")
	public String getBoardList(Model model) {
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);			//view로 전송
		return "/board/boardList";
	}*/
	
	//목록 보기
	@GetMapping("/boardList")
	public String getBoardList(Criteria cri, Model model) {
		List<BoardVO> boardList = service.getListWithPage(cri);
		int total = service.getTotalCount(cri);
		PageDTO pageMaker = new PageDTO(cri, total);
		
		model.addAttribute("boardList", boardList);			//view로 전송
		model.addAttribute("pageMaker", pageMaker);			//"pageMaker" -> boardList.jsp
		return "/board/boardList";
	}
	
	//글쓰기 폼 페이지 요청
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//글쓰기 처리 요청
	//@PreAuthorize("isAuthenticated()")
	@PostMapping("/insertBoard")
	public String insert(BoardVO vo) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {		//파일이 첨부되었다면
			String fileName = uploadFile.getOriginalFilename();	//파일 이름
			String filePath = "C:/upload/";		//파일의 실제 위치 
			uploadFile.transferTo(new File(filePath + fileName));
		}
		
		service.insert(vo);			
		return "redirect:/board/boardList";
	}
	
	//글 상세보기 처리, 댓글 목록
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/boardView")
	public String getBoard(int bno, Criteria cri, Model model) {
		service.updateCount(bno);							//조회수 증가
		BoardVO board = service.getBoard(bno);				//상세 보기 처리
		List<ReplyVO> replyList = replyService.getReplyList(bno);	//댓글 목록 처리
		
		model.addAttribute("board", board);					//model="board" 보내기
		model.addAttribute("cri", cri);						//model="cri" 보내기
		model.addAttribute("replyList", replyList);			//model="replyList" 보내기
		return "/board/boardView";
	}
	
	//글 삭제
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri,
			RedirectAttributes rttr) {		//redirect 경로로 전달할 경우 RedirectAttributes 사용
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//글 수정
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
	
	//댓글 등록
	@PostMapping("/reply")
	public String reply(ReplyVO vo, RedirectAttributes rttr) {
		log.info("댓글 작성");
		
		replyService.register(vo);				//등록 처리 서비스
		
		rttr.addAttribute("bno", vo.getBno());
		return "redirect:/board/boardView";
	}
}
