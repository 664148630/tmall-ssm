package com.entor.entity;

import java.util.Date;

public class Review {

	  private int id;

	  private String content;

	  private int uid;

	  private int pid;

	  private Date createDate;

	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", uid=" + uid + ", pid=" + pid + ", createDate="
				+ createDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
