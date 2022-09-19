package com.cloud.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage;		//시작 페이지
	private int endPage;		//마지막 페이지
	private boolean prev, next;	//이전, 다음
	
	private int total;			//게시글 총 수
	private Criteria cri;		//페이지 번호, 페이지당 게시글 수 참조
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//마지막(끝) 페이지
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//시작 페이지
		this.startPage = this.endPage - 9;
		//실제 끝 페이지
		int realEndPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		//끝 페이지 조건
		this.endPage = realEndPage < endPage ? realEndPage : endPage;
		
		this.prev = this.startPage > 1;				//이전(메뉴)
		this.next = this.endPage < realEndPage;		//다음
	}
}
