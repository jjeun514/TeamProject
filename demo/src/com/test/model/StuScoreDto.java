package com.test.model;

public class StuScoreDto {

	private int stuNo,lecNo,java,web,framework;
	private String stuName,lecName;
	
	public StuScoreDto() {
		
	}

	public StuScoreDto(int stuNo, int lecNo, int java, int web, int framework, String stuName, String lecName) {
		super();
		this.stuNo = stuNo;
		this.lecNo = lecNo;
		this.java = java;
		this.web = web;
		this.framework = framework;
		this.stuName = stuName;
		this.lecName = lecName;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getLecNo() {
		return lecNo;
	}

	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getWeb() {
		return web;
	}

	public void setWeb(int web) {
		this.web = web;
	}

	public int getFramework() {
		return framework;
	}

	public void setFramework(int framework) {
		this.framework = framework;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + framework;
		result = prime * result + java;
		result = prime * result + ((lecName == null) ? 0 : lecName.hashCode());
		result = prime * result + lecNo;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		result = prime * result + stuNo;
		result = prime * result + web;
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
		StuScoreDto other = (StuScoreDto) obj;
		if (framework != other.framework)
			return false;
		if (java != other.java)
			return false;
		if (lecName == null) {
			if (other.lecName != null)
				return false;
		} else if (!lecName.equals(other.lecName))
			return false;
		if (lecNo != other.lecNo)
			return false;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		if (stuNo != other.stuNo)
			return false;
		if (web != other.web)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StuScoreDto [stuNo=" + stuNo + ", lecNo=" + lecNo + ", java=" + java + ", web=" + web + ", framework="
				+ framework + ", stuName=" + stuName + ", lecName=" + lecName + "]";
	}
	
	
	
}
