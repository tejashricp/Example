package designpattern.AbstractFactoryPattern.factory;

import designpattern.AbstractFactoryPattern.philips.PhilipsFactory;
import designpattern.AbstractFactoryPattern.sony.SonyFactory;


/*
*
* 1.Map out a matrix of "platforms" versus "products".
2.Define a factory interface that consists of a factory method per product.
3.Define a factory derived class for each platform that encapsulates all references
to the  new operator.
*
* */
/**
 * Created by TPathrikar on 7/13/2017.
 */
public abstract class AbstractFactory {
    private static final SonyFactory SONY_FACTORY = new SonyFactory();
    private static final PhilipsFactory PHILIPS_FACTORY = new PhilipsFactory();

    public static AbstractFactory getFactory(FactoryName factoryName){
        switch (factoryName){
            case PHILIPS:
                return PHILIPS_FACTORY;
            case SONY:
                return SONY_FACTORY;
        }
        return null;
    }

    public abstract HeadPhone getHeadphone();
    public abstract TV getTV();
}
