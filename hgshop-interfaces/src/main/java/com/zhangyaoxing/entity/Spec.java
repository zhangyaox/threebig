package com.zhangyaoxing.entity;

import java.io.Serializable;
import java.util.List;

public class Spec implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String spec_name;
	private List<SpecOption> options;
	public Spec(Integer id, String spec_name, List<SpecOption> options) {
		super();
		this.id = id;
		this.spec_name = spec_name;
		this.options = options;
	}
	public Spec() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	public List<SpecOption> getOptions() {
		return options;
	}
	public void setOptions(List<SpecOption> options) {
		this.options = options;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((spec_name == null) ? 0 : spec_name.hashCode());
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
		Spec other = (Spec) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (spec_name == null) {
			if (other.spec_name != null)
				return false;
		} else if (!spec_name.equals(other.spec_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Spec [id=" + id + ", spec_name=" + spec_name + ", options=" + options + "]";
	}
	
}
