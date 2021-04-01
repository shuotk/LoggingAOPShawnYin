package com.bfs.demo.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.SerializationFeature;


@Component
@Aspect
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());

//    @Around("com.bfs.demo.aop.PointCuts.inDataAccessLayer()")
//    @Around(value = "bean(userDAO)")
//    @Around("within(com.bfs.demo.controller.UserController)")
    @Around("execution(* com.bfs.demo.controller.UserController.*(..))")
    public Object executionTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
//        System.out.println("ClassName: "+className);
//        System.out.println("MethodName: "+methodName);
//        System.out.println("Result: "+result);
        log.info(className+"."+methodName+" execution time: "+elapsedTime+" ms");
        return result;

    }

//    @Before("within(com.bfs.demo.controller.UserController)")
//    public void beforeAdvice(JoinPoint joinPoint){
//        log.info("Before Advice: "+ joinPoint.getSignature());
//    }
//
//    @AfterReturning(value = "bean(userController)", returning = "res")
//    public void afterReturningAdvice(Object res){
//        log.info("After Returning: " + res.toString());
//    }
//
//    @After("execution(com.bfs.demo.domain.UserResponse com.bfs.demo.controller..*(..))")
//    public void afterAdvice(JoinPoint joinPoint){
//        log.info("After Advice: "+ joinPoint.getSignature());
//    }

    @Before("within(com.bfs.demo.controller.*)")
    public void endpointBefore(JoinPoint p) throws JsonProcessingException {
        Object[] signatureArgs = p.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if (signatureArgs.length != 0) {
                log.info("Request object: " + mapper.writeValueAsString(signatureArgs[0]));
            }
        } catch (JsonProcessingException e){
        }
    }
    @AfterReturning(value = ("within(com.bfs.demo.controller.*)"),
            returning = "returnValue")
    public void endpointAfterReturning(JoinPoint p, Object returnValue) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                log.info("\nResponse object: " + mapper.writeValueAsString(returnValue));
            } catch (JsonProcessingException e) {
            }
    }
}



//    @Before
//    try{
//        return res;
//        @AfterReturning
//    }
//    catch(){
//        @AfterThrowing
//    }finally(){
//        @After
//    }
