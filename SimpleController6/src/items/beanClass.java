package items;

import java.util.ArrayList;

public class beanClass {
	private String name;
	private String table;
	private String id;
	private ArrayList<Property> proList=new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Property> getProList() {
		return proList;
	}
	public void setProList(ArrayList<Property> proList) {
		this.proList = proList;
	}
	@Override
	public String toString() {
		return "beanClass [name=" + name + ", table=" + table + ", id=" + id + ", proList=" + proList + "]";
	}
	

}
