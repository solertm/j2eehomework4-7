package readXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import items.Bean;
import items.Field;

public class readDiXML {
	private SAXReader reader=new SAXReader();
	private Document document;
	private URL xmlPath;
	private String xmlpath;
	private ArrayList<Bean> BeansList=new ArrayList<>();
	
	public readDiXML(URL xmlPath) throws Exception{
		document=reader.read(xmlPath);
		readBeans();
	}
	public readDiXML(String xmlpath)throws Exception{
		document=reader.read(xmlpath);
		readBeans();
	}
	
	private void readBeans() {
		List<Element> list;
		list=document.getRootElement().elements();
		for(Element e:list) {
			if(e.getName().equals("bean")) {
				BeansList.add(analysisBean(e));
			}
		}
		System.out.println(BeansList);
	}
	
	private Bean analysisBean(Element e) {
		Bean b=new Bean(e.attributeValue("id"), e.attributeValue("class"));
		List<Element> list=e.elements();
		if(list.isEmpty()) {
			return b;
		}
		ArrayList<Field> fieldList=new ArrayList<>();
		for(Element a:list) {
			if(a.getName().equals("field")) {
				Field field=new Field(a.attributeValue("name"), a.attributeValue("bean-ref"));
				fieldList.add(field);
			}
		}
		b.setFieldList(fieldList);
		return b;
	}
	public ArrayList<Bean> getBeansList() {
		return BeansList;
	}	
}
