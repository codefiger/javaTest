package com.figer.Regex;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter<T> extends BaseAdapter{
	private List<T> list;
	
	public MyAdapter(List<T> list){
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("12");
		BaseAdapter adapter = new MyAdapter(list);
		
		System.out.println(((MyAdapter)adapter).getList().size());
	}
}
