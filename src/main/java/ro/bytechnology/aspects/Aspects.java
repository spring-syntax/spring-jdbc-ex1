package ro.bytechnology.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class Aspects {
    private final static Logger logger = LoggerFactory.getLogger("log");

    @Pointcut("execution(* ro.bytechnology.dao.StudentDao.addStudent(..))")
    public void logAddStudent(){}

    @Pointcut("execution(* ro.bytechnology.dao.StudentDao.getStudentsName())")
    public void logListStudentsName(){}

    @Around("logAddStudent()")
    public void aroundAdd(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Successful DB operation {} !",joinPoint.toString());
        joinPoint.proceed();
    }

    @Around("logListStudentsName()")
    public List<String> aroundGet(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Successful DB operation {} !",joinPoint.toString());
        return (List<String>) joinPoint.proceed();
    }
}
