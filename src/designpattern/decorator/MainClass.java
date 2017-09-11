package designpattern.decorator;

import designpattern.decorator.decorator.LuxuryCar;
import designpattern.decorator.decorator.SportsCar;

/**
 * Created by TPathrikar on 9/10/2017.
 */
public class MainClass {
    public static void main(String[] args) {
        Car car = new LuxuryCar(new SportsCar(new BasicCar()));
        car.assemble();
    }
}
