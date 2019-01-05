package readXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import items.Form;
import items.View;

public class readviewXML {
	private SAXReader reader=new SAXReader();
	private Document document;
	private URL xmlPath;
	private String xmlpath;
	private ArrayList<Form> formlist=new ArrayList<>();
	
	public readviewXML(URL xmlPath) throws Exception{
		document=reader.read(xmlPath);
	}
	public readviewXML(String xmlpath)throws Exception{
		document=reader.read(xmlpath);
	}
	public void getformlist(){
		List<Element> list;
		list=document.getRootElement().elements();
		for(Element e:list) {
			if(e.getName().equals("body")) {
				List<Element> e1=e.elements();
				for(Element a:e1) {
					if(a.getName().equals("form")) {
						formlist.add(getform(a));
					}
				}
			}
		}
		System.out.println(formlist);
	}
	
	private Form getform(Element e) {
		Form aform=new Form();
		aform.setViewlist(getviewlist(e));
		List<Element> list=e.elements();
		for(Element a:list) {
			if(a.getName().equals("name")) aform.setName(a.getText());
			if(a.getName().equals("action")) aform.setAction(a.getText());
			if(a.getName().equals("method")) aform.setMethod(a.getText());
		}
		System.out.println(aform);
		return aform;
	}
	
	private ArrayList<View> getviewlist(Element e){
		ArrayList<View> viewlist=new ArrayList<>();
		List<Element> list=e.elements();
		for(Element a:list) {
			if(a.getName().endsWith("View")) {
				viewlist.add(getview(a));
			}
		}
		System.out.println(viewlist);
		return viewlist;
	}
	
	private View getview(Element e) {
		View v=new View();
		List<Element> list=e.elements();
		v.setViewname(e.getName());
		for(Element a:list) {
			if(a.getName().equals("name")) v.setName(a.getText());
			if(a.getName().equals("label")) v.setLabel(a.getText());
			if(a.getName().equals("value")) v.setValue(a.getText());
		}
		System.out.println(v);
		return v;
	}
	
	private String getheadtitle() {
		List<Element> list;
		list=document.getRootElement().elements();
		for(Element e:list) {
			if(e.getName().equals("header")) {
				List<Element> list1=e.elements();
				for(Element a:list1) {
					if(a.getName().equals("title")) {
						return a.getText();
					}
				}
			}
		}
		return null;
	}
	
	public String producehtml() {
		getformlist();
		String s="<html>"+"\n"+"<head>"+"\n"+"<title>"+getheadtitle()+"</title>"+"</head>"+"\n"+"<body>";
		StringBuilder result = new StringBuilder();
		result.append(s);
		for(Form a:formlist) {
			result.append(a.tohtml());	
		}
		result.append("</body></html>");
		return result.toString();
	}
}
