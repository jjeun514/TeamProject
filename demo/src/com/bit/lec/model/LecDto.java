package com.bit.lec.model;

import java.util.Date;

public class LecDto {

	/* 강의개설 - 강의명, 교육기간, 강의장, 강사, 수강생총원
	 *  (lecture) lecName, lecStartDate, lecFinishDate, lecRoom,
	 *  (emp)     ename -> empNo로 lecture테이블에서 강사와 특정 강의 연결
	 *  (student) lecNo로 학생목록 뽑아와서 count -> 해당 강의의 수강생 총원
	 *  
	 *  dummy에서 deptNo 3이 강사
	 *  
	 *  DB: project
	 */

	private int lecNo, totalStu, deptNo, empNo;
	private String lecName, lecRoom, ename, lecStartDate, lecFinishDate;
	
	public LecDto() {}
	
	public LecDto(int deptNo) {
		super();
		this.deptNo = deptNo;
	}

	public LecDto(int lecNo, int totalStu, String lecName, String lecRoom, String ename, String lecStartDate,
			String lecFinishDate) {
		super();
		this.lecNo = lecNo;
		this.totalStu = totalStu;
		this.lecName = lecName;
		this.lecRoom = lecRoom;
		this.ename = ename;
		this.lecStartDate = lecStartDate;
		this.lecFinishDate = lecFinishDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public int setEmpNo(int empNo) {
		return this.empNo = empNo;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getLecNo() {
		return lecNo;
	}

	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
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

	public String getLecStartDate() {
		return lecStartDate;
	}

	public void setLecStartDate(String lecStartDate) {
		this.lecStartDate = lecStartDate;
	}

	public String getLecFinishDate() {
		return lecFinishDate;
	}

	public void setLecFinishDate(String lecFinishDate) {
		this.lecFinishDate = lecFinishDate;
	}

	public int getTotalStu() {
		return totalStu;
	}

	public void setTotalStu(int totalStu) {
		this.totalStu = totalStu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((lecFinishDate == null) ? 0 : lecFinishDate.hashCode());
		result = prime * result + ((lecName == null) ? 0 : lecName.hashCode());
		result = prime * result + lecNo;
		result = prime * result + ((lecRoom == null) ? 0 : lecRoom.hashCode());
		result = prime * result + ((lecStartDate == null) ? 0 : lecStartDate.hashCode());
		result = prime * result + totalStu;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LecDto other = (LecDto) obj;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (lecFinishDate == null) {
			if (other.lecFinishDate != null)
				return false;
		} else if (!lecFinishDate.equals(other.lecFinishDate))
			return false;
		if (lecName == null) {
			if (other.lecName != null)
				return false;
		} else if (!lecName.equals(other.lecName))
			return false;
		if (lecNo != other.lecNo)
			return false;
		if (lecRoom == null) {
			if (other.lecRoom != null)
				return false;
		} else if (!lecRoom.equals(other.lecRoom))
			return false;
		if (lecStartDate == null) {
			if (other.lecStartDate != null)
				return false;
		} else if (!lecStartDate.equals(other.lecStartDate))
			return false;
		if (totalStu != other.totalStu)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LecListDto [lecNo=" + lecNo + ", totalStu=" + totalStu + ", lecName=" + lecName + ", lecRoom=" + lecRoom
				+ ", ename=" + ename + ", lecStartDate=" + lecStartDate + ", lecFinishDate=" + lecFinishDate + "]";
	}
}