package items;

public class Field {
	private String name;
	private String bean_ref;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBean_ref() {
		return bean_ref;
	}
	public void setBean_ref(String bean_ref) {
		this.bean_ref = bean_ref;
	}
	public Field(String name, String bean_ref) {
//		super();
		this.name = name;
		this.bean_ref = bean_ref;
	}
	@Override
	public String toString() {
		return "Field [name=" + name + ", bean_ref=" + bean_ref + "]";
	}

}
