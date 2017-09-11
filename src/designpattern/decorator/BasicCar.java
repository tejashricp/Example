package designpattern.decorator;

/**
 * Created by TPathrikar on 9/10/2017.
 */
public class BasicCar implements Car{

    @Override
    public void assemble() {
        System.out.print("Adding features of basic car.");
    }
}
