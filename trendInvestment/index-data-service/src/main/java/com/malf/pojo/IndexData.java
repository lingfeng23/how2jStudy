package com.malf.pojo;

/**
 * @author malf
 * @description 指数数据实体类
 * @project trendInvestment
 * @since 2020/11/6
 */
public class IndexData {
	// 日期
	String date;
	// 盘点
	float closePoint;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getClosePoint() {
		return closePoint;
	}

	public void setClosePoint(float closePoint) {
		this.closePoint = closePoint;
	}
}
