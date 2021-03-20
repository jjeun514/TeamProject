package com.bit.model;

public class Dto {
	private String sysId,sysPw;
	private int empNo;
	
	public Dto() {}

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

	@Override
	public String toString() {
		return "Dto [sysId=" + sysId + ", sysPw=" + sysPw + ", empNo=" + empNo + "]";
	}
}