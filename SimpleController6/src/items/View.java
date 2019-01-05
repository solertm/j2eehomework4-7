package items;

public class View{
	private String viewname;
	private String name;
	private String label;
	private String value;
	
	public String getViewname() {
		return viewname;
	}
	public void setViewname(String viewname) {
		this.viewname = viewname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String tohtml() {
		if(getViewname().equals("buttonView")) return button();
		else {
		StringBuilder result = new StringBuilder();
		if(getLabel()!=null) result.append(getLabel());
		result.append("<input");
		if(getViewname()!=null)result.append(" type=\""+getViewname()+"\"");
		if(getValue()!=null) result.append(" value=\""+getValue()+"\"");
		result.append(">"+"<br>");
		return result.toString();
		}
	}
	public String button() {
		StringBuilder result = new StringBuilder();
		result.append("<button");
		if(getName()!=null)result.append(" type=\"button\""+" ");
		result.append(">");
		if(getValue()!=null) result.append(getValue());
		if(getLabel()!=null)result.append(getLabel());
		result.append("</button>");
		return result.toString();
	}
	@Override
	public String toString() {
		return label+"<input type=\"" + viewname + " value=\"" + value +"\">"+"\n";
	}
	

}
