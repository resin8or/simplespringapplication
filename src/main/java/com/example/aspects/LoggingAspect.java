package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by tobinj on 07/05/2018.
 */
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    //See video 12 for more info
    @Before("execution(void com.example..*.set*(*))")
    public void callSetters(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = joinPoint.getArgs()[0].toString();
        logger.info("Called " + method + " with arg "
                + arg + " on " + joinPoint.getTarget());
    }

    // The Around aspect is good for security and transactions
   // @Around("execution(String playGame())")
    public Object reportAroundCalls(ProceedingJoinPoint pjp) throws Throwable {
        boolean rain = Math.random() < 0.5;
        Object result = null;

        if(rain){
            logger.info((pjp.getTarget() + " rained out"));
        }
        else {
            result = pjp.proceed();
            logger.info(result.toString());
        }
        //logger.info("Around Call Test ...");

        return result;
    }
}
