package designpattern.BuilderPattern;

import designpattern.BuilderPattern.pizzabuilders.HawaiinPizzaBuilder;

/**
 * Created by TPathrikar on 9/5/2017.
 */
public class MainClass {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder pizzaBuilder = new HawaiinPizzaBuilder();
        waiter.setPizzaBuilder(pizzaBuilder);
        waiter.constructPizza();
        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }
}
