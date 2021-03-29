package com.bit.model;

import java.sql.Date;

public class AdDto {
	
	private int lecNo;
	private String lecName;
	private Date lecStartDate,lecFinishDate;
	
	public AdDto() {
		// TODO Auto-generated constructor stub
	}

	public AdDto(int lecNo,String lecName, Date lecStartDate, Date lecFinishDate) {
		super();
		this.lecName = lecName;
		this.lecStartDate = lecStartDate;
		this.lecFinishDate = lecFinishDate;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lecFinishDate == null) ? 0 : lecFinishDate.hashCode());
		result = prime * result + ((lecName == null) ? 0 : lecName.hashCode());
		result = prime * result + lecNo;
		result = prime * result + ((lecStartDate == null) ? 0 : lecStartDate.hashCode());
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
		AdDto other = (AdDto) obj;
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
		if (lecStartDate == null) {
			if (other.lecStartDate != null)
				return false;
		} else if (!lecStartDate.equals(other.lecStartDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdDto [lecNo=" + lecNo + ", lecName=" + lecName + ", lecStartDate=" + lecStartDate + ", lecFinishDate="
				+ lecFinishDate + "]";
	}




	
	
	
	
}
