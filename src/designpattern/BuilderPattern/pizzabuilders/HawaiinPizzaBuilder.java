package designpattern.BuilderPattern.pizzabuilders;

import designpattern.BuilderPattern.PizzaBuilder;

/**
 * Created by TPathrikar on 9/5/2017.
 */
public class HawaiinPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough("dough set");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("set sauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("set topping");
    }
}
