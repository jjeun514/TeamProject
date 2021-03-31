package com.test.model;

public class StuInfoDto {

	private int stuNo, lecNo, java, web, framework, stuAtt, stuLate, stuAbsent, attTotal;
	private String stuName, stuPhone, lecName;
	
	private String lecStartDate, lecFinishDate, lecRoom, lecDays;
	
	public StuInfoDto() {
		// TODO Auto-generated constructor stub
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
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public int getStuAtt() {
		return stuAtt;
	}
	public void setStuAtt(int stuAtt) {
		this.stuAtt = stuAtt;
	}
	public int getStuLate() {
		return stuLate;
	}
	public void setStuLate(int stuLate) {
		this.stuLate = stuLate;
	}
	public int getStuAbsent() {
		return stuAbsent;
	}
	public void setStuAbsent(int stuAbsent) {
		this.stuAbsent = stuAbsent;
	}
	public int getAttTotal() {
		return attTotal;
	}
	public void setAttTotal(int attTotal) {
		this.attTotal = attTotal;
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
	public String getLecRoom() {
		return lecRoom;
	}
	public void setLecRoom(String lecRoom) {
		this.lecRoom = lecRoom;
	}

	public String getLecDays() {
		return lecDays;
	}

	public void setLecDays(String lecDays) {
		this.lecDays = lecDays;
	}
	
	
	
}
