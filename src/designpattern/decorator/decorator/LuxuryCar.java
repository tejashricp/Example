package designpattern.decorator.decorator;

import designpattern.decorator.Car;

/**
 * Created by TPathrikar on 9/10/2017.
 */
public class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car) {
        super(car);
    }

    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}
