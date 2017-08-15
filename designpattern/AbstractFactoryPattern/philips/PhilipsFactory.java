package com.teja.designpattern.AbstractFactoryPattern.philips;

import com.teja.designpattern.AbstractFactoryPattern.factory.AbstractFactory;
import com.teja.designpattern.AbstractFactoryPattern.factory.HeadPhone;
import com.teja.designpattern.AbstractFactoryPattern.factory.TV;

/**
 * Created by TPathrikar on 7/13/2017.
 */
public class PhilipsFactory extends AbstractFactory {
    @Override
    public HeadPhone getHeadphone() {
        return null;
    }

    @Override
    public TV getTV() {
        return null;
    }
}
