package com.xpncs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tickets {
	
	int id;
	Double amount;
	String time_submitted;
	String time_resolved;
	String description;
	int author;
	int resolver;
	boolean status;
	String type;
	String fname;
	String lname;
	public Tickets() {
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
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + resolver;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((time_resolved == null) ? 0 : time_resolved.hashCode());
		result = prime * result + ((time_submitted == null) ? 0 : time_submitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tickets other = (Tickets) obj;
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
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		if (time_resolved == null) {
			if (other.time_resolved != null)
				return false;
		} else if (!time_resolved.equals(other.time_resolved))
			return false;
		if (time_submitted == null) {
			if (other.time_submitted != null)
				return false;
		} else if (!time_submitted.equals(other.time_submitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public Tickets(int id, Double amount, String time_submitted, String time_resolved, String description, int author,
			int resolver, boolean status, String type, String fname, String lname) {
		super();
		this.id = id;
		this.amount = amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
		this.fname = fname;
		this.lname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTime_submitted() {
		return time_submitted;
	}
	public void setTime_submitted(String time_submitted) {
		this.time_submitted = time_submitted;
	}
	public String getTime_resolved() {
		return time_resolved;
	}
	public void setTime_resolved(String time_resolved) {
		this.time_resolved = time_resolved;
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
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Tickets [id=" + id + ", amount=" + amount + ", time_submitted=" + time_submitted + ", time_resolved="
				+ time_resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + ", fname=" + fname + ", lname=" + lname + "]";
	}
	public Tickets(int id, Double amount, String time_submitted, String time_resolved, String description, int author,
			int resolver, boolean status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	
	
	
	
}
