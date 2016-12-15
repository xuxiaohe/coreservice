package com.transn.houtai.conf;

import com.transn.houtai.util.SystemFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(SystemFilter myFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
        filterRegistrationBean.setFilter(myFilter);  
        filterRegistrationBean.setEnabled(true);  
        filterRegistrationBean.addUrlPatterns("/admin/*");
        return filterRegistrationBean;
    }     
}
