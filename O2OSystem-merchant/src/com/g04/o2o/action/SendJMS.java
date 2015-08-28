package com.g04.o2o.action;

import com.g04.o2o.entity.JmsProtocol;
import com.g04.o2o.entity.JmsType;
import com.g04.o2o.tools.JMSUtil;
import com.g04.o2o.tools.JsonUtil;

public class SendJMS {
	public static void main(String[] args) {
		JMSUtil jms = new JMSUtil("g04_que");
		JmsProtocol msg = new JmsProtocol();
		msg.setType(JmsType.regist);
		jms.sendMsg(JsonUtil.toJSon(msg));
	}
}
