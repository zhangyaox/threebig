package com.zhangyaoxing.entity;

import java.io.Serializable;

public class Brand implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Brand other = (Brand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	private String name;
	private String first_char;
	private String deleted_flag;
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
	public String getFirst_char() {
		return first_char;
	}
	public void setFirst_char(String first_char) {
		this.first_char = first_char;
	}
	
	public String getDeleted_flag() {
		return deleted_flag;
	}
	public void setDeleted_flag(String deleted_flag) {
		this.deleted_flag = deleted_flag;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", first_char=" + first_char + ", deleted_flag=" + deleted_flag
				+ "]";
	}
	
}
