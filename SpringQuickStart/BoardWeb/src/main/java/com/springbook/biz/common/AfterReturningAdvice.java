package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
//	public void afterLog(JoinPoint jp, Object returnObj) {
//		//System.out.println("[사후 처리] 비즈니스 로직 수행 전 동작");
//		String method = jp.getSignature().getName();
//		
//		if(returnObj instanceof UserVO) {
//			UserVO user = (UserVO) returnObj;
//			if(user.getRole().equals("Admin")) {
//				System.out.println(user.getName() + "로그인(Admin)");
//			}
//		}
//		
//		System.out.println("[사후 처리]" + method + "() 메소드 리턴값 : " + returnObj.toString());
//	}
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {}
//		
//	@AfterReturning(pointcut = "getPointcut()", returning="returnObj")
	
	//PointcutCommon 적용
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		//System.out.println("[사후 처리] 비즈니스 로직 수행 전 동작");
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}
		
		System.out.println("[사후 처리]" + method + "() 메소드 리턴값 : " + returnObj.toString());
	}
}
