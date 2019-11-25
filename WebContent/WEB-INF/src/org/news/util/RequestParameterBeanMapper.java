package org.news.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;

/**
 * 请求参数映射bean实例工具
 * 只能绑定基本数据类型 字符串类型
 * @author Hes
 *
 */
public class RequestParameterBeanMapper {
	private static Map<Object, Object> typeMap;
	private static Set<Class<?>> types; 
	static {
		typeMap = new HashMap<>();
		typeMap.put(byte.class, Byte.class);
		typeMap.put(short.class, Short.class);
		typeMap.put(int.class, Integer.class);
		typeMap.put(long.class, Long.class);
		typeMap.put(double.class, Double.class);
		typeMap.put(float.class, Float.class);
		typeMap.put(boolean.class, Boolean.class);
		
		types = new HashSet<>();
		types.addAll(Arrays.asList(
				Byte.class, 
				Short.class,
				Integer.class,
				Long.class,
				Double.class, 
				Float.class, 
				Boolean.class));
		
	}
	/**
	 * 从请求中找出与bean的属性名相匹配的字段，并通过对象的setter方法赋值
	 * 
	 * 
	 * @param request
	 * @param 
	 * @return 返回bean实例
	 */
	public static <T>T getBean(ServletRequest request, Class<T> c){
		T t = null;
	  Field f = null;
	  Method m = null ;
	  Class<?> fieldType = null;
	  Class<?> acceptableFieldType = null;
	  Object fieldValue = null;
		try {
			t = c.newInstance();
			  Enumeration<String> es = request.getParameterNames();
			  while(es.hasMoreElements()) {
				  String s = es.nextElement();
//				  System.out.println(s);
				  try {
					  f = c.getDeclaredField(s);
					  fieldType = f.getType(); // 获取属性类型
					  fieldValue = request.getParameter(s); // 获取属性值
					  // 获取 setter
					  m = c.getDeclaredMethod("set"+s.substring(0, 1).toUpperCase()+s.substring(1), fieldType);
					  // 如果bean的字段类型非String 则要类型转换 
					  if(fieldType != String.class) {
						  if(fieldType == char.class || fieldType == Character.class) {
							  fieldValue = Character.valueOf(fieldValue.toString().toCharArray()[0]);
						  }else {
							  acceptableFieldType = (Class<?>) typeMap.get(fieldType);
							  // 如果为基本数据类型则转换为包装类型
							  acceptableFieldType = acceptableFieldType == null ? types.contains(fieldType) ? fieldType : null  : acceptableFieldType;
								 if(acceptableFieldType!=null) {
									 // 调用包装类型的静态方法实现类型转换
									 fieldValue = acceptableFieldType.getDeclaredMethod("valueOf", String.class).invoke(null, fieldValue);
//									 System.out.println("field:"+f+"  method:"+m);
								 }
						  }
					  }
					  // 调用setter
					  m.invoke(t, fieldValue);
				  }catch(Exception e) {
//					  e.printStackTrace();
					  continue;
				  }
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
	}
}
