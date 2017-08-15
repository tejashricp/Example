package designpattern.AbstractFactoryPattern.sony;


import designpattern.AbstractFactoryPattern.factory.AbstractFactory;
import designpattern.AbstractFactoryPattern.factory.HeadPhone;
import designpattern.AbstractFactoryPattern.factory.TV;

/**
 * Created by TPathrikar on 7/13/2017.
 */
public class SonyFactory extends AbstractFactory {

    @Override
    public HeadPhone getHeadphone() {
        return null;
    }

    @Override
    public TV getTV() {
        return null;
    }
}
