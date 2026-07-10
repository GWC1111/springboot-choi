package net.likelion.bebc25.spring.aop.dynamicproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDynamicProxyApplication {
    void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver = context.getBean(Driver.class);

        driver.driveCar();
    }
}
