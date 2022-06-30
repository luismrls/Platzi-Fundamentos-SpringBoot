package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanMyBean() {
        return new MyBeanTwoImplement();
    }

    @Bean
    public MyOperation beanMyOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependecy beanMyOperationWithDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
