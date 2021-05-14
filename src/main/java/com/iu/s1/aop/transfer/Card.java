package com.iu.s1.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component                                                                  
@Aspect
public class Card {

	@Around("execution(* com.iu.s1.aop.transfer.Transfer.*())")//패키지에 클래스에 모든 ()메서드 안에 있는것들
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----탑승 전 카드 체크 ------");
		//joinPoint - 핵심메서드(버스,지하철)를 객체화
		Object obj = joinPoint.proceed();
		System.out.println(obj);
		System.out.println("------하차 시 카드 체크------");
		
		return obj;
	}
	@AfterReturning("execution(* com.iu.s1.board.notice.NoticeService.get*(..))")
	public void selectCheck() {
		System.out.println("select Query 정상 종료");
	}
}
