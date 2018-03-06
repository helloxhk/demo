package com.xhk.hibernate;

public class User {
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 花名
	 */
	private String pseudonym;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 修改时间
	 */
	private String lastupdate;
	/**
	 * ?
	 */
	private Long currentissuesource;
	
	public User() {
	}
	
	public User(String pseudonym, String realname) {
		super();
		this.pseudonym = pseudonym;
		this.realname = realname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudonym() {
		return pseudonym;
	}
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public Long getCurrentissuesource() {
		return currentissuesource;
	}
	public void setCurrentissuesource(Long currentissuesource) {
		this.currentissuesource = currentissuesource;
	}
	
}
