package com.ezen.ezdiary.admin.dto;

public class BoardPageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;
    
    //전체 게시물 수
    private int amount;
    
    //현재 페이지, 게시물 정보
    private AdminBoardDTO boardDTO;
	

 public BoardPageDTO(AdminBoardDTO boardDTO, int amount) {
        
        this.boardDTO = boardDTO;
        this.amount = amount;
        
        //한 블럭의 마지막 수
        this.endPage = (int)(Math.ceil(boardDTO.getPageNum()/10.0))*10;
        
        this.startPage = this.endPage - 9;
        
        //전체 마지막 페이지
        int realEnd = (int)(Math.ceil(amount * 1.0/boardDTO.getTotal()));
        
        /* 전체 마지막 페이지(realend)가 화면에 보이는 마지막페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정 */
        if(realEnd < this.endPage) {
            this.endPage = realEnd;
        }
        
        /* 시작 페이지 값이 1보다 크면 true */
        this.prev = this.startPage > 1;
        
        /* 마지막 페이지 값이 1보다 크면 true */
        this.next = this.endPage < realEnd;
        
        
    }


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public AdminBoardDTO getBoardDTO() {
		return boardDTO;
	}


	public void setBoardDTO(AdminBoardDTO boardDTO) {
		this.boardDTO = boardDTO;
	}


	@Override
	public String toString() {
		return "BoardPageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", amount=" + amount + ", boardDTO=" + boardDTO + "]";
	}
    
    


}
