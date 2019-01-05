package items;

import java.util.ArrayList;

public class Bean {
	private String id;
	private String class_path;
	private ArrayList<Field> fieldList=new ArrayList<>();
	
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClass_path() {
		return class_path;
	}
	public void setClass_path(String class_path) {
		this.class_path = class_path;
	}
	public Bean(String id, String class_path, ArrayList<Field> fieldList) {
		super();
		this.id = id;
		this.class_path = class_path;
		this.fieldList = fieldList;
	}
	public Bean(String id, String class_path) {
		super();
		this.id = id;
		this.class_path = class_path;
	}
	public ArrayList<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(ArrayList<Field> fieldList) {
		this.fieldList = fieldList;
	}
	@Override
	public String toString() {
		return "Bean [id=" + id + ", class_path=" + class_path + ", fieldList=" + fieldList + "]";
	}
	
	

}
