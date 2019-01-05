package readXML;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

import items.Bean;
import items.Field;


public class BeanInstance {
	public static final String diXML_PATH = "di.xml";
	private String action;
	private String class_path;
	private String method;
	private Method m;
	private Method actionMethod;
	private ArrayList<Bean> beansList=new ArrayList<>();
	
	public BeanInstance(String action,String class_path,String method) throws Exception{
		this.action=action;
		this.class_path=class_path;
		this.method=method;
		URL dipath=this.getClass().getClassLoader().getResource(diXML_PATH);
		System.out.println(dipath);
		readDiXML reader=new readDiXML(dipath);
		beansList=reader.getBeansList();
		System.out.println("di.xml 解析完成");
	}

	private Object toInstance(String path) throws Exception{
		Class clzz=Class.forName(path);
//		Object obj=clzz.Instance();
		Constructor constructor=clzz.getConstructor(String.class,String.class,String.class);
		Object obj=constructor.newInstance("14","wang","111");
		System.out.println(path+" is instanced!");
		return obj;
	}
	
	private Object toInstance(String path,String id) throws Exception{
		Class clzz=Class.forName(path);
		Object obj=clzz.newInstance();
		System.out.println(path+" is instanced!");
		String methodName="set"+id;
		m=clzz.getDeclaredMethod(methodName, Object.class);
		actionMethod=clzz.getDeclaredMethod(method, null);
		return obj;
	}
	
	public Object beanstoInstance()throws Exception {
		for(Bean b:beansList) {
			if((b.getFieldList().isEmpty())&&(class_path.endsWith(b.getClass_path()))) {
				Object obj=toInstance(class_path);
				System.out.println(" is instanced!");
				return obj;
			}
			else if(class_path.endsWith(b.getClass_path())) {
				Object bi=null;
				String id=null;
				for(Field e:b.getFieldList()) {
					for(Bean c:beansList) {
						if(e.getBean_ref().equals(c.getId())) {
							bi=toInstance(c.getClass_path());
							
							id=c.getId();
							System.out.println(c.getId()+" is instanced!");
						}
					}
				}
				Object obj=toInstance(class_path,id);
				m.invoke(obj, bi);
				System.out.println(action+" and"+" id is instanced!");
				System.out.println(obj);
				return obj;
				
			}
		}
		return null;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(Method actionMethod) {
		this.actionMethod = actionMethod;
	}

	
	
	
}
