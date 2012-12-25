package com.truemoney.product.api.activity.bean;

import java.util.List;

public class ActivityBeanList {
	private String object;
	private List<ActivityBean> lists;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public List<ActivityBean> getLists() {
		return lists;
	}

	public void setLists(List<ActivityBean> customerActivity) {
		this.lists = customerActivity;
	}
}
