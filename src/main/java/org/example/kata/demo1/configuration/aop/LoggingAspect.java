package org.example.kata.demo1.configuration.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @AfterReturning(pointcut = "execution(* org.example.kata.demo1.service.*.saveProducts(..))", returning = "result")
    public void logSavedProducts(Object result) {
        if (result instanceof Long) {
            log.info("*** Aspect Enabled *** --> Nombre de produits sauvegardés : {}",
                    result);

        }


    }


}
