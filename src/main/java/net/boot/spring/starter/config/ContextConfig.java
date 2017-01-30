package net.boot.spring.starter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource ({"classpath*:AppContextConfig.xml"})

//@PropertySource({"classpath:env-${envTarget:dev}.properties"})
public class ContextConfig {


    
}
