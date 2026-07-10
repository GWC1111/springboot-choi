package net.likelion.bebc25.spring.aop.staticproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStaticProxyApplication {
    void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver = context.getBean(Driver.class);

        driver.driveCar();
    }
}
