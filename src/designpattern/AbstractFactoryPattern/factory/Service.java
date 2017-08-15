package designpattern.AbstractFactoryPattern.factory;

/**
 * Created by TPathrikar on 7/13/2017.
 */
public class Service {

    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(FactoryName.SONY);
        HeadPhone sonyHeadPhone = factory.getHeadphone();
    }


}
