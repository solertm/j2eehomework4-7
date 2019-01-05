package items;

public class Property {
	private String name=null;
	private String value=null;
	private String column=null;
	private String type=null;
	private String lazy=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getLazy() {
		return lazy;
	}
	public void setLazy(String lazy) {
		this.lazy = lazy;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Property [name=" + name + ", value=" + value + ", column=" + column + ", type=" + type + ", lazy="
				+ lazy + "]";
	}
	
	

}
