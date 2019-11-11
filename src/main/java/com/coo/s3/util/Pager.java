package com.coo.s3.util;

public class Pager {
	
	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	private Integer totalPage;


	public Integer getTotalPage() {
		return totalPage;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Pager() {
		perPage=10;
	}

	public Integer getCurPage() {
		if (this.curPage==null) {
			this.curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public RowMaker makeRow() {
		//rowNum 계산
		int startRow = (this.getCurPage()-1)*perPage+1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker maker = new RowMaker();
		maker.setStartRow(startRow);
		maker.setLastRow(lastRow);
		
		return maker;
	}
	
	public void makePager(int totalCount) {
		
		//	1.totalCount --> 매개변수
		//	2.totalPage
		this.totalPage = totalCount/this.perPage;
		if (totalCount%this.perPage!=0) {
			totalPage++;
		}
		//	3.totalBlock
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if (totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		 //4.curPage 이용해서 현재 블럭(curBlock) 표시
		this.curBlock = curPage/perBlock;
		if (curPage%perBlock != 0) {
			curBlock++;
		}
		
		//5.curBlock 이용해서 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*perBlock + 1; 
		this.lastNum = curBlock*perBlock;
		
		if (curBlock==totalBlock) {
			lastNum = totalPage;
		}
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}
	
	
}
