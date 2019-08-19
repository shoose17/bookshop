package com.bookshop.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2016年12月22日 下午2:58:06
 * @version 1.0.0
 */
public class Page<T> {

	//当前页号
	private Integer currPageNO;
	//每页显示记录数，默认为3条记录
	private Integer perPageSize = 3;
	//总记录数
	private Integer allRecordNO;
	//总页数
	private Integer allPageNO;
	//该本页显示的内容
	private List<T> list = new ArrayList<>();
	
	public Page() {}
	
	public Integer getCurrPageNO() {
		return currPageNO;
	}
	public void setCurrPageNO(Integer currPageNO) {
		this.currPageNO = currPageNO;
	}
	public Integer getPerPageSize() {
		return perPageSize;
	}
	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}
	public Integer getAllRecordNO() {
		return allRecordNO;
	}
	public void setAllRecordNO(Integer allRecordNO) {
		this.allRecordNO = allRecordNO;
	}
	public Integer getAllPageNO() {
		return allPageNO;
	}
	public void setAllPageNO(Integer allPageNO) {
		this.allPageNO = allPageNO;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
