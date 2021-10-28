package com.example.demo.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j2
@Aspect
@Component
public class LogAdvice {
//    @Before("execution(* com.example.demo.service.SampleService*.*(..)) ")
//    public void logBefore() {
//        log.info("========================");
//    }

    // 전달받은 파라미터 로깅하기
    @Before("execution(* com.example.demo.service.SampleService*.add(int,int)) && args(num1,num2)")
    public void logBeforeWithParam(int num1, int num2) {
        log.info(num1 + " " + num2);
    }

//    @AfterThrowing(pointcut = "execution(* com.example.demo.service.SampleService*.*(..))",throwing = "exception")
//    public void logException(Exception exception){
//        log.info("exception occurred!");
//        log.info(exception);
//    }

    //Around가 진짜 기능이 많네
    //
    @Around("execution(* com.example.demo.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        log.info("Target : " + proceedingJoinPoint.getTarget());
        log.info("Params : " + Arrays.toString(proceedingJoinPoint.getArgs()));

        log.info("kind : " + proceedingJoinPoint.getKind());
        log.info("method signature :" + proceedingJoinPoint.getSignature());
        log.info("source location? :" + proceedingJoinPoint.getSourceLocation());

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("execution Time : " + (end - start) + " ms");

        return result;
    }
}
