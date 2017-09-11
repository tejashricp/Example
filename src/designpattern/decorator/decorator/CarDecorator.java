package designpattern.decorator.decorator;

import designpattern.decorator.Car;

/**
 * Created by TPathrikar on 9/10/2017.
 */
public class CarDecorator implements Car {
    Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}
