package com.g04.o2o.tools;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

@Component
public class SetterReflect {

	/** 
	 * 
	 * @param target 需要设置属性值的对象
 	 * @param property 属性的名字
	 * @param value 属性的值
	 * @return -1 更新值失败,1 更新成功
	 */
	public int updateValue(Object target, String property, Object value) {

		try {
			StringBuffer sb = new StringBuffer();
			
			char firstChar = Character.toUpperCase(property.charAt(0));
			
			Class<?> type = target.getClass().getDeclaredField(property).getType();
			
			String methodName = sb.append("set").append(firstChar).append(property.substring(1)).toString();
			
			Method setMethod = target.getClass().getDeclaredMethod(methodName, type);
			
			setMethod.invoke(target, value);
			
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

//	public static void main(String[] args) {
//		User user = new User();
//		user.setBlance(1000.0);
//		System.out.println(user.getBlance());
//		new SetterReflect().updateValue(user, "blance", new Double(2000.0));
//		System.out.println(user.getBlance());
//	}
}
