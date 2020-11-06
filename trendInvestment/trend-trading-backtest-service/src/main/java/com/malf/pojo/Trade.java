package com.malf.pojo;

/**
 * @author malf
 * @description 交易明细
 * @project trendInvestment
 * @since 2020/11/6
 */
public class Trade {
	// 购买日期
	private String buyDate;
	// 出售日期
	private String sellDate;
	// 购买盘点
	private float buyClosePoint;
	// 出售盘点
	private float sellClosePoint;
	// 收益
	private float rate;

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getSellDate() {
		return sellDate;
	}

	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	public float getBuyClosePoint() {
		return buyClosePoint;
	}

	public void setBuyClosePoint(float buyClosePoint) {
		this.buyClosePoint = buyClosePoint;
	}

	public float getSellClosePoint() {
		return sellClosePoint;
	}

	public void setSellClosePoint(float sellClosePoint) {
		this.sellClosePoint = sellClosePoint;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}
