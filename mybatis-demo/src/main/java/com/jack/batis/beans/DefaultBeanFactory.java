package com.jack.batis.beans;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.jack.batis.Batis;
import com.jack.batis.annotation.Autowired;
import com.jack.batis.annotation.Bean;
import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.Service;
import com.jack.batis.utils.ClassUtil;

public class DefaultBeanFactory implements BeanFactory{
	//bean容器，保存所有的bean均保存于此
	private static HashMap<String,JackBean> beanContainer=new HashMap<String,JackBean>();

	/**
	   * 对beanFactory进行初始化，实例化使用@Mapper、@Bean、@Service等注解的类，目前仅been均为单例
	 * @param classpath
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static void init(String classpath) throws InstantiationException, IllegalAccessException {
		ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
		Set<String> clzNameSet=null;
		 try {
			 clzNameSet = ClassUtil.getClassName(classpath, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Class<?> clz=null;
		//创建bean
		for (String clzName : clzNameSet) {
			try {
				//load class
				clz=clzLoader.loadClass(clzName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(isBean(clz)) {
				JackBean bean = new DufaultJackBean();
				Class<?> superClz = clz.getSuperclass();
				if(superClz!=null) {
					bean.setParentName(clz.getSuperclass().getName());
				}else {
					bean.setParentName(null);
				}
				bean.setBeanClassName(clz.getName());
				//如果是Mapper，则去拿代理类的实例
				if(clz.isAnnotationPresent(Mapper.class)) {
					bean.setInstance(Batis.getMapper(clz));
				}else {
					bean.setInstance(clz.newInstance());
				}
				beanContainer.put(clz.getName(), bean);
			}
		}
		//对容器中的bean进行初始化，对bean中的使用了@Autowired成员变量进行赋值
		for (String clzName : clzNameSet) {
			try {
				//load class
				clz=clzLoader.loadClass(clzName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			JackBean bean = beanContainer.get(clzName);
			Field[] fields = clz.getDeclaredFields();
			//String fieldsJson = JSONObject.toJSONString(fields);
			//System.out.println("fieldsJson: "+fieldsJson);
			for (Field field : fields) {
				if(field.isAnnotationPresent(Autowired.class)){
					Class<?> type = field.getType();
					Object fieldValue = beanContainer.get(type.getName()).getInstance();
					field.setAccessible(true);
					//如果是对象
					if(bean!=null) {
						field.set(bean.getInstance(), fieldValue);
					//如果bean为null且字段为静态
					}else if(Modifier.isStatic(field.getModifiers())){
						field.set(null, fieldValue);
					}
				}
			}
		}
		//String json = JSONObject.toJSONString(beanContainer);
		//System.out.println("beanContainer: "+json);
	}

	/**
	  *   如果类属于bean，则返回ture
	 * @param clz
	 * @return
	 */
	private static boolean isBean(Class<?> clz) {
		Objects.requireNonNull(clz);
		if(clz.isAnnotationPresent(Bean.class)||clz.isAnnotationPresent(Mapper.class)||clz.isAnnotationPresent(Service.class)) {
			return true;
		}
		return false;
	}


	public JackBean getBean(String clzName) {
		// TODO Auto-generated method stub
		return null;
	}
}
