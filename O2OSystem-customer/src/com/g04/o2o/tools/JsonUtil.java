package com.g04.o2o.tools;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	static ObjectMapper objectMapper;

	/**
	 * ʹ�÷��ͷ�������json�ַ���ת��Ϊ��Ӧ��JavaBean����
	 * ת��Ϊ��ͨJavaBean��readValue(json,Student.class)
	 * ת��ΪList:readValue(json,List.class
	 * ).��������������jsonת��Ϊ�ض����͵�List������List<Student>���Ͳ���ֱ�ӽ���ת���ˡ�
	 * ��ΪreadValue(json,List
	 * .class)������ʵ��List<Map>���ͣ��㲻��ָ��readValue()�ĵڶ���������List<Student
	 * >.class�����Բ���ֱ��ת����
	 * ���ǿ��԰�readValue()�ĵڶ�����������ΪStudent[].class.Ȼ��ʹ��Arrays.asList
	 * ();�����ѵõ�������ת��Ϊ�ض����͵�List�� ת��ΪMap��readValue(json,Map.class) ����ʹ�÷��ͣ��õ���Ҳ�Ƿ���
	 * 
	 * @param content
	 *            Ҫת����JavaBean����
	 * @param valueType
	 *            ԭʼjson�ַ�������
	 * @return JavaBean����
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> T readValue(String content, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper.readValue(content, valueType);
	}

	/**
	 * ��JavaBeanת��Ϊjson�ַ��� ��ͨ����ת����toJson(Student) Listת����toJson(List)
	 * Mapת��:toJson(Map) ���Ƿ��ֲ���ʲô���ͣ�������ֱ�Ӵ����������
	 * 
	 * @param object
	 *            JavaBean����
	 * @return json�ַ���
	 */
	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
