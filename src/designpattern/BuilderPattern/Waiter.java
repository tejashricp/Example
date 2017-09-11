package designpattern.BuilderPattern;

/**
 * Created by TPathrikar on 9/5/2017.
 */
public class Waiter {
    PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza (){
        return pizzaBuilder.getPizza();
    }

    public void constructPizza(){
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
