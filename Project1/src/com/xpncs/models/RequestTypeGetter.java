package com.xpncs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTypeGetter {
	//for getting type of request
	String typeOfRequest;
	
	//for login handler
	String username;
	String pass;
	
	//for reimbursementHandler
	Double amount;
	String timeSubmitted;
	String description;
	int author;
	boolean status;
	String type;
	
	
	
	
	
	public RequestTypeGetter(Double amount, String timeSubmitted, String description, int author, boolean status,
			String type) {
		super();
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.description = description;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public RequestTypeGetter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((typeOfRequest == null) ? 0 : typeOfRequest.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestTypeGetter other = (RequestTypeGetter) obj;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (typeOfRequest == null) {
			if (other.typeOfRequest != null)
				return false;
		} else if (!typeOfRequest.equals(other.typeOfRequest))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public RequestTypeGetter(String typeOfRequest, String username, String pass) {
		super();
		this.typeOfRequest = typeOfRequest;
		this.username = username;
		this.pass = pass;
	}
	public String getTypeOfRequest() {
		return typeOfRequest;
	}
	public void setTypeOfRequest(String typeOfRequest) {
		this.typeOfRequest = typeOfRequest;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "RequestTypeGetter [typeOfRequest=" + typeOfRequest + ", username=" + username + ", pass=" + pass
				+ ", amount=" + amount + ", timeSubmitted=" + timeSubmitted + ", description=" + description
				+ ", author=" + author + ", status=" + status + ", type=" + type + "]";
	}

	
	
}
