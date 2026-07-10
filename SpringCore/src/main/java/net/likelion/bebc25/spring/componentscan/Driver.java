package net.likelion.bebc25.spring.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Autowired
    private Car car;

    Driver() {
        System.out.println("Driver 기본 생성자 호출됨.");
    }

    @Autowired
    Driver(@Qualifier("gasolineCar") Car car) {
        System.out.println("called Constructor Injection: " + car);
        this.car = car;
    }

    @Autowired
    public void setCar(Car car) {
        System.out.println("Setter Injection 호출됨.");
        this.car = car;
    }

    public void driveCar(int maxSpeed) {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
