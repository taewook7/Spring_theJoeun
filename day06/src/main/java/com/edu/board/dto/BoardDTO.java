package com.edu.board.dto;

import java.util.Date;

public class BoardDTO {
	private int b_no;			//게시글 번호
	private String b_title;		//게시글 제목
	private String b_detail; 	//게시글 내용
	private String b_writer;	//게시글 작성자
	private Date b_date;		//게시글 작성일자
	private int b_count;		//게시글 조회수
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_detail() {
		return b_detail;
	}
	public void setB_detail(String b_detail) {
		this.b_detail = b_detail;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	
	//toString은 언제사용하냐면 내용물을 보여줄떄 즉 오버라이딩이다
	
	@Override
	public String toString() {
		return "BoardDTO [b_no=" + b_no + ", b_title=" + b_title + ", b_detail=" + b_detail + ", b_writer=" + b_writer
				+ ", b_date=" + b_date + ", b_count=" + b_count + "]";
	}
	
	
	
	
}
