package net.likelion.bebc25.spring.aop.staticproxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        Car target = new GasolineCar();
        Car logProxy = new LogProxy(target);
        return logProxy;
    }

    @Bean
    public Driver driver(Car car) {
        return new Driver(car);
    }
}