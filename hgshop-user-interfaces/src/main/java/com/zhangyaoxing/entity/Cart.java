package com.zhangyaoxing.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Cart implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int uid;
	private int skuid;
	private int pnum;
	private Date createtime;
	private Date updatetime;
	private BigDecimal sum_total;
	private BigDecimal sumtotal;
	
	private String title;
	
	private Sku sku;
	
	
	public BigDecimal getSumtotal() {
		return sumtotal;
	}

	public void setSumtotal(BigDecimal sumtotal) {
		this.sumtotal = sumtotal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Cart(Integer id, int uid, int skuid, int pnum, Date createtime, Date updatetime, BigDecimal sum_total,
			Sku sku) {
		super();
		this.id = id;
		this.uid = uid;
		this.skuid = skuid;
		this.pnum = pnum;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.sum_total = sum_total;
		this.sku = sku;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSkuid() {
		return skuid;
	}

	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getSum_total() {
		return sum_total;
	}

	public void setSum_total(BigDecimal sum_total) {
		this.sum_total = sum_total;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skuid;
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
		Cart other = (Cart) obj;
		if (skuid != other.skuid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuid=" + skuid + ", pnum=" + pnum + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", sum_total=" + sum_total + ", sumtotal=" + sumtotal + ", title="
				+ title + ", sku=" + sku + "]";
	}
	
}
