package com.g04.o2o.entity;

import java.util.List;

public class JsonProtocol {
	private Boolean result;
	private List<Object> proList;
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public List<Object> getProList() {
		return proList;
	}
	public void setProList(List<Object> proList) {
		this.proList = proList;
	}
	public JsonProtocol() {
		super();
	}
}
