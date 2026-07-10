package net.likelion.bebc25.oop.after;

public class AfterTest {
    void main() {
        Car car = new GasolineCar();

        Driver driver = new Driver(car);
        driver.driveCar();
    }
}
