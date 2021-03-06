package com.coo.s3.util;

public class Pager {
	
	private Integer curPage;

	private final Integer PERPAGE = 10;
	private String kind;
	private String search;
	
	public String getKind() {
		return kind;
	}



	public void setKind(String kind) {
		this.kind = kind;
	}




	public String getSearch() {
		if (this.search == null) {

			this.search="";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}




	public Integer getTotalBlock() {
		return totalBlock;
	}



	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	private Integer totalPage;
	
	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}




	public Integer getLastNum() {
		return lastNum;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}




	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}


	public Integer getCurBlock() {
		return curBlock;
	}



	public Integer getTotalPage() {
		return totalPage;
	}



	public Integer getCurPage() {
		if (this.curPage==null || this.curPage==0) {
			this.curPage = 1;

		}
		return curPage;
	}




	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}



	//DB
	public RowMaker rowMake() {
		int startRow = (this.getCurPage()-1)*this.PERPAGE + 1;
		int lastRow = this.getCurPage() * this.PERPAGE;
		
		RowMaker maker = new RowMaker();
		maker.setKind(getKind());
		maker.setSearch(getSearch());
		maker.setStartRow(startRow);
		maker.setLastRow(lastRow);

		
		return maker;
	}
	

	
	//View(JSP)
	public void makePager(int totalCount ) {
		//1.totalCount --> 매개변수
		//2.totalPage
		this.totalPage = totalCount/this.PERPAGE;
		if (totalCount%PERPAGE!=0) {
			totalPage++;
		}
		
		
		//3.totalBlock

		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if (totalPage%perBlock!=0) {
			totalBlock++;
		}

		//4.curPage 이용햇 현재 블록curBlock 표시

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

	}

