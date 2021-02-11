package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {
	
	@Id
	private int cid;
	private String cname;
	private String email;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customers [cid=" + cid + ", cname=" + cname + ", email=" + email + "]";
	}
	
	

}
