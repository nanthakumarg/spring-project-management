package com.theybytecloud.pma.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ApplicationLoggerAspect {

   // private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.thebytecloud.pma.controllers..*)")
    public void definePackagePointcuts() {

    }

    @Before("definePackagePointcuts()")
    public void log() {
        log.debug("============================");
    }
}
