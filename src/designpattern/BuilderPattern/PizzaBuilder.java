package designpattern.BuilderPattern;

/**
 * Created by TPathrikar on 9/5/2017.
 */
public abstract class PizzaBuilder {
    public Pizza pizza;

    public void createNewPizzaProduct(){
        pizza = new Pizza();
    }

    public Pizza getPizza() {
        return pizza;
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();

}
