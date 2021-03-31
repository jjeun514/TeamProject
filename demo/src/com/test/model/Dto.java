package com.test.model;

public class Dto {
	private String sysId,sysPw,ename;
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
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
		return "Dto [sysId=" + sysId + ", sysPw=" + sysPw + ", ename=" + ename + ", empNo=" + empNo + ", deptno="
				+ deptno + "]";
	}
	
	
	
	
	
}