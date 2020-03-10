package com.zhangyaoxing.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sku implements Serializable{
	private Integer id;
	private String title;//标题
	private String sell_point;//买点
	private BigDecimal price;//价格
	private int stock_count;
	private String barcode;
	private String image;
	private int status;
	private Date create_time;
	private Date update_time;
	private BigDecimal cost_price;
	private BigDecimal market_price;
	private String spu_id;
	private String cart_thumbnail;
	
	private Spu spu;
	//存放的规格和规格的属性列表  属性列表的值
	private List<SpecOption> specs;
	
	
	
	public Spu getSpu() {
		return spu;
	}
	public void setSpu(Spu spu) {
		this.spu = spu;
	}
	public List<SpecOption> getSpecs() {
		return specs;
	}
	public void setSpecs(List<SpecOption> specs) {
		this.specs = specs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSell_point() {
		return sell_point;
	}
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock_count() {
		return stock_count;
	}
	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public BigDecimal getCost_price() {
		return cost_price;
	}
	public void setCost_price(BigDecimal cost_price) {
		this.cost_price = cost_price;
	}
	public BigDecimal getMarket_price() {
		return market_price;
	}
	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}
	public String getSpu_id() {
		return spu_id;
	}
	public void setSpu_id(String spu_id) {
		this.spu_id = spu_id;
	}
	public String getCart_thumbnail() {
		return cart_thumbnail;
	}
	public void setCart_thumbnail(String cart_thumbnail) {
		this.cart_thumbnail = cart_thumbnail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((spu_id == null) ? 0 : spu_id.hashCode());
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
		Sku other = (Sku) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (spu_id == null) {
			if (other.spu_id != null)
				return false;
		} else if (!spu_id.equals(other.spu_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", sell_point=" + sell_point + ", price=" + price
				+ ", stock_count=" + stock_count + ", barcode=" + barcode + ", image=" + image + ", status=" + status
				+ ", create_time=" + create_time + ", update_time=" + update_time + ", cost_price=" + cost_price
				+ ", market_price=" + market_price + ", spu_id=" + spu_id + ", cart_thumbnail=" + cart_thumbnail
				+ ", spu=" + spu + ", specs=" + specs + "]";
	}
	
}
