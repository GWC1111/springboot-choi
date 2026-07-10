package net.likelion.bebc25.spring.aop.dynamicproxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        Car target = new GasolineCar();
        Car proxyCar = (Car)Proxy.newProxyInstance(
                Car.class.getClassLoader(),
                new Class[]{Car.class},
                new TimeCheckInvocationHandler(target)
        );

        return proxyCar;
    }

    @Bean
    public Driver driver(Car car) {
        return new Driver(car);
    }
}