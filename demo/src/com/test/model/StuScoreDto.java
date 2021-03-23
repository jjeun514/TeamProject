package com.test.model;

public class StuScoreDto {

	private int stuNo,lecNo,java,web,framework;
	private String stuName,setPhone;
	
	public StuScoreDto() {
		
	}
	
	public StuScoreDto(int stuNo, int java, int web, int framework) {
		super();
		this.stuNo = stuNo;
		this.java = java;
		this.web = web;
		this.framework = framework;
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
	public String getSetPhone() {
		return setPhone;
	}
	public void setSetPhone(String setPhone) {
		this.setPhone = setPhone;
	}
	
	@Override
	public String toString() {
		return "StuScoreDto [stuNo=" + stuNo + ", lecNo=" + lecNo + ", java=" + java + ", web=" + web + ", framework="
				+ framework + ", stuName=" + stuName + ", setPhone=" + setPhone + "]";
	}
	
	
	
	
}
