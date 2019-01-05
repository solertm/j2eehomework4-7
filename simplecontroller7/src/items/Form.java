package items;

import java.util.ArrayList;

public class Form{
	private String name;
	private String action;
	private String method;
	private ArrayList<View> viewlist=new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public ArrayList<View> getViewlist() {
		return viewlist;
	}
	public void setViewlist(ArrayList<View> viewlist) {
		this.viewlist = viewlist;
	}
	public String tohtml() {
		StringBuilder result = new StringBuilder();
		result.append("<form");
		if(name!=null)result.append(" name=\""+name+"\"");
		if(action!=null)result.append(" action=\""+action+"\"");
		if(method!=null)result.append(" method=\""+method+"\"");
		result.append(">");
		for(View w:viewlist) {
			result.append(w.tohtml());
		}
		result.append("</form>");
		return result.toString();
	}
	@Override
	public String toString() {
		return "<form  action=\"" + action + "\" method=\"" + method + "\">"+"\n";
	}


}
