package net.boot.spring.starter.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletConfig{

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }
    
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                dispatcherServlet(), "/api/*", "/employee/*" );
        servletRegistrationBean.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        
        final Map<String, String> params = new HashMap<String, String>();
        params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation", "org.spring.sec2.spring");
        params.put("dispatchOptionsRequest", "true");
        servletRegistrationBean.setInitParameters(params);

        servletRegistrationBean.setLoadOnStartup(1);
        
        return servletRegistrationBean;
    }
    
}
