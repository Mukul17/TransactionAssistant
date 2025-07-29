package com.TransactionAssistant.TransactionAssistant.LifeCycleDemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemo implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor {

    private String javaVer;

    public String getJavaVer() {
        return javaVer;
    }

    @Value("${java.specification.version}")
    public void setJavaVer(String javaVer) {
        this.javaVer = javaVer;
        System.out.println("## 1 properties set . Java ver:"+this.javaVer);
    }

    public LifeCycleDemo(){
        System.out.println("## I'm in the LifeCycleBean Constructor ##");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## 3 BeanFactory Aware - Bean factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## 2 BeanNameAware My Bean Name is "+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## destroy method ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## 6 After properties set method");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## 4 ApplicationContextAware -Application context has been set");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post process Before Initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process After initilization ");
        return bean;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## 5 post construct--- the post construct annoted method has been called");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("## pre destroy method ");
    }

}
