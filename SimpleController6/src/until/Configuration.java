package until;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import items.Property;
import items.beanClass;
import items.databasesource;
import items.Property;

public class Configuration {
	private databasesource datasource=new databasesource();
	private SAXReader reader=new SAXReader();
	private Document document;
	private URL xmlPath;
	private String xmlpath;
	private beanClass bean=new beanClass();

	public Configuration(URL xmlPath) throws Exception{
		document=reader.read(xmlPath);
		getjdbc();
		getclassBean();
	}
	public Configuration(String xmlpath)throws Exception{
		document=reader.read(xmlpath);
		getjdbc();
		getclassBean();
	}
	public Configuration(File file) throws Exception{
		document=reader.read(file);
		getjdbc();
		getclassBean();
	}
	public databasesource getDatasource() {
		return datasource;
	}
	public void setDatasource(databasesource datasource) {
		this.datasource = datasource;
	}
	private void getjdbc() {
		List<Element> list;
		list=document.getRootElement().elements();
		ArrayList<Property> proList=new ArrayList<>();
		for(Element e:list) {
			if(e.getName().equals("jdbc")) {
				proList=getpropertys(e);
			}
		}
//		System.out.println(proList);
		for(Property pro:proList) {
			if(pro.getName().equals("driver_class"))datasource.setDrivername(pro.getValue());
			if(pro.getName().equals("url_path")) datasource.setUrl(pro.getValue());
			if(pro.getName().equals("db_username")) datasource.setUsername(pro.getValue());
			if(pro.getName().equals("db_userpassword")) datasource.setUserPassword(pro.getValue());
		}
		System.out.println(datasource);
	}
	
	public ArrayList<Property> getpropertys(Element e) {
		List<Element> list;
		list=e.elements();
		ArrayList<Property> proList=new ArrayList<>();
		for(Element a:list) {
			if(a.getName().equals("property")) {
				proList.add(analysisProperty(a));
			}
		}
//		System.out.println(proList);
		return proList;
	}
	private Property analysisProperty(Element e) {
		List<Element> list;
		list=e.elements();
		Property pro=new Property();
		for(Element a:list) {
			if(a.getName().equals("name")) pro.setName(a.getText());
			if(a.getName().equals("value")) pro.setValue(a.getText());
			if(a.getName().equals("type")) pro.setType(a.getText());
			if(a.getName().equals("column")) pro.setColumn(a.getText());
			if(a.getName().equals("lazy")) pro.setLazy(a.getText());
		}
//		System.out.println(pro);
		return pro;
	}

	private void getclassBean() {
		List<Element> list;
		list=document.getRootElement().elements();
		ArrayList<Property> proList=new ArrayList<>();
		for(Element e:list) {
			if(e.getName().equals("class")) {
				proList=getpropertys(e);
				bean.setProList(proList);
				bean.setName(e.elementText("name"));
				bean.setTable(e.elementText("table"));
				bean.setId(e.element("id").elementText("name"));
			}
		}
		System.out.println(bean);
	}
	public beanClass getBean() {
		return bean;
	}
	public void setBean(beanClass bean) {
		this.bean = bean;
	}
	
}
