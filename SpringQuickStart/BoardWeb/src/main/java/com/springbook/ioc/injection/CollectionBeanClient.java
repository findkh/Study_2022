package com.springbook.ioc.injection;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
//		List 타입
//		List<String> addressList = bean.getAddressList();

//		Set 타입
//		Set<String> addressList = bean.getAddressList();
		
//		for (String address : addressList) {
//			System.out.println(address.toString());
//		}
		
//		Map 타입
//		Map<String, String> addressList = bean.getAddressList();
//		
//		System.out.println(addressList.toString());
//		
//		factory.close();
	}
}
