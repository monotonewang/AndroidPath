package com.androidpath.view.listview.listviewdataparse83.bean;

public class Weather {
	/*"fengxiang": "北风",
    "fengli": "3-4级",
    "high": "高温 5℃",
    "type": "晴",
    "low": "低温 -6℃",
    "date": "30日星期三"*/
	
	private String fengxiang,fengli,high,type,low,date;

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(String fengxiang, String fengli, String high, String type,
			String low, String date) {
		super();
		this.fengxiang = fengxiang;
		this.fengli = fengli;
		this.high = high;
		this.type = type;
		this.low = low;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Weather [fengxiang=" + fengxiang + ", fengli=" + fengli
				+ ", high=" + high + ", type=" + type + ", low=" + low
				+ ", date=" + date + "]";
	}
	
	
}
