package com.fjl.vo;

public class DepartList {

	private Integer id;
	private String name;
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	private long dcount;
	private String createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDcount() {
		return dcount;
	}
	public void setDcount(long dcount) {
		this.dcount = dcount;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
