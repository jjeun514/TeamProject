package com.test.model;

public class Dto {
	private String sysId,sysPw;
	private int empNo, deptno;
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getSysPw() {
		return sysPw;
	}
	public void setSysPw(String sysPw) {
		this.sysPw = sysPw;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Dto [sysId=" + sysId + ", sysPw=" + sysPw + ", empNo=" + empNo + ", deptno=" + deptno + "]";
	}
	
	
	
	
	
	
}