package com.bit.model;

import java.util.Date;

public class LecListDto {

	/* 강의개설 - 강의명, 교육기간, 강의장, 강사, 수강생총원
	 *  (lecture) lecName, lecStartDate, lecFinishDate, lecRoom,
	 *  (emp)     ename -> empNo로 lecture테이블에서 강사와 특정 강의 연결
	 *  (student) lecNo로 학생목록 뽑아와서 count -> 해당 강의의 수강생 총원
	 *  
	 *  dummy에서 deptNo 3이 강사
	 *  
	 *  DB: project
	 */
	private String lecName, lecRoom, ename;
	private int lecNo;
	private Date lecStartDate, lecFinishDate;
	
	public LecListDto() {}

	public LecListDto(String lecName, String lecRoom, String ename, int lecNo, Date lecStartDate, Date lecFinishDate) {
		super();
		this.lecName = lecName;
		this.lecRoom = lecRoom;
		this.ename = ename;
		this.lecNo = lecNo;
		this.lecStartDate = lecStartDate;
		this.lecFinishDate = lecFinishDate;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public String getLecRoom() {
		return lecRoom;
	}

	public void setLecRoom(String lecRoom) {
		this.lecRoom = lecRoom;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getLecNo() {
		return lecNo;
	}

	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}

	public Date getLecStartDate() {
		return lecStartDate;
	}

	public void setLecStartDate(Date lecStartDate) {
		this.lecStartDate = lecStartDate;
	}

	public Date getLecFinishDate() {
		return lecFinishDate;
	}

	public void setLecFinishDate(Date lecFinishDate) {
		this.lecFinishDate = lecFinishDate;
	}

	@Override
	public String toString() {
		return "LecListDto [lecName=" + lecName + ", lecRoom=" + lecRoom + ", ename=" + ename + ", lecNo=" + lecNo
				+ ", lecStartDate=" + lecStartDate + ", lecFinishDate=" + lecFinishDate + "]";
	}
}