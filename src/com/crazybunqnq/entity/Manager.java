package com.crazybunqnq.entity;

import java.io.Serializable;

public class Manager implements Serializable {

	private static final long serialVersionUID = -5104275312023012417L;
	private int id;
	private String name;
	private String pwd;
	private int limits;

	public Manager() {

	}

	public Manager(int id, String name, String pwd, int limits) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.limits = limits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getLimits() {
		return limits;
	}

	public void setLimits(int limits) {
		this.limits = limits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + limits;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		Manager other = (Manager) obj;
		if (id != other.id)
			return false;
		if (limits != other.limits)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", pwd=" + pwd + ", limits=" + limits + "]";
	}
}
