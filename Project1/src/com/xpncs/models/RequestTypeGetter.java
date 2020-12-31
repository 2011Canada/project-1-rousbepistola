package com.xpncs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	//for approval handler
	String timeResolved;
	int resolver;
	int id;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RequestTypeGetter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + resolver;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
	public RequestTypeGetter(String typeOfRequest, String username, String pass, Double amount, String timeSubmitted,
			String description, int author, boolean status, String type, String timeResolved, int resolver) {
		super();
		this.typeOfRequest = typeOfRequest;
		this.username = username;
		this.pass = pass;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.description = description;
		this.author = author;
		this.status = status;
		this.type = type;
		this.timeResolved = timeResolved;
		this.resolver = resolver;
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
	public String getTimeResolved() {
		return timeResolved;
	}
	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	@Override
	public String toString() {
		return "RequestTypeGetter [typeOfRequest=" + typeOfRequest + ", username=" + username + ", pass=" + pass
				+ ", amount=" + amount + ", timeSubmitted=" + timeSubmitted + ", description=" + description
				+ ", author=" + author + ", status=" + status + ", type=" + type + ", timeResolved=" + timeResolved
				+ ", resolver=" + resolver + "]";
	}
	
	
	
	
}
