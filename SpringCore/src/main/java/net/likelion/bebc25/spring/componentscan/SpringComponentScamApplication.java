package net.likelion.bebc25.spring.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringComponentScamApplication {
    void main() {

        try{
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            Driver driver = context.getBean(Driver.class);

            System.out.println("Driver 객체: " + driver.toString());

            driver.driveCar(100);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
