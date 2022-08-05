package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
//	public void beforeLog(JoinPoint jp) {
//		//System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����");
//		String method = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		
//		System.out.println("[���� ó��]" + method + "() �޼ҵ� ARGS ���� : " + args[0].toString());
//	}
	
	//@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
//	@Before("allPointcut()")
	//PointcutCommon ����
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[���� ó��]" + method + "() �޼ҵ� ARGS ���� : " + args[0].toString());
	}
}
