package com.esprit.kaddem.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.esprit.kaddem.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* com.esprit.kaddem.services.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }
   @AfterReturning(pointcut = "execution(* com.esprit.kaddem.services.*.*(..))", returning = "result")
    public void logMethodExitWithResult(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : " + result);
    }
    @AfterThrowing(pointcut = "execution(* com.esprit.kaddem.services.EquipeServiceImpl.deleteEquipe(..))", throwing = "exception")
    public void logMethodExitWithException(JoinPoint joinPoint, Exception exception) {
        String name = joinPoint.getSignature().getName();
        log.info("Exception in method " + name + " : " + exception);
    }
    @Around("execution( * com.esprit.kaddem.services.EtudiantServiceImpl.addEtudiant(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
