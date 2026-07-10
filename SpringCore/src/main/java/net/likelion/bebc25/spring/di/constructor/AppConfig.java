package net.likelion.bebc25.spring.di.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Car car() {
//        return new GasolineCar();
        return new HybridCar();
    }

    @Bean
    public Driver driver(Car car) {
        return new Driver(car);
    }
}

// 스프링 컨테이너가 하는 일
//AppConfig config = new AppConfig();
//Car car = config.car();
//Driver driver = config.driver(car);