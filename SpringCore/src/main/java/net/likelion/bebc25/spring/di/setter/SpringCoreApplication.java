package net.likelion.bebc25.spring.di.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreApplication {
    void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver = context.getBean(Driver.class);

        driver.driveCar();

        driver.setCar(new HybridCar());
        driver.driveCar();
    }
}
