package com.entor.entity;

public class PropertyValue {

	private int id;

    private int pid;

    private int ptid;

    private String value;

	@Override
	public String toString() {
		return "PropertyValue [id=" + id + ", pid=" + pid + ", ptid=" + ptid + ", value=" + value + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}