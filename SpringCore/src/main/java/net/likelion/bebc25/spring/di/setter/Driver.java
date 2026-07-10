package net.likelion.bebc25.spring.di.setter;

public class Driver {
    private Car car;

    public void setCar(Car car) {
        System.out.println("Setter Injection");
        this.car = car;
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
