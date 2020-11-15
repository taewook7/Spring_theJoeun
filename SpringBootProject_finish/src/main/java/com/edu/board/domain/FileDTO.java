package com.edu.board.domain;

public class FileDTO {
	private int fno;  //파일의 일련번호 
	private int bno;  // 게시글 번호
	private String fileName;  // 저장될 파일명 
	private String fileOriName;  //원래 파일명
	private String fileUrl;  // 파일의 위치
	
	
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", bno=" + bno + ", fileName=" + fileName + ", fileOriName=" + fileOriName
				+ ", fileUrl=" + fileUrl + "]";
	}
	
	
	
}
