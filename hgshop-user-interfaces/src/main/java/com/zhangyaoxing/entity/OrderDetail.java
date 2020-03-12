package com.zhangyaoxing.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int skuid;
	private BigDecimal total;
	private int oid;
	private int pnum;
	
	private Sku sku;
	
	
	
	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(int oid,Cart cart) {
		super();
		this.oid=oid;
		this.pnum=cart.getPnum();
		this.total=cart.getSum_total();
		this.skuid=cart.getSkuid();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSkuid() {
		return skuid;
	}
	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + oid;
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
		OrderDetail other = (OrderDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oid != other.oid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", skuid=" + skuid + ", total=" + total + ", oid=" + oid + ", pnum=" + pnum
				+ ", sku=" + sku + "]";
	}
	
}
